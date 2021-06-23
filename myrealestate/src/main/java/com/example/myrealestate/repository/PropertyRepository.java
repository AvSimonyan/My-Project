package com.example.myrealestate.repository;

import com.example.myrealestate.model.Property;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PropertyRepository extends JpaRepository<Property,Long> {

}
