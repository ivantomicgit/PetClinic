package com.ivan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivan.entity.Ljubimac;
@Repository
public interface LjubimacRepository extends JpaRepository<Ljubimac, Integer>{

	Ljubimac findLjubimacById(Integer idLjubimac);

}
