package com.example.springbootmicroservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootmicroservice.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}