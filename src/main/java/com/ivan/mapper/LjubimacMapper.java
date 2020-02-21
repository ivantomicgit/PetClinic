package com.ivan.mapper;

import java.util.List;

import com.ivan.dto.LjubimacDTO;
import com.ivan.entity.Ljubimac;

public interface LjubimacMapper {

	LjubimacDTO toLjubimacDTO(Ljubimac ljubimac);

	Ljubimac toLjubimac(LjubimacDTO ljubimacDTO);

	List<LjubimacDTO> toListDTOs(List<Ljubimac> listaLjubimaca);

	List<Ljubimac> toList(List<LjubimacDTO> ljubimci);

	
}
