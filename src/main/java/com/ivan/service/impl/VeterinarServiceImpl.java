package com.ivan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivan.entity.Veterinar;
import com.ivan.repository.VeterinarRepository;
import com.ivan.service.VeterinarServis;

@Service
public class VeterinarServiceImpl implements VeterinarServis {

	private final VeterinarRepository veterinarRepository;

	@Autowired
	public VeterinarServiceImpl(VeterinarRepository veterinarRepository) {
		super();
		this.veterinarRepository = veterinarRepository;
	}

	@Override
	@Transactional
	public Veterinar read(Integer idVeterinar) {
		// TODO Auto-generated method stub
		return veterinarRepository.findVeterinarById(idVeterinar);
	}

	@Override
	@Transactional
	public List<Veterinar> readList() {
		// TODO Auto-generated method stub
		return veterinarRepository.findAll();
	}

}
