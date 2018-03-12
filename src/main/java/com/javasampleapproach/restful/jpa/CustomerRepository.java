package com.javasampleapproach.restful.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.restful.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	

	
	
}