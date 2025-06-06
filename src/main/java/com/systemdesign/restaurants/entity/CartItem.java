package com.systemdesign.restaurants.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CartItem extends BaseEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private RestaurantUsers user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resturant_id")
    private Restaurants restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menuId;

    private String quantity;
}
