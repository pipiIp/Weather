package com.nsu.spring.cloud.weather.service;

import com.nsu.spring.cloud.weather.vo.Weather;

public interface WeatherReportService {

	Weather getDataByCityId(String cityId);
}
