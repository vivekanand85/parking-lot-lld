package com.vehicleHierarchy;

import java.util.*;

import com.vehicleHierarchy.enumTypes.SpotType;
import com.vehicleHierarchy.model.ElectricCar;
import com.vehicleHierarchy.model.Level;
import com.vehicleHierarchy.model.ParkingSpot;
import com.vehicleHierarchy.model.Ticket;
import com.vehicleHierarchy.model.Vehicle;

public class ParkingLotApp {

	public static void main(String[] args) {
		ParkingLot parkingLot = ParkingLot.getInstance();
		List<ParkingSpot> level1Spots = Arrays.asList(
	            new ParkingSpot("L1-C1", SpotType.COMPACT),
	            new ParkingSpot("L1-M1", SpotType.MOTORCYCLE),
	            new ParkingSpot("L1-L1", SpotType.LARGE),
	            new ParkingSpot("L1-M1", SpotType.EV_CHARGING)
	        );
		  parkingLot.addLevel(new Level(1, level1Spots));

//		  Vehicle car = new Car("KA-01-1234");
//		  Ticket ticket = parkingLot.parkVehicle(car);
		  
		  
		  
//		  Vehicle truck = new Truck("KA-01-12344");
//		  Ticket ticket1 = parkingLot.parkVehicle(truck);
		  
		  Vehicle ev=new ElectricCar("EV-10-45WE");
		 
		  Ticket ticket2=parkingLot.parkVehicle(ev);
//		  ticket2.markExit();
		  System.out.println(ticket2);
		  
		  double fee =parkingLot.unparkVehicle("EV-10-45WE");
		     System.out.println("Total fee: ₹" + fee);
	}
}
