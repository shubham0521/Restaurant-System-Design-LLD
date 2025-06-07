package com.systemdesign.restaurants.helper;

import com.systemdesign.restaurants.model.request.FilterRestaurantsByPinCodeAndNameRequest;
import com.systemdesign.restaurants.model.response.FilterRestaurantByPinCodeAndNameResponse;
import com.systemdesign.restaurants.repo.RestaurantsRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class FilterRestaurantFactory {

    protected final RestaurantsRepository restaurantsRepository;


    protected FilterRestaurantFactory(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public abstract boolean
    isFilterValid(FilterRestaurantsByPinCodeAndNameRequest filterRestaurantsByPinCodeAndNameRequest);

    public abstract FilterRestaurantByPinCodeAndNameResponse
    returnResult(FilterRestaurantsByPinCodeAndNameRequest request);
}
