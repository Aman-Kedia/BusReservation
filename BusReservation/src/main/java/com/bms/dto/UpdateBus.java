package com.bms.dto;

import com.bms.entity.Bus;

public class UpdateBus {
	
	String message;
	Bus bus;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
}
