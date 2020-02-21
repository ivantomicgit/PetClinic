package com.ivan.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.entity.LjubimacTip;
import com.ivan.repository.LjubimacTipRepository;
import com.ivan.service.LjubimacTipService;

@Service
public class LjubimacTipServiceImpl implements LjubimacTipService {

	private final LjubimacTipRepository ljubimacTipRepository;

	@Autowired
	public LjubimacTipServiceImpl(LjubimacTipRepository ljubimacTipRepository) {
		super();
		this.ljubimacTipRepository = ljubimacTipRepository;
	}

	@Override
	@Transactional
	public LjubimacTip findLjubimacTipById(Integer idLjubimacTip) {
		// TODO Auto-generated method stub
		return ljubimacTipRepository.findLjubimacTipById(idLjubimacTip);
	}

}
