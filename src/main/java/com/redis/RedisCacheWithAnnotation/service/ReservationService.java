package com.redis.RedisCacheWithAnnotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.RedisCacheWithAnnotation.model.ReservationVO;
import com.redis.RedisCacheWithAnnotation.repository.ReservationRepository;

/**
 * 
 * @author Sovon Singha
 *
 */
@Service
public class ReservationService {

	@Autowired
	private ReservationRepository repository;
	
	public ReservationVO saveReservationData(ReservationVO resVO)
	{
		return repository.save(resVO);
	}

	public ReservationVO getResData(Long resID) {
		return repository.findById(resID).orElse(null);
	}

	public List<ReservationVO> fetchReservationData(String status)
	{
		return repository.findByStatus(status);
	}
	
}
