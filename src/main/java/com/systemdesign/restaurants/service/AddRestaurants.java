package com.systemdesign.restaurants.service;

import com.systemdesign.restaurants.model.request.CreateResturantRequest;
import com.systemdesign.restaurants.util.Command;

public interface AddRestaurants extends Command<CreateResturantRequest, Boolean> {
}
