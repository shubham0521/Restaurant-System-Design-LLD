package com.systemdesign.restaurants.service.impl;

import com.systemdesign.restaurants.entity.Menu;
import com.systemdesign.restaurants.model.request.FilterMenuByNameRequest;
import com.systemdesign.restaurants.model.response.FilterMenuByNameResponse;
import com.systemdesign.restaurants.repo.MenuRepository;
import com.systemdesign.restaurants.service.FilterMenuByName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilterMenuByNameImpl implements FilterMenuByName {

    private final MenuRepository menuRepository;

    public FilterMenuByNameImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public FilterMenuByNameResponse execute(FilterMenuByNameRequest input) {
        Pageable page = PageRequest.of(input.getPageNumber(), input.getPageSize());
        Page<Menu> menuResult = menuRepository.findAllByNameContainingIgnoreCase(input.getMenuName(), page);
        return FilterMenuByNameResponse.builder()
                .data(menuResult.getContent())
                .currentPage(menuResult.getTotalPages())
                .totalPage(menuResult.getTotalPages())
                .totalItem(menuResult.getTotalElements())
                .build();
    }
}
