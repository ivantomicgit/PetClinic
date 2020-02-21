package com.ivan.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivan.entity.Ljubimac;
import com.ivan.entity.Poseta;
import com.ivan.entity.Vlasnik;
import com.ivan.repository.LjubimacRepository;
import com.ivan.repository.PosetaRepository;
import com.ivan.repository.VlasnikRepository;
import com.ivan.service.PosetaServis;

@Service
public class PosetaServisImpl implements PosetaServis {

	private final PosetaRepository posetaRepository;
	private final VlasnikRepository vlasnikRepository;
	private final LjubimacRepository ljubimacRepository;

	@Autowired
	public PosetaServisImpl(VlasnikRepository vlasnikRepository, LjubimacRepository ljubimacRepository, PosetaRepository posetaRepository) {
		super();
		this.vlasnikRepository = vlasnikRepository;
		this.ljubimacRepository = ljubimacRepository;
		this.posetaRepository = posetaRepository;
	}

	@Override
	@Transactional
	public Vlasnik readVlasnik(Integer idVlasnika) {
		Vlasnik vlasnik = vlasnikRepository.findVlasnikById(idVlasnika);
		if(vlasnik == null) {
			throw new EntityNotFoundException("Ne postotji vlasnik za id "+ idVlasnika);
		}
		return vlasnik;
	}

	@Override
	@Transactional
	public Poseta save(Poseta poseta, Integer idLjubimca) {
		Ljubimac ljubimac = ljubimacRepository.findLjubimacById(idLjubimca);
		if (ljubimac == null) {
			throw new EntityNotFoundException("Ne postoji ljubimac za id " + idLjubimca);
		}
		
		//Poseta poseta1 = new Poseta();
		poseta.setLjubimac(ljubimac);
		
		return posetaRepository.save(poseta);
	}

	@Override
	@Transactional
	public Poseta read(Integer idPoseta) {
		return posetaRepository.findPosetaById(idPoseta);
	}

	@Override
	@Transactional
	public Poseta update(Integer idLjubimca, Poseta poseta) {
		Ljubimac ljubimac = ljubimacRepository.findLjubimacById(idLjubimca);
		if (ljubimac == null) {
			throw new EntityNotFoundException("Ne postoji ljubimac za id " + idLjubimca);
		}
		poseta.setLjubimac(ljubimac);
		
		return posetaRepository.save(poseta);
	}

	@Override
	@Transactional
	public void delete(Integer idPoseta) {
		posetaRepository.deleteById(idPoseta);
		
	}

}
