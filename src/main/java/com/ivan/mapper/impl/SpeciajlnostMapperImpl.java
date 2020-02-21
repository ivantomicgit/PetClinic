package com.ivan.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ivan.dto.SpecijalnostDTO;

import com.ivan.entity.Specijalnost;
import com.ivan.mapper.SpecijanostMapper;

@Component
public class SpeciajlnostMapperImpl implements SpecijanostMapper {

	@Override
	public List<SpecijalnostDTO> toListDTOs(Set<Specijalnost> specijalnosti) {
		List<SpecijalnostDTO> listDTOs = new ArrayList<SpecijalnostDTO>();
		for (Specijalnost specijalnost : specijalnosti) {

			SpecijalnostDTO specijalnostDTO = new SpecijalnostDTO();
			specijalnostDTO.setId(specijalnost.getId());
			specijalnostDTO.setIme(specijalnost.getIme());

			listDTOs.add(specijalnostDTO);
		}

		return listDTOs;
	}

}
