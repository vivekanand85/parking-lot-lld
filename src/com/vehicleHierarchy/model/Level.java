package com.vehicleHierarchy.model;

import java.util.*;

import com.vehicleHierarchy.enumTypes.SpotType;

public class Level {

	   private int levelNumber;
	   private List<ParkingSpot> spots;
	    
	   public Level(int levelNumber, List<ParkingSpot> spots) {
	        this.levelNumber = levelNumber;
	        this.spots = spots;
	    }
	   
	    public ParkingSpot findFreeSpot(SpotType requiredType) {
	    	for (ParkingSpot spot : spots) {
	    		if(spot.isFree() && spot.getSpotType()==requiredType) {
	    			return spot;
	    		}
	    	}
	    	return null;
	    }
	    
	    public int getLevelNumber() {
	    	return levelNumber;
	    }
}
