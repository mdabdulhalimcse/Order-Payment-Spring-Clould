package com.abdulhalim.service;

import com.abdulhalim.entity.Payment;
import com.abdulhalim.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public Payment findPaymentHistoryByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
