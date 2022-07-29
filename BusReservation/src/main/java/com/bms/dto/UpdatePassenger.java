package com.bms.dto;

import com.bms.entity.Passenger;

public class UpdatePassenger {
	
	String message;
	Passenger passenger;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
