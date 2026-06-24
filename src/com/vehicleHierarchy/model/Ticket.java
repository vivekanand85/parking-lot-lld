package com.vehicleHierarchy.model;

import java.time.*;
import java.time.LocalDateTime;

public class Ticket {

	  private String ticketId;
	    private Vehicle vehicle;
	    private ParkingSpot spot;
	    private LocalDateTime entryTime;
	    private LocalDateTime exitTime;
	    
	    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
	        this.ticketId = ticketId;
	        this.vehicle = vehicle;
	        this.spot = spot;
	        this.entryTime = LocalDateTime.now();
	    }
	    public void markExit() {
	        this.exitTime = LocalDateTime.now();
	    }
	    
	    public long getDurationInMinutes() {
	        return Duration.between(entryTime, exitTime).toMinutes();
	    }
	    

	    public Vehicle getVehicle() { return vehicle; }
	    public ParkingSpot getSpot() { return spot; }
}
