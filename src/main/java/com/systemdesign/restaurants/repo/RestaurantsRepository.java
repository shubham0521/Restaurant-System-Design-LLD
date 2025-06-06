package com.systemdesign.restaurants.repo;

import com.systemdesign.restaurants.entity.Restaurants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {

    Page<Restaurants> findAllByNameIgnoreCaseContainingAndAddress_PinCode(String name, int picCode, Pageable pageable);

    Page<Restaurants> findAllByAddress_PinCode(int pinCode, Pageable pageable);
}
