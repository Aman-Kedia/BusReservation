package com.bms;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.print.Book;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bms.dao.BookingDao;
import com.bms.dao.BusDao;
import com.bms.dao.PassengerDao;
import com.bms.dao.RouteDao;
import com.bms.dao.UserDao;
import com.bms.entity.Booking;
import com.bms.entity.Bus;
import com.bms.entity.BusType;
import com.bms.entity.GenderType;
import com.bms.entity.Passenger;
import com.bms.entity.Route;
import com.bms.entity.User;

@SpringBootTest
class BusManagementSystemApplicationTests {

	@Autowired
	UserDao userDao;

	@Autowired

	BookingDao bookingDao;
	@Autowired

	BusDao busDao;

	@Autowired
	RouteDao routeDao;

	@Autowired
	PassengerDao passengerDao;

	// --------------------------------USER ENTITY
	// TESTS---------------------------------------------

	@Test
	public void addOrUpdateUserTest() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setDateOfBirth("21-05-1987");
		user.setPhoneNo("9879879871");
		user.setGender(GenderType.Male);
		user.setEmail("john@gmailhello.com");
		user.setIsAdmin(1);
		user.setWalletBalance(100);
		user.setPassword("John@123");

		User savedUser = userDao.addOrUpdateUser(user);
		assertNotNull(savedUser);
	}

	@Test
	public void findUserByUserIdTest() {
		User user = userDao.findUserByUserId(1007);
		System.out.println(user.getFirstName() + " " + user.getUserId());
	}

	@Test
	public void findUserByEmailIdTest() {
		User user = userDao.findUserByEmailId("mike@lti.com");
		System.out.println(user.getFirstName() + " " + user.getUserId());
	}

	@Test
	public void viewAllUsersTest() {
		List<User> users = userDao.viewAllUsers();
		for (User u : users) {
			System.out.println(u.getUserId() + " " + u.getFirstName());
		}
	}

	@Test
	public void loginTest() {
		boolean isValid = userDao.login("john@gmailhello.com", "John@123");
		assertTrue(isValid);
	}

	// -------------------------------ROUTE ENTITY
	// TESTS-----------------------------------------------

	@Test
	public void addOrUpdateRouteTest() {
		Route route = new Route();
		route.setOrigin("Mumbai");
		route.setDestination("Delhi");

		assertNotNull(routeDao.addOrUpdateRoute(route));
	}

	@Test
	public void findRouteByRouteId() {
		Route route = routeDao.findRouteByRouteId(5009);
		System.out.println(route.getOrigin() + " " + route.getDestination());
	}

	@Test
	public void findAllBusesByRouteId() {
		Route route = routeDao.findRouteByRouteId(5009);
		List<Bus> buses = route.getBus();
		for (Bus b : buses) {
			System.out.println(b.getBusId() + " " + b.getBusNo());
		}
	}

	@Test
	public void viewAllOriginsTest() {
		List<String> origins = routeDao.viewAllOrigins();
		for (String o : origins) {
			System.out.println(o);
		}
	}

	@Test
	public void viewAllDestinationsTest() {
		List<String> destinations = routeDao.viewAllDestinations();
		for (String d : destinations) {
			System.out.println(d);
		}
	}

	@Test
	public void viewAllRouteIdTest() {
		List<Integer> rids = routeDao.viewAllRouteId();
		for (int r : rids) {
			System.out.println(r);
		}
	}

	// -------------------------------BUS ENTITY
	// TESTS--------------------------------------------------

	@Test
	public void addOrUpdateBusTest() {
		Bus bus = new Bus();

		bus.setBusNo("MH02TC1684");
		bus.setBusType(BusType.Non_AC);
		bus.setFare(900.67);
		bus.setArrivalTime("18:00");
		bus.setDepartureTime("13:00");
		bus.setCapacity(3);

		Route route = routeDao.findRouteByRouteId(5005);
		bus.setRoute(route);

		Bus bus2 = busDao.addOrUpdateBus(bus);
		assertNotNull(bus2);
	}

	@Test
	public void findBusByBusIdTest() {
		Bus bus = busDao.findBusByBusId(4025);
		System.out.println(bus.getBusId() + " " + bus.getBusNo());
	}

	@Test
	public void findBusByOriginDestinationTest() {
		List<Bus> buses = busDao.findBusByOriginDestination("Chennai", "Bangalore");
		for (Bus b : buses) {
			System.out.println(b.getBusId() + " " + b.getBusNo());
		}
	}

	@Test
	public void viewAllBusIdTest() {
		List<Integer> bids = busDao.viewAllBusId();
		for (int b : bids) {
			System.out.println(b);
		}
	}

	// ------------------------------BOOKING ENTITY
	// TESTS-------------------------------------------------

	@Test
	public void addBookingTest() {

		Booking booking = new Booking();
		booking.setBookingFare(100.0);
		booking.setBookingDate("26-07-2022");
		booking.setBookingStatus(1);
		;
//		booking.setNoOfPassengers(2);

		Bus bus = busDao.findBusByBusId(4018);
		booking.setBus(bus);

		User user = userDao.findUserByUserId(1004);
		booking.setUser(user);

		Booking savedBooking = bookingDao.addBooking(booking);
		assertNotNull(savedBooking);
	}

	@Test
	public void findBookingByBookingId() {
		Booking booking = bookingDao.findBookingByBookingId(2008);
		assertNotNull(booking);
	}

	@Test
	public void findAllBookingsByBusId() {
		List<Booking> bookings = bookingDao.findAllBookingsByBusId(4025);
		for (Booking b : bookings) {
			System.out.println(b.getBookingId());
		}
	}

	@Test
	public void findAllPassengersByBookingIdTest() {
		List<Passenger> passengers = bookingDao.findAllPassengersByBookingId(2008);
		for (Passenger p : passengers) {
			System.out.println(p.getFirstName() + " " + p.getLastName());
		}
	}

	@Test
	public void cancelBookingTest() {
		Booking booking = bookingDao.cancelBooking(2008);
		System.out.println(booking.getBookingStatus());
	}
	
	@Test
	public void viewAllBookingsByUserIdTest() {
		List<Booking> bookings = bookingDao.viewAllBookingsByUserId(1001);
		for(Booking b:bookings) {
			System.out.println(b.getBookingId() + " " + b.getBookingDate() + " " + b.getBookingStatus());
		}
	}
	
	@Test
	public void viewTodaysBookings() {
		System.out.println(bookingDao.viewTodaysBookings());
	}
	
	@Test
	public void viewTodaysRevenue() {
		System.out.println(bookingDao.viewTodaysRevenue());
	}
	
	@Test
	public void viewMonthlyBookings() {
		System.out.println(bookingDao.viewMonthlyBookings());
	}
	
	@Test
	public void findTravelDateByBookingId() {
		bookingDao.findTravelDateByBookingId(2015);
	}

	// ----------------------------PASSENGER ENTITY
	// TESTS----------------------------------------

	@Test
	public void addPassengerTest() {
		Passenger passenger = new Passenger();

		Booking booking = bookingDao.findBookingByBookingId(2004);
		Bus bus = busDao.findBusByBusId(4018);

		passenger.setFirstName("Ian");
		passenger.setLastName("Kan");
		passenger.setDateOfBirth("09-07-2002");
		passenger.setPhoneNo("8438468138");
		passenger.setSeatNo("2");
		passenger.setTravelDate("16-08-2002");
		passenger.setBooking(booking);
		passenger.setEmailId("ian@gmail.com");
		passenger.setBus(bus);

		Passenger savedPassenger = passengerDao.addPassenger(passenger);

		assertNotNull(savedPassenger);
	}

	@Test
	public void findAllPassengersByBusId() {
		List<Passenger> allPassengersByBusId = passengerDao.findAllPassengersByBusId(4025);
		for (Passenger passenger : allPassengersByBusId) {
			System.out.println(passenger.getEmailId());
		}
	}

	@Test
	public void findAllSeatsBookedTest() {
		List<String> seats = passengerDao.findAllSeatsBooked(4001, "15-08-2022");
		for (String s : seats) {
			System.out.println(s);
		}
	}
}
