package com.ivan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivan.entity.Vlasnik;

@Repository
public interface VlasnikRepository extends JpaRepository<Vlasnik, Integer>{

	Vlasnik findVlasnikById(Integer id);

	List<Vlasnik> findVlasnikByPrezime(String prezime);

}
