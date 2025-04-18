package com.example.paymentapp.service;

import com.example.paymentapp.model.CreditCardPayment;
import com.example.paymentapp.model.PayPalPayment;
import com.example.paymentapp.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(Payment payment){
        return switch (payment){
            case CreditCardPayment ccp ->
                    "Processing credit card payment of " + ccp.amount() + " with card number " + ccp.cardNumber();
            case PayPalPayment pp ->
                    "Processing PayPal payment of " + pp.amount() + " for e-mail " + pp.email();
            default -> "Unknow processing, search your adm to more information.";
        };
    }
}
