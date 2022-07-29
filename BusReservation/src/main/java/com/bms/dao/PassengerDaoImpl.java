package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Passenger;

@Component
public class PassengerDaoImpl implements PassengerDao {

	@PersistenceContext
	EntityManager em;

	//TESTED IN SPRING BOOT
	@Transactional
	public Passenger addPassenger(Passenger passenger) {
		return em.merge(passenger);
	}

	//TESTED IN SPRING BOOT
	public List<Passenger> findAllPassengersByBusId(int busId) {
		String jpql="SELECT p from Passenger p where p.bus.busId=:bid";
        TypedQuery<Passenger> qry=em.createQuery(jpql,Passenger.class);
        qry.setParameter("bid",busId);
        return qry.getResultList();
	}
	
	public List<Object[]> findAllSeatsBooked(int busId, String travelDate) {
		String jpql = "select p.seatNo from Passenger p where p.busId=busId and p.travelDate=travelDate";
		TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createQuery(jpql);
		query.setParameter("busId", busId);
		query.setParameter("travelDate", travelDate);
		return query.getResultList();
	}

}
