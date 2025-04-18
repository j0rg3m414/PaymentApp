package com.example.paymentapp.model;

public record CreditCardPayment(double amount, String cardNumber) implements Payment {

}
