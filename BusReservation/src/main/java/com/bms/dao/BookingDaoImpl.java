package com.bms.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.DateFormatter;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bms.entity.Booking;
import com.bms.entity.Passenger;

@Component
public class BookingDaoImpl implements BookingDao {
	
	@PersistenceContext
	EntityManager em;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM");
	LocalDate d = LocalDate.now();
	String month = d.format(dtf1);
		
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

	public int viewTodaysBookings() {
		String jpql = "select b from Booking b where b.bookingDate =: cd";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("cd", d.format(dtf));
		return query.getResultList().size();
	}
	
	public double viewTodaysRevenue() {
		Query query = em.createQuery("select sum(b.bookingFare) from Booking b where b.bookingDate =: cd");
		query.setParameter("cd", d.format(dtf));
		return (double)query.getSingleResult();
	}

	public int viewMonthlyBookings() {
		System.out.println(month);
		String jpql = "select b from Booking b where b.bookingDate like '"+month+"-%'";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		return query.getResultList().size();
	}

	public double viewMonthlyRevenue() {
		Query query = em.createQuery("select sum(b.bookingFare) from Booking b where b.bookingDate like '"+month+"-%'");
		return (double)query.getSingleResult();
	}
	
	public String findTravelDateByBookingId(int bookingId) {
		Booking bk = findBookingByBookingId(bookingId);
		List<Passenger> passengers = bk.getPassengers();
		String tDate = null;
		for(Passenger p:passengers) {
			tDate = p.getTravelDate();
		}
		System.out.println(tDate);
		return tDate;
	}

}
