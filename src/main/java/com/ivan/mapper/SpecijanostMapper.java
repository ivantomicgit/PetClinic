package com.ivan.mapper;

import java.util.List;
import java.util.Set;

import com.ivan.dto.SpecijalnostDTO;
import com.ivan.entity.Specijalnost;

public interface SpecijanostMapper {

	List<SpecijalnostDTO> toListDTOs(Set<Specijalnost> specijalnosti);

}
