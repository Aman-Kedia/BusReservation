package com.bms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bms.entity.Passenger;

public interface PassengerDao {
	Passenger addPassenger(Passenger passenger);

	List<Passenger> findAllPassengersByBusId(int busId);
	
	List<String> findAllSeatsBooked(int busId, String travelDate);
}
