package com.vehicleHierarchy.strategy;

public class BikePricingStrategy implements PricingStrategy {
    public double calculateFee(long durationInMinutes) {
        return Math.ceil(durationInMinutes / 60.0) * 20; // ₹20/hour
    }
}
