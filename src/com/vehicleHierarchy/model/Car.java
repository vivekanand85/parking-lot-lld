package com.vehicleHierarchy.model;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.enumTypes.VehicleType;

public class Car extends Vehicle {

	public Car(String licensePlate) {
		super(licensePlate,VehicleType.CAR);
	}
	
	 public SpotType getRequiredSpotType() {
	        return SpotType.COMPACT;
	    }
}
