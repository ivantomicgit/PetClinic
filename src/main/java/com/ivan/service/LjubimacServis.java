package com.ivan.service;

import java.util.List;

import com.ivan.dto.LjubimacDTO;
import com.ivan.entity.Ljubimac;

public interface LjubimacServis {

	Ljubimac save(Ljubimac ljubimac);

	List<Ljubimac> listaLjubimaca();

	void deleteAll(List<Ljubimac> listaLjubimaca);

	Ljubimac read(Integer idLjubimac);

	void delete(Integer idLjubimca);

	

	

}
