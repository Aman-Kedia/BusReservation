package com.bms.service;

import java.util.List;

import com.bms.dto.UpdateBus;
import com.bms.entity.Bus;

public interface BusService {
	String addBus(Bus bus);
	
	UpdateBus updateBus(Bus bus);
	
	Bus findBus(int busId);
	
	List<Integer> viewAllBusId();
	
	List<Bus> findBusByOriginDestination(String origin, String destination);
}
