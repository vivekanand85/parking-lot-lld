package com.vehicleHierarchy.strategy;

public class EvStrategy implements PricingStrategy {
    public double calculateFee(long durationInMinutes) {
        return Math.ceil(durationInMinutes / 60.0) * 30; // ₹20/hour
    }
}
