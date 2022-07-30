package com.bms.service;

import java.util.List;

import com.bms.dto.UpdateRoute;
import com.bms.entity.Bus;
import com.bms.entity.Route;

public interface RouteService {

	String addRoute(Route route);

	UpdateRoute updateRoute(Route route);

	Route findRoute(int routeId);

	List<Bus> findAllBuses(int routeId);
	
	List<String> viewAllOrigins();
	
	List<String> viewAllDestinations();
		
	List<Integer> viewAllRouteId();
}
