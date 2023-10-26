package com.inbox.resturantListing.repo;

import com.inbox.resturantListing.entity.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResturantRepo extends JpaRepository<Resturant, Integer> {

}
