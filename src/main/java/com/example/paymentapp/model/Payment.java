package com.example.paymentapp.model;

public sealed interface Payment permits CreditCardPayment, PayPalPayment{
    double amount();
}
