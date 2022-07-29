package com.bms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bms_booking")
public class Booking {

	@Id
	@SequenceGenerator(name = "bms_booking_seq", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(generator = "bms_booking_seq", strategy = GenerationType.SEQUENCE)
	int bookingId;

	String bookingDate;
	double bookingFare;
	int bookingStatus;

//	int noOfPassengers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	User user;

	@JsonIgnore
	@OneToMany(mappedBy = "booking", fetch = FetchType.EAGER)
	List<Passenger> passengers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "busId")
	Bus bus;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getBookingFare() {
		return bookingFare;
	}

	public void setBookingFare(double bookingFare) {
		this.bookingFare = bookingFare;
	}

	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

//	public int getNoOfPassengers() {
//		return noOfPassengers;
//	}
//
//	public void setNoOfPassengers(int noOfPassengers) {
//		this.noOfPassengers = noOfPassengers;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

}
