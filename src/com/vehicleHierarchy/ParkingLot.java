package com.vehicleHierarchy;

import java.util.*;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.enumTypes.VehicleType;
import com.vehicleHierarchy.model.Level;
import com.vehicleHierarchy.model.ParkingSpot;
import com.vehicleHierarchy.model.Ticket;
import com.vehicleHierarchy.model.Vehicle;
import com.vehicleHierarchy.strategy.BikePricingStrategy;
import com.vehicleHierarchy.strategy.CarPricingStrategy;
import com.vehicleHierarchy.strategy.DefaultAllocationStrategy;
import com.vehicleHierarchy.strategy.EvStrategy;
import com.vehicleHierarchy.strategy.PricingStrategy;
import com.vehicleHierarchy.strategy.SpotAllocationStrategy;
import com.vehicleHierarchy.strategy.TruckPricingStrategy;

public class ParkingLot {
	  private static volatile ParkingLot instance;
	  private List<Level> levels;
	  private SpotAllocationStrategy allocationStrategy;
	  private Map<VehicleType, PricingStrategy> pricingStrategies;
	    private Map<String, Ticket> activeTickets; // ticketId -> Ticket

	  public static ParkingLot getInstance() {
		  if(instance==null) {
			  synchronized (ParkingLot.class) {
				if(instance==null) {
			  instance=new ParkingLot();
			}
		  
		  }
		 }
		  return instance;
	  }
	  public void addLevel(Level level) {
	        levels.add(level);
	    }
	  
	  
	    private ParkingLot() {
	        levels = new ArrayList<>();
	        allocationStrategy = new DefaultAllocationStrategy();
	        activeTickets = new HashMap<>();
	        
	        pricingStrategies = new HashMap<>();
	        pricingStrategies.put(VehicleType.CAR, new CarPricingStrategy());
	        pricingStrategies.put(VehicleType.BIKE, new BikePricingStrategy());
	        pricingStrategies.put(VehicleType.TRUCK, new TruckPricingStrategy());
	        pricingStrategies.put(VehicleType.EV, new EvStrategy());

	    }
	    public double unparkVehicle(String licensePlate) {
	    	Ticket ticket=activeTickets.get(licensePlate);
	    	if (ticket == null) {
	            throw new RuntimeException("No active ticket found!");
	        }
	    	  ticket.markExit();
	    	  
	    	  ticket.getSpot().removeVehicle();
	          PricingStrategy pricing = pricingStrategies.get(ticket.getVehicle().getType());
	          System.out.println(pricing);
	          double fee = pricing.calculateFee(ticket.getDurationInMinutes());
	          activeTickets.remove(licensePlate);
	          System.out.println("Fee for " + licensePlate + ": ₹" + fee);
	          return fee;

	    }
	    
	    public Ticket parkVehicle(Vehicle vehicle) {
	        SpotType requiredType = allocationStrategy.getRequiredSpotType(vehicle);
	        System.out.println(requiredType);
	        for(Level level:levels) {
	        	 ParkingSpot spot = level.findFreeSpot(requiredType);
	        	 if(spot!=null) {
	        		 spot.parkVehicle(vehicle);
	        		 Ticket ticket=new Ticket(UUID.randomUUID().toString(),
	        				 vehicle,spot);
	        		 System.out.println(ticket);
	        		 activeTickets.put(ticket.getVehicle().getLicensePlate(), ticket);
	                 System.out.println("Parked " + vehicle.getLicensePlate() + " at spot " + spot.getSpotId());
	                 return ticket;
	        	 }
	        }
	        throw new RuntimeException("Parking lot full for this vehicle type!");

	    }
	  }

