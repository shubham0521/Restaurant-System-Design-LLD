package com.systemdesign.restaurants.service;

import com.systemdesign.restaurants.model.request.FilterMenuByNameRequest;
import com.systemdesign.restaurants.model.response.FilterMenuByNameResponse;
import com.systemdesign.restaurants.util.Command;

public interface FilterMenuByName extends Command<FilterMenuByNameRequest, FilterMenuByNameResponse> {
}
