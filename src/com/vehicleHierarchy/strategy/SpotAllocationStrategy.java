package com.vehicleHierarchy.strategy;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.model.Vehicle;

public interface SpotAllocationStrategy {
	SpotType getRequiredSpotType(Vehicle vehicle);
}