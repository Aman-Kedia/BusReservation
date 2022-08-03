package com.bms.service;

import java.util.List;

import com.bms.dto.UpdatePassenger;
import com.bms.entity.Passenger;

public interface PassengerService {
	
	String  addPassenger(Passenger passengers);
	
	UpdatePassenger updatePassenger(Passenger passenger);
	
	List<Passenger>  findPassengersByBusId(int busId);
	
	List<String> findAllSeatsBooked(int busId, String travelDate);
}
