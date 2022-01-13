package com.abdulhalim.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long id;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private double amount;
}
