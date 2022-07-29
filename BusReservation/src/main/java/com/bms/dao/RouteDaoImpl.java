package com.bms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
