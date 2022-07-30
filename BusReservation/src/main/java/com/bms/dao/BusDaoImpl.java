package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Bus;
import com.bms.entity.Route;

@Component
public class BusDaoImpl implements BusDao {

	@PersistenceContext
	EntityManager em;

	// TESTED IN SPRING BOOT
	@Transactional
	public Bus addOrUpdateBus(Bus bus) {
		return em.merge(bus);
	}

	// TESTED IN SPRING BOOT
	public Bus findBusByBusId(int busId) {
		return em.find(Bus.class, busId);
	}

	public List<Bus> findBusByOriginDestination(String origin, String destination) {
		Query query = em.createQuery("select b from Bus b where b.route.origin=:orgn and b.route.destination=:dest");
		query.setParameter("orgn", origin);
		query.setParameter("dest", destination);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Integer> viewAllBusId() {
		Query query = em.createQuery("select b.busId from Bus b");
		return query.getResultList();
	}

}