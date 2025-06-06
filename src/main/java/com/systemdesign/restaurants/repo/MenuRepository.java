package com.systemdesign.restaurants.repo;

import com.systemdesign.restaurants.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Page<Menu> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
