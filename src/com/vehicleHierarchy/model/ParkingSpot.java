package com.vehicleHierarchy.model;

import com.vehicleHierarchy.enumTypes.SpotStatus;
import com.vehicleHierarchy.enumTypes.SpotType;

public class ParkingSpot {

	private String spotId;
	private SpotType spotType;
	private SpotStatus status;
	private Vehicle parkedVehicle;
	
	public ParkingSpot(String spotId,SpotType spotType) {
		this.spotId=spotId;
		this.spotType=spotType;
		this.status=SpotStatus.FREE;
	}
	public boolean isFree() {
        return status == SpotStatus.FREE;
    }
	
	public void parkVehicle(Vehicle vehicle) {
		this.parkedVehicle=vehicle;
		this.status=SpotStatus.OCCUPIED;
	}
	
	 public void removeVehicle() {
	        this.parkedVehicle = null;
	        this.status = SpotStatus.FREE;
	    }
	    public SpotType getSpotType() { return spotType; }
	    public String getSpotId() { return spotId; }
}
