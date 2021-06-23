package com.example.myrealestate.repository;


import com.example.myrealestate.model.PropertyFeatures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyFeatureRepository extends JpaRepository<PropertyFeatures,Long> {

}
