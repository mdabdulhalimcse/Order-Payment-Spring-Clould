package com.abdulhalim.service;

import com.abdulhalim.common.Payment;
import com.abdulhalim.common.TransactionRequest;
import com.abdulhalim.common.TransactionResponse;
import com.abdulhalim.entity.Order;
import com.abdulhalim.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){

        String response = "";

        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
            //rest call
        Payment paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/doPayment",payment,Payment.class);

       response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api, order added to cart";
         orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
