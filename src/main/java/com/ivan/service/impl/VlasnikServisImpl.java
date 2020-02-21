package com.ivan.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ivan.entity.Vlasnik;
import com.ivan.repository.VlasnikRepository;
import com.ivan.service.VlasnikServis;

@Service
public class VlasnikServisImpl implements VlasnikServis {

	private final VlasnikRepository vlasnikRepository;

	@Autowired
	public VlasnikServisImpl(VlasnikRepository vlasnikRepository) {
		super();
		this.vlasnikRepository = vlasnikRepository;
	}

	@Override
	@Transactional
	public Vlasnik insert(Vlasnik vlasnik) {
		return vlasnikRepository.save(vlasnik);
	}

	@Override
	@Transactional
	public Vlasnik read(Integer id) {
		return vlasnikRepository.findVlasnikById(id);
	}

	@Override
	@Transactional
	public List<Vlasnik> findVlasnikByPrezime(String prezime) {
		List<Vlasnik> listaSaIstimPrezimenom = vlasnikRepository.findVlasnikByPrezime(prezime);
		if (listaSaIstimPrezimenom.size() == 0) {
			throw new EntityNotFoundException("Ne postioji vlasnik sa prezimenom " + prezime);
		}

		return listaSaIstimPrezimenom;
	}

	@Override
	@Transactional
	public List<Vlasnik> findAll() {
		List<Vlasnik> listaSvihVlasnika = vlasnikRepository.findAll();
		if (listaSvihVlasnika.size() == 0) {
			throw new EntityNotFoundException("Ne postioji ni jedan vlasnik" );
		}
		
		return listaSvihVlasnika;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Vlasnik vlasnik = vlasnikRepository.findVlasnikById(id);
		if(vlasnik == null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za id: " + id);
		}
		vlasnikRepository.delete(vlasnik);
		
	}

	@Override
	@Transactional
	public Vlasnik update(Integer idVlasnika, Vlasnik vlasnik) {
		vlasnik.setId(idVlasnika);
		Vlasnik vlasnik2 = vlasnikRepository.findVlasnikById(idVlasnika);
		if(vlasnik2 == null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za id: " + idVlasnika);
		}
		vlasnik2 = vlasnikRepository.save(vlasnik);
		return vlasnik2;
		
	}

}
