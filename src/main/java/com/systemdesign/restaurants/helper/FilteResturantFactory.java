package com.systemdesign.restaurants.helper;

import com.systemdesign.restaurants.model.request.FilterRestaurantsByPinCodeAndNameRequest;
import com.systemdesign.restaurants.model.response.FilterMenuByNameResponse;
import com.systemdesign.restaurants.model.response.FilterRestaurantByPinCodeAndNameResponse;
import com.systemdesign.restaurants.repo.RestaurantsRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class FilteResturantFactory {

    protected final RestaurantsRepository restaurantsRepository;


    protected FilteResturantFactory(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public abstract boolean
    isFilterValid(FilterRestaurantsByPinCodeAndNameRequest filterRestaurantsByPinCodeAndNameRequest);

    public abstract FilterRestaurantByPinCodeAndNameResponse
    returnResult(FilterRestaurantsByPinCodeAndNameRequest request);
}
