package com.ivan.service;

import java.util.List;

import com.ivan.dto.VlasnikDTO;
import com.ivan.entity.Vlasnik;

public interface VlasnikServis {

	Vlasnik insert(Vlasnik vlasnik);

	Vlasnik read(Integer id);

	List<Vlasnik> findVlasnikByPrezime(String prezime);

	List<Vlasnik> findAll();

	void delete(Integer id);

	Vlasnik update(Integer idVlasnika, Vlasnik vlasnik);

}
