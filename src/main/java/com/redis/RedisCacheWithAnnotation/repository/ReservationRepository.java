package com.redis.RedisCacheWithAnnotation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redis.RedisCacheWithAnnotation.model.ReservationVO;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationVO, Long>{

	List<ReservationVO> findByStatus(String status);

}
