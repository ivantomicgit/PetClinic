package com.ivan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivan.entity.LjubimacTip;

@Repository
public interface LjubimacTipRepository extends JpaRepository<LjubimacTip, Integer>{

	LjubimacTip findLjubimacTipById(Integer idLjubimacTip);

	
}
