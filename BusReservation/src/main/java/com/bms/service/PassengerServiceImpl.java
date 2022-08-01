package com.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bms.dao.PassengerDao;
import com.bms.dto.UpdatePassenger;
import com.bms.entity.Passenger;
import com.bms.exception.PrintExceptionMessage;

@Component
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerDao passengerDao;
	
	public String addPassenger(Passenger passenger) {
		try {
			Passenger passenger1 = passengerDao.addPassenger(passenger);
			return "Passenger Successfully added.Your passengerId = " + passenger1.getPassengerId();
		} catch (Exception e) {
//			return "Unable to add passenger";
			return e.getMessage();
		}
	}

	public UpdatePassenger updatePassenger(Passenger passenger) {
		UpdatePassenger upp = new UpdatePassenger();
		try {
			if (passenger.getPassengerId() == 0) {
				throw new PrintExceptionMessage("Please mention passengerId");
			} else {
				Passenger pr = passengerDao.addPassenger(passenger);
				upp.setMessage("Passenger Updated Successfully");
				upp.setPassenger(pr);
				return upp;
			}
		} catch (Exception e) {
			upp.setMessage(e.getMessage());
			return upp;
		}
	}

	public List<Passenger> findPassengersByBusId(int busId) {
		return passengerDao.findAllPassengersByBusId(busId);
	}
	
	public List<String> findAllSeatsBooked(int busId, String travelDate) {
		return passengerDao.findAllSeatsBooked(busId, travelDate);
	}

}
