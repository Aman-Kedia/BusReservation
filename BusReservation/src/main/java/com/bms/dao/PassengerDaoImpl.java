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

}
