# 《基于Spring Cloud的天气预报微服务实战》

本教程所采用的技术及相关版本较新，请读者将相关开发环境设置成跟本教程所采用的一致，或者不低于本教程的配置。

* JDK 8
* Eclipse Neon.2 Release (4.6.2)：本项示例采用Eclipse编写，但示例源码与具体的IDE无关，读者朋友可以自行选择适合自己的IDE，比如IntelliJ IDEA、NetBeans等。
* Gradle 4.0
* Spring Boot 2.0.0.M4
* Spring Boot Web Starter 2.0.0.M4
* Apache HttpClient 4.5.3
* Spring Boot Data Redis Starter 2.0.0.M4
* Redis 3.2.100
* Spring Boot Quartz Starter 2.0.0.M4
* Quartz Scheduler 2.3.0
* Spring Boot Thymeleaf Starter 2.0.0.M4
* Thymeleaf 3.0.7.RELEASE
* Bootstrap 4.0.0-beta.2
* Spring Boot 2.0.0.M3
* Spring Cloud Starter Netflix Eureka Server Finchley.M2
* Spring Cloud Starter Netflix Eureka Client Finchley.M2
* Spring Cloud Starter Netflix Ribbon Finchley.M2
* Spring Cloud Starter OpenFeign Finchley.M2
* Spring Cloud Starter Netflix Zuul Finchley.M2
* Spring Cloud Config Server Finchley.M2
* Spring Cloud Config Client Finchley.M2
* Spring Cloud Starter Netflix Hystrix Finchley.M2

* 实现天气数据的同步`micro-weather-quartz`
* 给天气预报一个“面子”`micro-weather-report`
* 天气数据采集微服务的实现`msa-weather-collection-server`
* 天气数据API微服务的实现`msa-weather-data-server`
* 天气预报微服务的实现`msa-weather-report-server`
* 城市数据API微服务的实现`msa-weather-city-server`
* 如何集成 Eureka Server`micro-weather-eureka-server`
* 如何集成 Eureka Client`micro-weather-eureka-client`
* 实现服务的注册与发现`msa-weather-collection-eureka`、`msa-weather-data-eureka`、`msa-weather-city-eureka`、`msa-weather-report-eureka`
* 常见微服务的消费者`micro-weather-eureka-client-feign`
* 使用 Feign 实现服务的消费者`msa-weather-collection-eureka-feign`、`msa-weather-report-eureka-feign`
* 如何集成Zuul`micro-weather-eureka-client-zuul`
* 实现 API 网关`msa-weather-report-eureka-feign-gateway`、`msa-weather-eureka-client-zuul`
* 使用 Config 实现的配置中心`micro-weather-config-server`、`micro-weather-config-client`
* 如何集成 Hystrix`micro-weather-eureka-client-feign-hystrix`
* 实现微服务的熔断机制`msa-weather-report-eureka-feign-gateway-hystrix`

## 版本说明

* 2019-5-31：v1.0.0。


