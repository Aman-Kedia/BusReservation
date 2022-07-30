package com.bms.dao;

import java.util.List;

import com.bms.entity.Bus;

public interface BusDao {
	Bus addOrUpdateBus(Bus bus);

	Bus findBusByBusId(int busId);

	List<Bus> findBusByOriginDestination(String origin, String destination);
	
	List<Integer> viewAllBusId();	
}
