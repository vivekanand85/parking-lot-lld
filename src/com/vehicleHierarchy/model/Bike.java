package com.vehicleHierarchy.model;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.enumTypes.VehicleType;

public class Bike extends Vehicle {

	public Bike(String licensePlate) {
		super(licensePlate,VehicleType.BIKE);
	}
	 public SpotType getRequiredSpotType() {
	        return SpotType.MOTORCYCLE;
	    }
}
