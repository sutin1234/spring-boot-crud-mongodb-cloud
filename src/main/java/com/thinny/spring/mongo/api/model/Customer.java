package com.thinny.spring.mongo.api.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Customers")
public class Customer {

	@Id
	public UUID id;
	public String name;
	public String lastName;

	public Customer(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("name") String lastName) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName(){
		return lastName;
	}

	public void setId(UUID id) {
		this.id = id;

	}

}
