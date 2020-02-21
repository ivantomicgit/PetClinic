package com.ivan.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivan.dto.VeterinarDTO;
import com.ivan.entity.Veterinar;
import com.ivan.mapper.SpecijanostMapper;
import com.ivan.mapper.VeterinarMapper;


@Component
public class VeterinarMapperImpl implements VeterinarMapper {

	private final SpecijanostMapper specijalnostMapper;

	@Autowired
	public VeterinarMapperImpl(SpecijanostMapper specijalnostMapper) {
		super();
		this.specijalnostMapper = specijalnostMapper;
	}

	@Override
	public VeterinarDTO toDTO(Veterinar vet) {
		VeterinarDTO vetDTO = new VeterinarDTO();
		vetDTO.setId(vet.getId());
		vetDTO.setIme(vet.getIme());
		vetDTO.setSpecijalnosti(specijalnostMapper.toListDTOs(vet.getSpecijalnosti()));
		return vetDTO;
	}

	@Override
	public List<VeterinarDTO> toListDTO(List<Veterinar> vetList) {
		List<VeterinarDTO> vetListDTO = new ArrayList<VeterinarDTO>();
		for(Veterinar vet : vetList) {
			VeterinarDTO vDTO = new VeterinarDTO();
			vDTO.setId(vet.getId());
			vDTO.setIme(vet.getIme());
			vDTO.setSpecijalnosti(specijalnostMapper.toListDTOs(vet.getSpecijalnosti()));
			vetListDTO.add(vDTO);
		}
		return vetListDTO;
	}

}
