package com.systemdesign.restaurants.service.impl;

import com.systemdesign.restaurants.entity.Address;
import com.systemdesign.restaurants.entity.Restaurants;
import com.systemdesign.restaurants.model.request.CreateResturantRequest;
import com.systemdesign.restaurants.repo.RestaurantsRepository;
import com.systemdesign.restaurants.service.AddRestaurants;
import org.springframework.stereotype.Service;

@Service
public class AddRestaurantsImpl implements AddRestaurants {

    private final RestaurantsRepository restaurantsRepository;

    public AddRestaurantsImpl(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }


    @Override
    public Boolean execute(CreateResturantRequest input) {
        Address address = Address.builder()
                .street(input.getStreetName())
                .houseNumber(input.getHouseNumber())
                .pinCode(input.getPinCode())
                .build();
        Restaurants restaurants = Restaurants.builder()
                .name(input.getName())
                .address(address)
                .build();
        restaurantsRepository.save(restaurants);
        return true;
    }
}
