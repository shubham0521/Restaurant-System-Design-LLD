package com.systemdesign.restaurants.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterMenuByNameResponse<T> {
    private T data;
    private int currentPage;
    private int totalPage;
    private long totalItem;
}
