package com.systemdesign.restaurants.service;

import com.systemdesign.restaurants.model.request.FilterRestaurantsByPinCodeAndNameRequest;
import com.systemdesign.restaurants.model.response.FilterRestaurantByPinCodeAndNameResponse;
import com.systemdesign.restaurants.util.Command;

public interface FindRestaurantsByPinCodeAndName extends
        Command<FilterRestaurantsByPinCodeAndNameRequest, FilterRestaurantByPinCodeAndNameResponse> {
}
