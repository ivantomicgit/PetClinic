package com.ivan.facade;

import javax.validation.Valid;

import com.ivan.dto.LjubimacDTO;

public interface LjubimacFacade {

	LjubimacDTO save(Integer idVlansika, Integer idLjubimacTip, @Valid LjubimacDTO ljubimacDTO);

	LjubimacDTO update(Integer idVlasnika, Integer idLjubimacTip, LjubimacDTO ljubimacDTO);

}
