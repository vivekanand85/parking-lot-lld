package com.vehicleHierarchy.strategy;

public class TruckPricingStrategy implements PricingStrategy {
    public double calculateFee(long durationInMinutes) {
        return Math.ceil(durationInMinutes / 60.0) * 100; // ₹100/hour
    }
}
