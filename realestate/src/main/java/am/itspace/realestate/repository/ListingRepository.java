package am.itspace.realestate.repository;

import am.itspace.realestate.model.Listing;
import am.itspace.realestate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing,Long> {

    Optional<User> findByEmail(String email);
}
