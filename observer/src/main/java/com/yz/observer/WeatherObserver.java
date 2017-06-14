package com.yz.observer;

/**
 * 
 * Observer interface.
 * 
 */
public interface WeatherObserver {

  void update(WeatherType currentWeather);

}
