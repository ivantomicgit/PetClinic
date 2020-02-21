package com.ivan.mapper;

import java.util.List;
import java.util.Set;

import com.ivan.dto.PosetaDTO;
import com.ivan.entity.Poseta;

public interface PosetaMapper {

	PosetaDTO toPosetaDTO(Poseta poseta);

	Poseta toPoseta(PosetaDTO posetaDTO);

	//List<PosetaDTO> toListPosetaDTOs(List<Poseta> listaPoseta);

	Set<Poseta> toListPoseta(List<PosetaDTO> listPosetaDTOs);

	List<PosetaDTO> toListPosetaDTOs(Set<Poseta> setPoseta);
}
