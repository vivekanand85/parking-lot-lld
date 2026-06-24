package com.vehicleHierarchy.model;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.enumTypes.VehicleType;

public class ElectricCar extends Vehicle {
    public ElectricCar(String licensePlate) {
		super(licensePlate, VehicleType.EV);
	}

	public SpotType getRequiredSpotType() {
        return SpotType.EV_CHARGING; // own logic, ZERO existing code touched!
    }
}
