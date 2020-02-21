package com.ivan.mapper;

import java.util.List;

import com.ivan.dto.VeterinarDTO;
import com.ivan.entity.Veterinar;

public interface VeterinarMapper {

	VeterinarDTO toDTO(Veterinar vet);

	List<VeterinarDTO> toListDTO(List<Veterinar> vetList);

}
