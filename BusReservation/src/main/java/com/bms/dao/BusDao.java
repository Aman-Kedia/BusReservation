package com.bms.dao;

import com.bms.entity.Bus;

public interface BusDao {
	Bus addOrUpdateBus(Bus bus);

	Bus findBusByBusId(int busId);

	Bus findBusByRouteId(int routeId);
	
}
