package com.bms.dto;

import com.bms.entity.Booking;

public class UpdateBooking {
	
	String message;
	Booking booking;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
