package com.ivan.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivan.dto.LjubimacDTO;
import com.ivan.dto.PosetaDTO;
import com.ivan.entity.Ljubimac;
import com.ivan.entity.Poseta;
import com.ivan.mapper.LjubimacMapper;
import com.ivan.mapper.PosetaMapper;

@Component
public class LjubimacMapperImpl implements LjubimacMapper {

	private final PosetaMapper posetaMapper;

	@Autowired
	public LjubimacMapperImpl(PosetaMapper posetaMapper) {
		super();
		this.posetaMapper = posetaMapper;
	}

	@Override
	public LjubimacDTO toLjubimacDTO(Ljubimac ljubimac) {
		LjubimacDTO ljubimacDTO = new LjubimacDTO();
		ljubimacDTO.setId(ljubimac.getId());
		ljubimacDTO.setIme(ljubimac.getIme());
		ljubimacDTO.setListaPoseta(posetaMapper.toListPosetaDTOs(ljubimac.getSetPoseta()));
		return ljubimacDTO;
	}

	@Override
	public Ljubimac toLjubimac(LjubimacDTO ljubimacDTO) {
		Ljubimac ljubimac = new Ljubimac();
		ljubimac.setId(ljubimacDTO.getId());
		ljubimac.setIme(ljubimacDTO.getIme());
		ljubimac.setSetPoseta(posetaMapper.toListPoseta(ljubimacDTO.getListaPoseta()));
		return ljubimac;
	}

	@Override
	public List<LjubimacDTO> toListDTOs(List<Ljubimac> listaLjubimaca) {
		List<LjubimacDTO> listDTOs = new ArrayList<LjubimacDTO>();
		for (Ljubimac ljubimac : listaLjubimaca) {
			if (listaLjubimaca == null) {
				listaLjubimaca = new ArrayList<Ljubimac>();
			}
			LjubimacDTO ljubimacDTO = new LjubimacDTO();
			ljubimacDTO.setId(ljubimac.getId());
			ljubimacDTO.setIme(ljubimac.getIme());
			ljubimacDTO.setListaPoseta(posetaMapper.toListPosetaDTOs(ljubimac.getSetPoseta()));
			listDTOs.add(ljubimacDTO);
		}
		return listDTOs;
	}

	@Override
	public List<Ljubimac> toList(List<LjubimacDTO> ljubimciDTO) {
		List<Ljubimac> list = new ArrayList<Ljubimac>();
		if (ljubimciDTO == null) {
			ljubimciDTO = new ArrayList<LjubimacDTO>();
		}
		for (LjubimacDTO ljubimacDTO : ljubimciDTO) {

			Ljubimac ljubimac = new Ljubimac();
			ljubimac.setId(ljubimacDTO.getId());
			ljubimac.setIme(ljubimacDTO.getIme());
			ljubimac.setSetPoseta(posetaMapper.toListPoseta(ljubimacDTO.getListaPoseta()));
			list.add(ljubimac);
		}
		return list;
	}

}
