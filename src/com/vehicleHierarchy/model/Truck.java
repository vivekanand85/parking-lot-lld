package com.vehicleHierarchy.model;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.enumTypes.VehicleType;

public class Truck extends Vehicle {
	public Truck(String licensePlate) {
		super(licensePlate,VehicleType.TRUCK);
	}
	
	 public SpotType getRequiredSpotType() {
	        return SpotType.COMPACT;
	    }
}

