package com.systemdesign.restaurants.util;

public interface Command <T,O>{

    public O execute(T input);
}
