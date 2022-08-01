package com.bms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bms.dao.BookingDao;
import com.bms.dto.UpdateBooking;
import com.bms.entity.Booking;
import com.bms.entity.Passenger;
import com.bms.exception.PrintExceptionMessage;

@Component
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao bookingDao;

	public Booking addBooking(Booking booking) {
		try {
			Booking booking1 = bookingDao.addBooking(booking);
			return booking1;
		} catch (Exception e) {
			return null;
		}
	}

	public UpdateBooking updatebooking(Booking booking) {
		UpdateBooking upb = new UpdateBooking();
		try {
			if (booking.getBookingId() == 0) {
				throw new PrintExceptionMessage("Please mention bookingId");
			} else if (bookingDao.findBookingByBookingId(booking.getBookingId()) == null) {
				throw new PrintExceptionMessage("Booking not found");
			} else {
				Booking bk = bookingDao.addBooking(booking);
				upb.setMessage("Booking Updated Successfully");
				upb.setBooking(bk);
				return upb;
			}
		} catch (Exception e) {
			upb.setMessage(e.getMessage());
			return upb;
		}
	}

	public Booking findBooking(int bookingId) {
		return bookingDao.findBookingByBookingId(bookingId);
	}

	public List<Passenger> findPassengersByBookingId(int bookingId) {
		return bookingDao.findAllPassengersByBookingId(bookingId);
	}

	public List<Booking> findAllBookingsbyBusId(int busId) {
		return bookingDao.findAllBookingsByBusId(busId);
	}

	public void cancelBooking(int bookingId) {
		bookingDao.cancelBooking(bookingId);
	}

	public List<Booking> viewAllBookingsByUserId(int userId) {
		return bookingDao.viewAllBookingsByUserId(userId);
	}

}
