package com.example.paymentapp.controller;

import com.example.paymentapp.model.CreditCardPayment;
import com.example.paymentapp.model.PayPalPayment;
import com.example.paymentapp.model.Payment;
import com.example.paymentapp.service.PaymentService;
import com.example.paymentapp.suport.ApiResponse;
import com.example.paymentapp.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String teste(){
        return "Tudo certo por aqui!";
    }

    @PostMapping("/credit-card")
    public ResponseEntity<ApiResponse<Payment>> payWithCreditCard(@RequestParam double amount, @RequestParam String cardNumber){

        Payment payment = new CreditCardPayment(amount, cardNumber);
        paymentService.processPayment(payment);

        return ResponseEntity.ok(ResponseUtil.success("User retrieved successfuly", payment, null)) ;
    }

    @PostMapping("/paypal")
    public String payWithPayPal(@RequestParam double amount, @RequestParam String email){
        Payment payment = new PayPalPayment(amount, email);
        return paymentService.processPayment(payment);
    }
}
