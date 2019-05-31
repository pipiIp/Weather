package com.waylau.spring.cloud.weather.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;


@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);  
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

	private static final long TIME_OUT = 1800L; // 1800s
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		String uri = WEATHER_URI + "citykey=" + cityId;
		return this.doGetWeahter(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		String uri = WEATHER_URI + "city=" + cityName;
		return this.doGetWeahter(uri);
	}
	
	private WeatherResponse doGetWeahter(String uri) {
		String key = uri;
		String strBody = null;
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse resp = null;
		ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();
		// 鍏堟煡缂撳瓨锛岀紦瀛樻湁鐨勫彇缂撳瓨涓殑鏁版嵁
		if (stringRedisTemplate.hasKey(key)) {
			logger.info("Redis has data");
			strBody = ops.get(key);
		} else {
			logger.info("Redis don't has data");
			// 缂撳瓨娌℃湁锛屽啀璋冪敤鏈嶅姟鎺ュ彛鏉ヨ幏鍙�
	 		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

	 		if (respString.getStatusCodeValue() == 200) {
				strBody = respString.getBody();
			}
			
			// 鏁版嵁鍐欏叆缂撳瓨
			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
		}

		try {
			resp = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			//e.printStackTrace();
			logger.error("Error!",e);
		}
		
		return resp;
	}

}
