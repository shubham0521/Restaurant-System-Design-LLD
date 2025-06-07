package com.systemdesign.restaurants.service.impl;

import com.systemdesign.restaurants.helper.FilterRestaurantFactory;
import com.systemdesign.restaurants.model.request.FilterRestaurantsByPinCodeAndNameRequest;
import com.systemdesign.restaurants.model.response.FilterRestaurantByPinCodeAndNameResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindRestaurantsByPinCodeAndNameImplTest {

    @Mock
    private FilterRestaurantFactory mockFactory1;

    @Mock
    private FilterRestaurantFactory mockFactory2;

    private FindRestaurantsByPinCodeAndNameImpl service;

    @BeforeEach
    void setUp() {
        service = new FindRestaurantsByPinCodeAndNameImpl(Arrays.asList(mockFactory1, mockFactory2));
    }

    @Test
    void execute_WhenValidFactoryFound_ShouldReturnResponse() {
        // Arrange
        FilterRestaurantsByPinCodeAndNameRequest request = new FilterRestaurantsByPinCodeAndNameRequest();
        FilterRestaurantByPinCodeAndNameResponse expectedResponse = new FilterRestaurantByPinCodeAndNameResponse();
        
        when(mockFactory1.isFilterValid(request)).thenReturn(false);
        when(mockFactory2.isFilterValid(request)).thenReturn(true);
        when(mockFactory2.returnResult(request)).thenReturn(expectedResponse);

        // Act
        FilterRestaurantByPinCodeAndNameResponse result = service.execute(request);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResponse, result);
        verify(mockFactory1).isFilterValid(request);
        verify(mockFactory2).isFilterValid(request);
        verify(mockFactory2).returnResult(request);
    }

    @Test
    void execute_WhenNoValidFactoryFound_ShouldThrowException() {
        // Arrange
        FilterRestaurantsByPinCodeAndNameRequest request = new FilterRestaurantsByPinCodeAndNameRequest();
        when(mockFactory1.isFilterValid(request)).thenReturn(false);
        when(mockFactory2.isFilterValid(request)).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.execute(request));
        verify(mockFactory1).isFilterValid(request);
        verify(mockFactory2).isFilterValid(request);
    }

    @Test
    void execute_WithEmptyFactoryList_ShouldThrowException() {
        // Arrange
        service = new FindRestaurantsByPinCodeAndNameImpl(Collections.emptyList());
        FilterRestaurantsByPinCodeAndNameRequest request = new FilterRestaurantsByPinCodeAndNameRequest();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> service.execute(request));
    }
} 