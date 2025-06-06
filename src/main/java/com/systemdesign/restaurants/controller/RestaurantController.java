package com.systemdesign.restaurants.controller;

import com.systemdesign.restaurants.model.request.CreateResturantRequest;
import com.systemdesign.restaurants.model.request.FilterRestaurantsByPinCodeAndNameRequest;
import com.systemdesign.restaurants.model.response.FilterRestaurantByPinCodeAndNameResponse;
import com.systemdesign.restaurants.service.impl.AddRestaurantsImpl;
import com.systemdesign.restaurants.service.impl.FindRestaurantsByPinCodeAndNameImpl;
import com.systemdesign.restaurants.util.CommandExecutor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final CommandExecutor commandExecutor;

    public RestaurantController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }


    @PostMapping("/add")
    public ResponseEntity<Boolean> addResturants(@Valid @RequestBody CreateResturantRequest input) {
        Boolean result = commandExecutor.execute(AddRestaurantsImpl.class, input);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/search")
    public ResponseEntity<FilterRestaurantByPinCodeAndNameResponse> searchRestauratns
            (@Valid @RequestBody FilterRestaurantsByPinCodeAndNameRequest input) {
        FilterRestaurantByPinCodeAndNameResponse result = commandExecutor.
                execute(FindRestaurantsByPinCodeAndNameImpl.class, input);
        return ResponseEntity.ok(result);
    }
}
