package com.systemdesign.restaurants.model.request;


import com.systemdesign.restaurants.model.PageRequest;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FilterMenuByNameRequest extends PageRequest {

    private String menuName;
}
