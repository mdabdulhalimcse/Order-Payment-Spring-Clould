package com.abdulhalim.controller;

import com.abdulhalim.common.Payment;
import com.abdulhalim.common.TransactionRequest;
import com.abdulhalim.common.TransactionResponse;
import com.abdulhalim.entity.Order;
import com.abdulhalim.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return orderService.saveOrder(request);
    }
}
