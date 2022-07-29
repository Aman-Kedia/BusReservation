package com.bms.dto;

import com.bms.entity.Route;

public class UpdateRoute {
	
	String message;
	Route route;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
}
