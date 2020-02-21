package com.ivan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivan.entity.Poseta;

@Repository
public interface PosetaRepository extends JpaRepository<Poseta, Integer>{

	Poseta findPosetaById(Integer idPoseta);

}
