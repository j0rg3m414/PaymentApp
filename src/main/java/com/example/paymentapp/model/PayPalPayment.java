package com.example.paymentapp.model;

public record PayPalPayment(double amount, String email) implements Payment {
}
