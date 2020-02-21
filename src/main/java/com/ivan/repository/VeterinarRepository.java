package com.ivan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivan.entity.Veterinar;

@Repository
public interface VeterinarRepository extends JpaRepository<Veterinar, Integer>{



	Veterinar findVeterinarById(Integer idVeterinar);

}
