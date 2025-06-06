package com.systemdesign.restaurants.controller;

import com.systemdesign.restaurants.model.BaseResponse;
import com.systemdesign.restaurants.model.request.FilterMenuByNameRequest;
import com.systemdesign.restaurants.model.response.FilterMenuByNameResponse;
import com.systemdesign.restaurants.service.impl.FilterMenuByNameImpl;
import com.systemdesign.restaurants.util.CommandExecutor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final CommandExecutor commandExecutor;

    public MenuController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }


    @PostMapping("/search")
    public ResponseEntity<BaseResponse<FilterMenuByNameResponse>> searchMenu(@RequestParam(defaultValue = "0") int pageSize,
                                                            @RequestParam(defaultValue =  "0") int pageNumber,
                                                            @RequestBody FilterMenuByNameRequest input) {

        try{
            input.setPageSize(pageSize);
            input.setPageNumber(pageNumber);

            FilterMenuByNameResponse response =  commandExecutor.execute(FilterMenuByNameImpl.class, input);
            return ResponseEntity.status(HttpStatus.OK)
                            .body(BaseResponse.<FilterMenuByNameResponse>builder().data(response).success(true).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponse.<FilterMenuByNameResponse>builder().data(null).success(false).build());
        }

    }
}
