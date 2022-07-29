package com.bms.dao;

import java.util.List;

import com.bms.entity.Booking;
import com.bms.entity.Passenger;

public interface BookingDao {
	Booking addBooking(Booking booking);

	Booking findBookingByBookingId(int bookingId);

	List<Passenger> findAllPassengersByBookingId(int bookingId);

	List<Booking> findAllBookingsByBusId(int BusId);

	Booking cancelBooking(int BookingId);		//return type booking
}
