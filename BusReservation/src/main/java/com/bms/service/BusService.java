package com.bms.service;

import com.bms.dto.UpdateBus;
import com.bms.entity.Bus;

public interface BusService {
	String addBus(Bus bus);
	
	UpdateBus updateBus(Bus bus);
	
	Bus findBus(int busId);
}
