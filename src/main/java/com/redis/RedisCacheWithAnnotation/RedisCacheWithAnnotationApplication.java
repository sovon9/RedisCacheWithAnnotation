package com.redis.RedisCacheWithAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisCacheWithAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheWithAnnotationApplication.class, args);
	}

}
