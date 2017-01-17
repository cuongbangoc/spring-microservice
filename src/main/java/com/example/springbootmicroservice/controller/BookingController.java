package com.example.springbootmicroservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmicroservice.model.Booking;
import com.example.springbootmicroservice.model.Employee;
import com.example.springbootmicroservice.repositories.BookingRepository;;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;

	/**
	 * POST /create --> Create a new booking and save it in the database.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Booking create(@RequestBody Booking booking) {
		booking.setTravelDate(new Date());
		booking = (Booking) bookingRepository.save(booking);
		return booking;
	}
	
	/**
	 * GET /all --> Read all bookings by booking from the database.
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Booking> all() {
		List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
		return bookings;
	}

	/**
	 * GET /read --> Read a booking by booking id from the database.
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public Booking read(@RequestParam Long bookingId) {
		Booking booking = (Booking) bookingRepository.findOne(bookingId);
		return booking;
	}

	/**
	 * PUT /update --> Update a booking record and save it in the database.
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Booking update(@RequestParam Long bookingId, @RequestParam String psngrName) {
		Booking booking = (Booking) bookingRepository.findOne(bookingId);
		booking.setPsngrName(psngrName);
		booking = (Booking) bookingRepository.save(booking);
		return booking;
	}

	/**
	 * DELETE /delete --> Delete a booking from the database.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(@RequestParam Long bookingId) {
		bookingRepository.delete(bookingId);
		return "booking #" + bookingId + " deleted successfully";
	}
}