package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.UpdateBooking;
import com.bms.dto.UpdateBus;
import com.bms.dto.UpdatePassenger;
import com.bms.dto.UpdateRoute;
import com.bms.entity.Booking;
import com.bms.entity.Bus;
import com.bms.entity.Passenger;
import com.bms.entity.Route;
import com.bms.entity.User;
import com.bms.service.BookingService;
import com.bms.service.BusService;
import com.bms.service.PassengerService;
import com.bms.service.RouteService;
import com.bms.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	BusService busService;
	
	@Autowired
	RouteService routeService;

//-----------------------------------------------USER ENTITY--------------------------------------------------------------------

//	http://localhost:9090/admin/find_user/1008                                                             [15]
		
//	TESTED IN SPRING BOOT
	@RequestMapping(value = "/finduser/{user_id}", method = RequestMethod.GET)
	public User findUser(@PathVariable int user_id) {
		return userService.findUser(user_id);
	}
	
//	http://localhost:9090/admin/view_users                                                                 [16]

	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	public List<User> viewAll() {
		return userService.viewAllUsers();
	}

//  http://localhost:9090/admin/get_first_name/1004                                                        [17]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/getname/{userId}", method = RequestMethod.GET)
	public String getUserName(@PathVariable int userId) {
		return userService.getUserName(userId);
	}
	
//----------------------------------------------BOOKING ENTITY-----------------------------------------------------------------------
	
//	http://localhost:9090/admin/update_booking                                                              [12]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/updatebooking", method = RequestMethod.PUT)
	public UpdateBooking updateBooking(@RequestBody Booking booking) {
		return bookingService.updatebooking(booking);
	}
	
//	http://localhost:9090/admin/find_booking/2009                                                           [13]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/findbooking/{bookingId}", method = RequestMethod.GET)
	public Booking findBooking(@PathVariable int bookingId) {
		return bookingService.findBooking(bookingId);
	}
	
//	http://localhost:9090/admin/find_passengers_by_bookingId/2005                                           [21]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/findpassengerbybookingId/{bookingId}", method = RequestMethod.GET)
	public List<Passenger> findPassengersByBooking(@PathVariable int bookingId) {
		return bookingService.findPassengersByBookingId(bookingId);
	}
	
//	http://localhost:9090/admin/find_bookings_by_busId/4027                                                  [14]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/findbookingsbybusId/{busId}", method = RequestMethod.GET)
	public List<Booking> findBookings(@PathVariable int busId) {
		return bookingService.findAllBookingsbyBusId(busId);
	}
	
	
//	http://localhost:9090/admin/cancel_booking/2009                                                          [22]
		
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/cancelbooking/{bookingId}", method = RequestMethod.PUT)
	public void cancelBooking(@PathVariable int bookingId) {
		bookingService.cancelBooking(bookingId);
	}
	
//--------------------------------------------PASSENGER ENTITY------------------------------------------------------------------
	
//	http://localhost:9090/admin/add_passenger                                                                    [18]
	
//	{
//	    "firstName":"Aman",
//	    "lastName":"Kedia",
//	    "dateOfBirth":"21-07-2000",
//	    "phoneNo":"9876543210",
//	    "emailId":"aman@lti.com",
//	    "seatNo":12345,
//	    "travelDate":"21-07-2020",
//        "booking":{
//            "bookingId":2009,
//            "bookingFare":99999.0,
//            "bookingDate":"28-11-2000",
//            "bookingStatus":0,
//            "noOfPassengers":1,
//            "user":{
//                "userId":1008,
//                "firstName":"Aman",
//                "lastName":"Kedia",
//                "dateOfBirth":"21-07-2000",
//                "phoneNo":"9999900000",
//                "gender":"Male",
//                "email":"aman@lti.com",
//                "isAdmin":1,
//                "walletBalance":100.0,
//                "userPassword":"Aman@123"
//                },
//            "bus":{
//                "busId":4027,
//                "busNo":"MH98FG1828",
//                "bustype":"Non_AC",
//                "busFare":1200.0,
//                "capacity":8,
//                "arrivalTime":"14:00",
//                "departureTime":"19:00",
//                "route":{"routeId":5010,"origin":"Chennai","destination":"Bangalore"}
//                }
//            }
//				"bus":{
//			      "busId":4027,
//			      "busNo":"MH98FG1828",
//			      "bustype":"Non_AC",
//			      "busFare":1200.0,
//			      "capacity":8,
//			      "arrivalTime":"14:00",
//			      "departureTime":"19:00",
//			      "route":{"routeId":5010,"origin":"Chennai","destination":"Bangalore"}
//			      }
//	 }
	
	//TESTED IN SPRING BOOT 
	@RequestMapping(value = "/addpassenger", method = RequestMethod.POST)
	public String addPassenger(@RequestBody Passenger passenger) {
		String message = passengerService.addPassenger(passenger);
		return message;
	}
	
//	http://localhost:9090/admin/update_passenger                                                             [19]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/updatepassenger", method = RequestMethod.PUT)
	public UpdatePassenger updatePassenger(@RequestBody Passenger passenger) {
		return passengerService.updatePassenger(passenger);
	}
	
//	http://localhost:9090/admin/find_passengers_by_bus/4018                                                  [20]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/findpassengersbybus/{busId}", method = RequestMethod.GET)
	public List<Passenger> findPassengersByBus(@PathVariable int busId) {
		return passengerService.findPassengersByBusId(busId);
	}
	
//----------------------------------------------BUS ENTITY----------------------------------------------------------------------------
	
//	   {
//	       "busNo":"MH98FG1827",
//	       "bustype":1,
//	       "busFare":1200,
//	       "capacity":8,
//	       "arrivalTime":"14:00",
//	       "departureTime":"19:00",
//	       "route":{
//	           "routeId":5006,
//	           "origin":"Chennai",
//	           "destination":"Bangalore"
//	       }
//		}
	
//	http://localhost:9090/admin/add_bus                                                                [04]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/addbus", method = RequestMethod.POST)
	public String addBus(@RequestBody Bus bus) {
		String message = busService.addBus(bus);
		return message;
	}
	
//	http://localhost:9090/admin/update_bus                                                             [06]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/updatebus", method = RequestMethod.PUT)
	public UpdateBus updateBus(@RequestBody Bus bus) {
		return busService.updateBus(bus);
	}
	
//	http://localhost:9090/admin/find_bus/4019                                                           [07]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/findbus/{busId}", method = RequestMethod.GET)
	public Bus findBus(@PathVariable int busId) {
		return busService.findBus(busId);
	}
	
//-------------------------------------------------------ROUTE ENTITY--------------------------------------------------------------------
	
//	{
//	    "origin": "Chennai",
//	    "destination": "Bangalore",
//	}
	
//	http://localhost:9090/admin/add_route                                                     [01]
	
//  TESTED IN SPRING BOOT
	@RequestMapping(value = "/addroute", method = RequestMethod.POST)
	public String addRoute(@RequestBody Route route) {
		String message = routeService.addRoute(route);
		return message;
	}
	
//	{ 
//    "routeId":5008,
//    "origin":"Chennai",
//    "destination":"Bangalore",
//  }	
		
//	http://localhost:9090/admin/update_route                                                  [02]
	
//  TESTED IN SPRING BOOT
	@RequestMapping(value = "/updateroute", method = RequestMethod.PUT)
	public UpdateRoute updateRoute(@RequestBody Route route) {
		return routeService.updateRoute(route);
	}
	
//	http://localhost:9090/admin/find_route/5008                                               [03]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/findroute/{routeId}", method = RequestMethod.GET)
	public Route findRoute(@PathVariable int routeId) {
		return routeService.findRoute(routeId);
	}
	

//	http://localhost:9090/admin/find_all_buses/5012                                            [05]
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/findallbuses/{routeId}", method = RequestMethod.GET)         
	public List<Bus> findAllBuses(@PathVariable int routeId) {
		return routeService.findAllBuses(routeId);
	}
	
//-----------------------------------------------EXTRAS----------------------------------------------------------------
	
	
	
	
}
