package com.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bms.dao.BusDao;
import com.bms.dto.UpdateBus;
import com.bms.entity.Bus;
import com.bms.exception.PrintExceptionMessage;

@Component
public class BusServiceImpl implements BusService {

	@Autowired
	BusDao busDao;
	
	public String addBus(Bus bus) {
		try {
			Bus bus1 = busDao.addOrUpdateBus(bus);
			return "Bus Successfully added.BusId = " + bus1.getBusId();
		} catch (Exception e) {
			return "Unable to add bus";
		}
	}

	public UpdateBus updateBus(Bus bus) {
		UpdateBus upbu = new UpdateBus();
		try {
			if (bus.getBusId() == 0) {
				throw new PrintExceptionMessage("Please mention busId");
			} else {
				Bus bs = busDao.addOrUpdateBus(bus);
				upbu.setMessage("Bus Updated Successfully");
				upbu.setBus(bs);
				return upbu;
			}
		} catch (Exception e) {
			upbu.setMessage(e.getMessage());
			return upbu;
		}
	}

	public Bus findBus(int busId) {
		return busDao.findBusByBusId(busId);
	}

}
