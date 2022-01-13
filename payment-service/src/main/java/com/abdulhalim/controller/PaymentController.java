package com.abdulhalim.controller;

import com.abdulhalim.entity.Payment;
import com.abdulhalim.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){

        payment.setPaymentStatus(paymentProcessing());
        return paymentService.doPayment(payment);
    }

    public String paymentProcessing(){
        //api call should be 3rd party payment gateway
       return new Random().nextBoolean()?"success" : "false";
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable Long orderId){
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }



}
