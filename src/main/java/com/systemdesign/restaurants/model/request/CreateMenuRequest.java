package com.systemdesign.restaurants.model.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuRequest {


    @NotNull
    private String name;
    @NotNull
    private String description;
    @Min(1)
    private double price;
}
