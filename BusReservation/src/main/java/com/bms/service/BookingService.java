package com.bms.service;

import java.util.List;

import com.bms.dto.UpdateBooking;
import com.bms.entity.Booking;
import com.bms.entity.Passenger;

public interface BookingService {
	
	Booking addBooking(Booking booking);
	
	UpdateBooking updatebooking (Booking booking);
	
	Booking findBooking(int bookingId);
	
	List<Passenger> findPassengersByBookingId(int bookingId);
	
	List<Booking> findAllBookingsbyBusId(int busId);
	
	void cancelBooking(int bookingId);
	
	List<Booking> viewAllBookingsByUserId(int userId);

}
