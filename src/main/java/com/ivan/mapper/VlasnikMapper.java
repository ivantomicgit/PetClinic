package com.ivan.mapper;

import java.util.List;

import com.ivan.dto.VlasnikDTO;
import com.ivan.entity.Vlasnik;

public interface VlasnikMapper {

	
	 VlasnikDTO toVlasnikDTO(Vlasnik vlasnik);
	 Vlasnik toVlasnik(VlasnikDTO vlasnikDTO);
	 List<VlasnikDTO> toListDTOs(List<Vlasnik> listaSaIstimPrezimenom);
	
}
