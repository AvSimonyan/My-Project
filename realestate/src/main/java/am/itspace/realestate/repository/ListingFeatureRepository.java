package am.itspace.realestate.repository;

import am.itspace.realestate.model.Listing;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ListingFeatureRepository extends JpaRepository<Listing,Long> {


}
