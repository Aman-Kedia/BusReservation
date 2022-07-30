package com.bms.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Bus;
import com.bms.entity.Route;

@Component
public class RouteDaoImpl implements RouteDao {
	
	@PersistenceContext
	EntityManager em;
	
	//TESTED IN SPRING BOOT
    @Transactional
    public Route addOrUpdateRoute(Route route) {
        return em.merge(route);
    }
 
    //TESTED IN SPRING BOOT
    public Route findRouteByRouteId(int routeId) {
        return em.find(Route.class, routeId);
    }
 
    //TESTED IN SPRING BOOT
    public List<Bus> findAllBusesByRouteId(int routeId) {
        Route route = findRouteByRouteId(routeId);
        List<Bus> buses = route.getBus();
        return buses;
    }

    //EXTRAS
	public Route findRouteIdByOriginDestination(String orgin, String destination) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> viewAllOrigins() {
		Query query = em.createQuery("select r.origin from Route r");
		return (List<String>)query.getResultList().stream().distinct().collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public List<String> viewAllDestinations() {
		Query query = em.createQuery("select r.destination from Route r");
		return (List<String>)query.getResultList().stream().distinct().collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public List<Integer> viewAllRouteId() {
		Query query = em.createQuery("select r.routeId from Route r");
		return query.getResultList();
	}

}
