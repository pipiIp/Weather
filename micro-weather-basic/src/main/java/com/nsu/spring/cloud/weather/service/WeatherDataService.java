package com.nsu.spring.cloud.weather.service;

import com.nsu.spring.cloud.weather.vo.WeatherResponse;

public interface WeatherDataService {
	
	WeatherResponse getDataByCityId(String cityId);

	WeatherResponse getDataByCityName(String cityName);
	
}
