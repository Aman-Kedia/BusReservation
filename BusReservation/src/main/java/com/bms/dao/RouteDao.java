package com.bms.dao;

import java.util.List;

import com.bms.entity.Bus;
import com.bms.entity.Route;

public interface RouteDao {
	Route addOrUpdateRoute(Route route);

	Route findRouteByRouteId(int routeId);
	
	List<Bus> findAllBusesByRouteId(int routeId);
		
	List<String> viewAllOrigins();
	
	List<String> viewAllDestinations();
		
	List<Integer> viewAllRouteId();
}
