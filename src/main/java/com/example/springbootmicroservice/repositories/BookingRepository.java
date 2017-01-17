package com.example.springbootmicroservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootmicroservice.model.Booking;

@Transactional
public interface BookingRepository extends CrudRepository<Booking, Long> {

	/**
	 * This method will find an Boooking instance in the database by its
	 * departure. Note that this method is not implemented and its working code
	 * will be automatically generated from its signature by Spring Data JPA.
	 */
	public Booking findByDeparture(String departure);
}