package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.LoginDto;
import com.bms.dto.UpdateUser;
import com.bms.entity.Booking;
import com.bms.entity.User;
import com.bms.service.BookingService;
import com.bms.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;

// --------------------------------------------------USER ENTITY-----------------------------------------------------------

//	http://localhost:9090/user/signup_user                                                               [8]
	
//	{
//	    "firstName":"Aman",
//	    "lastName":"Kedia",
//	    "dateOfBirth":"21-07-2000",
//	    "phoneNo":"9999900000",
//	    "gender":0,
//	    "email":"aman@lti.com",
//	    "isAdmin":"false",
//	    "walletBalance":100,
//	    "userPassword":"Aman@123"
//	}
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@RequestBody User user) {
		String message = userService.signUp(user);
		return message;
	}

//	http://localhost:9090/user/update_user	                                                                [9]
	
//	{
//	    "userId":"1005",
//	    "firstName":"Aman",
//	    "lastName":"Kedia",
//	    "dateOfBirth":"21-07-2000",
//	    "phoneNo":"9876543210",
//	    "gender":0,
//	    "email":"aman@lti.com",
//	    "isAdmin":xxxxxx,
//	    "walletBalance":123451,
//	    "userPassword":"Aman@123"
//	}
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public UpdateUser update(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
//	http://localhost:9090/user/user_login                                                                    [10]
	
//	{
//	    "email":"aman@lti.com",
//	    "password":"Aman@123"
//	}
	
	//TESTED IN SPRING BOOT
	@PostMapping(value = "/login")
	public boolean login(@RequestBody LoginDto loginDto) {
		return userService.userLogin(loginDto.getEmail(), loginDto.getPassword());
	}
	
//--------------------------------------------------BOOKING ENTITY-------------------------------------------------------------
	
//	http://localhost:9090/user/add_booking                                                                    [11]
	
//	{
//	    "bookingFare":224.34,
//	    "bookingDate":"28-11-1999",
//	    "bookingStatus":0,
//	    "noOfPassengers":1,
//	    "bus":{
//            "busId":4027,
//            "busNo":"MH98FG1828",
//            "bustype":1,
//            "busFare":1200.0,
//            "capacity":8,
//            "arrivalTime":"14:00",
//            "departureTime":"19:00",
//            "route":{"routeId":5010,"origin":"Chennai","destination":"Bangalore"}
//        },
//        "user":{
//            "userId":1008,
//            "firstName":"Aman",
//            "lastName":"Kedia",
//            "dateOfBirth":"21-07-2000",
//            "phoneNo":"9999900000",
//            "gender":"Male",
//            "email":"aman@lti.com",
//            "isAdmin":1,
//            "walletBalance":100.0,
//            "userPassword":"Aman@123"
//        }
//	}
	
	//TESTED IN SPRING BOOT
	@RequestMapping(value = "/addbooking", method = RequestMethod.POST)
	public String addBooking(@RequestBody Booking booking) {
		String message = bookingService.addBooking(booking);
		return message;
	}
	
//-------------------------------------------PASSENGER ENTITY-------------------------------------------------------------
	
//----------------------------------------------BUS ENTITY-----------------------------------------------------------------
	
//---------------------------------------------ROUTE ENTITY-----------------------------------------------------------------
	
//------------------------------------------------EXTRAS---------------------------------------------------------------------

}
