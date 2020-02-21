package com.ivan.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivan.dto.VlasnikDTO;
import com.ivan.entity.Vlasnik;
import com.ivan.mapper.LjubimacMapper;
import com.ivan.mapper.VlasnikMapper;
@Component
public class VlasnikMapperImpl implements VlasnikMapper {
	
	@Autowired
	private LjubimacMapper ljubimacMapper;	

	@Override
	public VlasnikDTO toVlasnikDTO(Vlasnik vlasnik) {
		VlasnikDTO vlasnikDTO = new VlasnikDTO();
		vlasnikDTO.setId(vlasnik.getId());
		vlasnikDTO.setIme(vlasnik.getIme());
		vlasnikDTO.setPrezime(vlasnik.getPrezime());
		vlasnikDTO.setEmail(vlasnik.getEmail());	
		//vlasnikDTO.setLjubimci(ljubimacMapper.toListDTOs(vlasnik.getLjubimci()));
		return vlasnikDTO;
	}

	@Override
	public Vlasnik toVlasnik(VlasnikDTO vlasnikDTO) {
		Vlasnik vlasnik = new Vlasnik();
		vlasnik.setId(vlasnikDTO.getId());
		vlasnik.setIme(vlasnikDTO.getIme());
		vlasnik.setPrezime(vlasnikDTO.getPrezime());
		vlasnik.setEmail(vlasnikDTO.getEmail());
		//vlasnik.setLjubimci(ljubimacMapper.toList(vlasnikDTO.getLjubimci()));
		return vlasnik;
	}

	@Override
	public List<VlasnikDTO> toListDTOs(List<Vlasnik> listaVlasnika) {
		List<VlasnikDTO> listDTOs = new ArrayList<VlasnikDTO>();
		for(Vlasnik vlasnik : listaVlasnika) {
			VlasnikDTO vlasnilkDTO = new VlasnikDTO();
			vlasnilkDTO.setId(vlasnik.getId());
			vlasnilkDTO.setIme(vlasnik.getIme());
			vlasnilkDTO.setPrezime(vlasnik.getPrezime());
			vlasnilkDTO.setEmail(vlasnik.getEmail());	
			listDTOs.add(vlasnilkDTO);
		}
		return listDTOs;
	}

}
