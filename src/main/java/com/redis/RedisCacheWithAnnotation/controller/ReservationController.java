package com.redis.RedisCacheWithAnnotation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.RedisCacheWithAnnotation.model.ReservationVO;
import com.redis.RedisCacheWithAnnotation.service.ReservationService;

@RestController
@RequestMapping("/res-service")
public class ReservationController {

	Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService service;
	
	/**
	 * 
	 * @param resVO
	 * @return
	 */
	@CacheEvict(value = "reservaion", key = "#resVO.status")
	@PostMapping("/reservaion")
	public ReservationVO saveReservation(@RequestBody ReservationVO resVO)
	{
		ReservationVO saveReservationData = service.saveReservationData(resVO);
		return saveReservationData;
	}

	@Cacheable(value = "reservaion", key = "#status")
	@GetMapping("/reservaion/status/{status}")
	public List<ReservationVO> getAllReservationByStatus(@PathVariable("status") String status)
	{
		LOGGER.error("===================Data Fetched From DB=======================");
		return service.fetchReservationData(status);
	}
	
}
