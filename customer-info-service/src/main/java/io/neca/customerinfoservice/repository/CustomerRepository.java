package io.neca.customerinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.neca.customerinfoservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
