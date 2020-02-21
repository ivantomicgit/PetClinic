package com.ivan.facade;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ivan.dto.LjubimacDTO;
import com.ivan.entity.Ljubimac;
import com.ivan.entity.LjubimacTip;
import com.ivan.entity.Vlasnik;
import com.ivan.mapper.LjubimacMapper;
import com.ivan.service.LjubimacServis;
import com.ivan.service.LjubimacTipService;
import com.ivan.service.VlasnikServis;

@Component
public class LjubimacFacadeImpl implements LjubimacFacade {

	private final LjubimacServis ljubimacServis;
	private final LjubimacMapper ljubimacMapper;
	private final VlasnikServis vlasnikService;
	private final LjubimacTipService ljubimacTipService;

	@Autowired
	public LjubimacFacadeImpl(LjubimacServis ljubimacServis, LjubimacMapper ljubimacMapper,
			VlasnikServis vlasnikService, LjubimacTipService ljubimacTipService) {
		super();
		this.ljubimacServis = ljubimacServis;
		this.ljubimacMapper = ljubimacMapper;
		this.vlasnikService = vlasnikService;
		this.ljubimacTipService = ljubimacTipService;
	}

	@Override
	public LjubimacDTO save(Integer idVlansika, Integer idLjubimacTip, @Valid LjubimacDTO ljubimacDTO) {
		Vlasnik vlasnik = vlasnikService.read(idVlansika);
		if (vlasnik == null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za id " + idVlansika);
		}
		LjubimacTip ljubimacTip = ljubimacTipService.findLjubimacTipById(idLjubimacTip);
		if (ljubimacTip == null) {
			throw new EntityNotFoundException("Ne postoji tip za id " + idLjubimacTip);
		}

		Ljubimac ljubimac = new Ljubimac();

		ljubimac.setIme(ljubimacDTO.getIme());
		ljubimac.setLjubimacTip(ljubimacTip);
		ljubimac.setVlasnik(vlasnik);

		return ljubimacMapper.toLjubimacDTO(ljubimacServis.save(ljubimac));
	}

	@Override
	public LjubimacDTO update(Integer idVlasnika, Integer idLjubimacTip, LjubimacDTO ljubimacDTO) {
		Vlasnik vlasnik = vlasnikService.read(idVlasnika);
		if(vlasnik == null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za id"+idVlasnika);			
		}
		LjubimacTip ljubimacTip = ljubimacTipService.findLjubimacTipById(idLjubimacTip);
		if(ljubimacTip == null) {
			throw new EntityNotFoundException("Ne postiji tip za id"+ idLjubimacTip);
		}
		
		Ljubimac ljubimac = ljubimacMapper.toLjubimac(ljubimacDTO);
		try {
			
			ljubimac.setLjubimacTip(ljubimacTip);
			ljubimac.setVlasnik(vlasnik);
			ljubimac.setId(ljubimacDTO.getId());
			ljubimacServis.save(ljubimac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new EntityNotFoundException("Nije sacuvean podatak");
		}
		return ljubimacMapper.toLjubimacDTO(ljubimac);
	}

}
