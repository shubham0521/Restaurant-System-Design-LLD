package com.systemdesign.restaurants.service.impl;

import com.systemdesign.restaurants.helper.FilterRestaurantFactory;
import com.systemdesign.restaurants.model.request.FilterRestaurantsByPinCodeAndNameRequest;
import com.systemdesign.restaurants.model.response.FilterRestaurantByPinCodeAndNameResponse;
import com.systemdesign.restaurants.service.FindRestaurantsByPinCodeAndName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class FindRestaurantsByPinCodeAndNameImpl implements FindRestaurantsByPinCodeAndName {

    private final List<FilterRestaurantFactory> filteResturantFactoryList;

    private FilterRestaurantFactory getFactoryClass(FilterRestaurantsByPinCodeAndNameRequest input) {
        return filteResturantFactoryList.stream()
                .filter(value -> value.isFilterValid(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No eligible filter present to get the result"));
    }

    @Override
    public FilterRestaurantByPinCodeAndNameResponse execute(FilterRestaurantsByPinCodeAndNameRequest input) {
        return getFactoryClass(input).returnResult(input);
    }
}
