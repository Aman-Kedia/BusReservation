package com.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bms.dao.RouteDao;
import com.bms.dto.UpdateRoute;
import com.bms.entity.Bus;
import com.bms.entity.Route;
import com.bms.exception.PrintExceptionMessage;

@Component
@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	RouteDao routeDao;

	public String addRoute(Route route) {
		try {
			Route route1 = routeDao.addOrUpdateRoute(route);
			return "Route Successfully added. RouteId = " + route1.getRouteId();
		} catch (Exception e) {
			return "Unable to add route";
		}
	}

	public UpdateRoute updateRoute(Route route) {
		UpdateRoute upr = new UpdateRoute();
		try {
			if (route.getRouteId() == 0) {
				throw new PrintExceptionMessage("Please mention routeId");
			}else if (routeDao.findRouteByRouteId(route.getRouteId()) == null) {
				throw new PrintExceptionMessage("Route not found");
			}
			else {
				Route rt = routeDao.addOrUpdateRoute(route);
				upr.setMessage("Route Updated Successfully");
				upr.setRoute(rt);;
				return upr;
			}
		} catch (Exception e) {
			upr.setMessage(e.getMessage());
			return upr;
		}
	}

	public Route findRoute(int routeId) {
		return routeDao.findRouteByRouteId(routeId);
	}

	public List<Bus> findAllBuses(int routeId) {
		return routeDao.findAllBusesByRouteId(routeId);
	}

}
