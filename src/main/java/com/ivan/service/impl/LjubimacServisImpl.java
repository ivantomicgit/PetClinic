package com.ivan.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivan.entity.Ljubimac;
import com.ivan.repository.LjubimacRepository;
import com.ivan.service.LjubimacServis;

@Service
public class LjubimacServisImpl implements LjubimacServis {

	private final LjubimacRepository ljubimacRepository;

	@Autowired
	public LjubimacServisImpl(LjubimacRepository ljubimacRepository) {
		super();
		this.ljubimacRepository = ljubimacRepository;
	}

	@Override
	@Transactional
	public Ljubimac save(Ljubimac ljubimac) {
		// TODO Auto-generated method stub
		return ljubimacRepository.save(ljubimac);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ljubimac> listaLjubimaca() {
		List<Ljubimac> listaLjubimaca = ljubimacRepository.findAll();
		return listaLjubimaca;
	}

	@Override
	@Transactional(readOnly = true)
	public Ljubimac read(Integer idLjubimac) {
		// TODO Auto-generated method stub
		return ljubimacRepository.findLjubimacById(idLjubimac);
	}

	@Override
	@Transactional
	public void deleteAll(List<Ljubimac> lista) {
		for (Iterator<Ljubimac> iterator = lista.iterator(); iterator.hasNext();) {
			Ljubimac ljubimac = iterator.next();
			ljubimacRepository.deleteById(ljubimac.getId());
		}

	}

	@Override
	@Transactional
	public void delete(Integer idLjubimca) {
		ljubimacRepository.deleteById(idLjubimca);
		
	}

}
