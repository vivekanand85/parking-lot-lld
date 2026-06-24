package com.vehicleHierarchy.strategy;

public class CarPricingStrategy implements PricingStrategy {
    public double calculateFee(long durationInMinutes) {
        return Math.ceil(durationInMinutes / 60.0) * 50; // ₹50/hour
    }
}
