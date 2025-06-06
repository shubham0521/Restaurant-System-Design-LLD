package com.systemdesign.restaurants.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "restaurant_users")
public class RestaurantUsers extends BaseEntity{

    private String name;
    private String emailId;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") // foreign key will be in Address table
    private List<Address> addresses;
}
