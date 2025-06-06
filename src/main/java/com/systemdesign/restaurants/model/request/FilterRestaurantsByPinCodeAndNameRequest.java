package com.systemdesign.restaurants.model.request;


import com.systemdesign.restaurants.model.PageRequest;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FilterRestaurantsByPinCodeAndNameRequest extends PageRequest {
    private int pinCode;
    private String name;
}
