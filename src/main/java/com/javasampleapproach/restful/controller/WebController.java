package com.javasampleapproach.restful.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javasampleapproach.restful.jpa.CustomerRepository;
import com.javasampleapproach.restful.model.Customer;

@RestController
@RequestMapping(value="/api")
public class WebController {
private final static Logger logger=LoggerFactory.getLogger(WebController.class);


@Autowired
private CustomerRepository studentRepository;
	
	@GetMapping(value="/customer")
	public List<Customer> getAll(){
		logger.info("fething customers......");
		
		return studentRepository.findAll();
		
	}
	
	@GetMapping(value="/customer/{id}")
	public Customer getCustomer(@PathVariable long id){
		logger.info("fething customers......"+id);
	Customer student = studentRepository.findOne(id);

		
		return student;
	}
	@PostMapping(value="/customer")
	public ResponseEntity<Object> postCustomer(@RequestBody Customer customer){
		logger.info("adding new customr ");
		Customer savedStudent = studentRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value="/customer/{id}")
	public ResponseEntity<Object>  putCustomer(@RequestBody Customer customer, @PathVariable long id){
		//Customer studentOptional = studentRepository.findOne(id);

		
		
		
		studentRepository.save(customer);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable long id){
		logger.info("customer deleted is "+id);
		studentRepository.delete(id);
	}

}