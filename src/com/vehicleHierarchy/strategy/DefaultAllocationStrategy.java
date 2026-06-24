package com.vehicleHierarchy.strategy;

import java.util.*;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.enumTypes.VehicleType;
import com.vehicleHierarchy.model.Vehicle;

public class DefaultAllocationStrategy implements SpotAllocationStrategy {
    private static final Map<VehicleType, SpotType> mapping = new HashMap<>();
    
    static {
        mapping.put(VehicleType.BIKE, SpotType.MOTORCYCLE);
        mapping.put(VehicleType.CAR, SpotType.COMPACT);
        mapping.put(VehicleType.TRUCK, SpotType.LARGE);
        mapping.put(VehicleType.EV,SpotType.EV_CHARGING);
        // Adding ELECTRIC_CAR still touches this static block — NOT fully OCP-clean either!
    }

    public SpotType getRequiredSpotType(Vehicle vehicle) {
        return mapping.get(vehicle.getType());
    }
}
