package com.bms.dao;

import java.util.List;

import com.bms.entity.Passenger;

public interface PassengerDao {
	Passenger addPassenger(Passenger passenger);

	List<Passenger> findAllPassengersByBusId(int busId);
	
	List<Object[]> findAllSeatsBooked(int busId, String travelDate);
}
