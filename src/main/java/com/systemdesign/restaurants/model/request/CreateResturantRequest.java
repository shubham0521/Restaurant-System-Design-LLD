package com.systemdesign.restaurants.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateResturantRequest {

    @NotBlank(message = "name cannot be empty or blank")
    private String name;

    @NotBlank
    private String streetName;

    @NotBlank
    private String houseNumber;

    @NotNull
    private Integer pinCode;
}
