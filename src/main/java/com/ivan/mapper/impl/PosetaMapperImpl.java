package com.ivan.mapper.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import com.ivan.dto.PosetaDTO;
import com.ivan.entity.Poseta;
import com.ivan.mapper.PosetaMapper;

@Component
public class PosetaMapperImpl implements PosetaMapper {

	@Override
	public PosetaDTO toPosetaDTO(Poseta poseta) {
		PosetaDTO posetaDTO = new PosetaDTO();
		posetaDTO.setId(poseta.getId());
		posetaDTO.setOpis(poseta.getOpis());
		return posetaDTO;
	}

	@Override
	public Poseta toPoseta(PosetaDTO posetaDTO) {
		Poseta poseta = new Poseta();
		poseta.setId(posetaDTO.getId());
		poseta.setOpis(posetaDTO.getOpis());
		return poseta;		
	}

	@Override
	public List<PosetaDTO> toListPosetaDTOs(Set<Poseta> setPoseta) {
		
		List<PosetaDTO> listDTOs = new ArrayList<PosetaDTO>();
		
		if (setPoseta == null) {
			setPoseta = new HashSet<Poseta>();
			return listDTOs;
		}
		for (Poseta poseta : setPoseta) {
			
			PosetaDTO posetaDTO = new PosetaDTO();
			posetaDTO.setId(poseta.getId());
			posetaDTO.setOpis(poseta.getOpis());

			listDTOs.add(posetaDTO);
		}
		return listDTOs;
	}

	@Override
	public Set<Poseta> toListPoseta(List<PosetaDTO> listPosetaDTOs) {
		Set<Poseta> list = new HashSet<Poseta>();
		for (PosetaDTO posetaDTO : listPosetaDTOs) {
			if (listPosetaDTOs == null) {
				listPosetaDTOs = new ArrayList<PosetaDTO>();
			}
			Poseta poseta = new Poseta();
			poseta.setId(posetaDTO.getId());
			poseta.setOpis(posetaDTO.getOpis());

			list.add(poseta);
		}
		return list;
	}

	
}
