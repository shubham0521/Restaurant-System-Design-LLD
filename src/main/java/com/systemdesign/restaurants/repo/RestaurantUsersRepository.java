package com.systemdesign.restaurants.repo;

import com.systemdesign.restaurants.entity.RestaurantUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantUsersRepository extends JpaRepository<RestaurantUsers, Long> {
}
