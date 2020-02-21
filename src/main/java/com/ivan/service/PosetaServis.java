package com.ivan.service;

import com.ivan.entity.Poseta;
import com.ivan.entity.Vlasnik;

public interface PosetaServis {

	Vlasnik readVlasnik(Integer idVlasnika);

	Poseta save(Poseta poseta, Integer idLjubimca);

	Poseta read(Integer idPoseta);

	Poseta update(Integer idLjubimca, Poseta poseta);

	void delete(Integer idPoseta);

	

}
