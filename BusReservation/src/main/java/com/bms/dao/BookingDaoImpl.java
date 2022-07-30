package com.bms.dao;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Booking;
import com.bms.entity.Passenger;

@Component
public class BookingDaoImpl implements BookingDao {
	
	@PersistenceContext
	EntityManager em;
		
	//TESTED IN SPRING BOOT
	@Transactional
	public Booking addBooking(Booking booking) {
		return em.merge(booking);
	}

	//TESTED IN SPRING BOOT
	public Booking findBookingByBookingId(int bookingId) {
		return em.find(Booking.class, bookingId);
	}

	//TESTED IN SPRING BOOT
	public List<Passenger> findAllPassengersByBookingId(int bookingId) {
		Booking bk = findBookingByBookingId(bookingId);
		List<Passenger> passengers = bk.getPassengers();
		return passengers;
	}

	//TESTED IN SPRING BOOT
	public List<Booking> findAllBookingsByBusId(int BusId) {
		String jpql = "select b from Booking b where b.bus.busId =: val";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("val", BusId);
		return query.getResultList();
	}

	//TESTED IN SPRING BOOT
	@Transactional
	public Booking cancelBooking(int BookingId) {
		Booking bk = findBookingByBookingId(BookingId);
		bk.setBookingStatus(0);
		return em.merge(bk);
	}

	//TESTED IN SPRING BOOT
	public List<Booking> viewAllBookingsByUserId(int userId) {
		String jpql = "select b from Booking b where b.user.userId=:uid";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("uid", userId);
		return query.getResultList();
	}

}
