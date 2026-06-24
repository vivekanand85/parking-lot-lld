package com.vehicleHierarchy.model;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.enumTypes.VehicleType;

public abstract class Vehicle {

	private String licensePlate;
	private VehicleType type;
	public abstract SpotType getRequiredSpotType();
	public Vehicle(String licensePlate,VehicleType type) {
		this.licensePlate=licensePlate;
		this.type=type;
	}
	public VehicleType getType() {
		return type;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
}
