package com.systemdesign.restaurants.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterRestaurantByPinCodeAndNameResponse<T>{
    private T data;
    private int currentPage;
    private long totalItems;
    private int totalPages;
}
