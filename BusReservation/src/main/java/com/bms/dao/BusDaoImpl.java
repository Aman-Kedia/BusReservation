package com.bms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Bus;

@Component
public class BusDaoImpl implements BusDao {

	@PersistenceContext
	EntityManager em;
	
	//TESTED IN SPRING BOOT
	@Transactional
	public Bus addOrUpdateBus(Bus bus) {
		return em.merge(bus);
	}
	
	//TESTED IN SPRING BOOT
	public Bus findBusByBusId(int busId) {
		return em.find(Bus.class, busId);
	}

	public Bus findBusByRouteId(int routeId) {
		return null;
	}
	
}