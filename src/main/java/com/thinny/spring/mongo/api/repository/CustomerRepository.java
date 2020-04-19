package com.thinny.spring.mongo.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.thinny.spring.mongo.api.model.*;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, UUID>{
	List<Customer> findByName(String name);
}
