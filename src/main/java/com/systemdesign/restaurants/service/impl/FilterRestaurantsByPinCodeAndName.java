package com.systemdesign.restaurants.service.impl;

import com.systemdesign.restaurants.entity.Restaurants;
import com.systemdesign.restaurants.helper.FilterRestaurantFactory;
import com.systemdesign.restaurants.model.request.FilterRestaurantsByPinCodeAndNameRequest;
import com.systemdesign.restaurants.model.response.FilterRestaurantByPinCodeAndNameResponse;
import com.systemdesign.restaurants.repo.RestaurantsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FilterRestaurantsByPinCodeAndName extends FilterRestaurantFactory {

    protected FilterRestaurantsByPinCodeAndName(RestaurantsRepository restaurantsRepository) {
        super(restaurantsRepository);
    }

    @Override
    public boolean isFilterValid(FilterRestaurantsByPinCodeAndNameRequest request) {
        return Optional.ofNullable(request)
                .filter(value -> StringUtils.isNotEmpty(value.getName()))
                .map(value -> Boolean.TRUE)
                .orElseGet(() -> false);
    }

    @Override
    public FilterRestaurantByPinCodeAndNameResponse returnResult(FilterRestaurantsByPinCodeAndNameRequest request) {
        Pageable pageable = PageRequest.of(request.getPageNumber(), request.getPageSize());
        Page<Restaurants> result = restaurantsRepository.
                findAllByNameIgnoreCaseContainingAndAddress_PinCode(request.getName(), request.getPinCode(), pageable);
        return FilterRestaurantByPinCodeAndNameResponse.builder()
                .data(result.getContent())
                .currentPage(result.getNumber())
                .totalPages(result.getTotalPages())
                .totalItems(result.getTotalElements())
                .build();
    }

}
