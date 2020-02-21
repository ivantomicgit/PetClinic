package com.ivan.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.dto.VeterinarDTO;
import com.ivan.entity.Veterinar;
import com.ivan.mapper.VeterinarMapper;
import com.ivan.service.VeterinarServis;


@RestController
@RequestMapping("/api/veterinar")
public class VeterinarKontroler {

	private final VeterinarServis veterinarServis;
	private final VeterinarMapper veterinarMapper;
	
	@Autowired
	public VeterinarKontroler(VeterinarServis veterinarServis, VeterinarMapper veterinarMapper) {
		super();
		this.veterinarServis = veterinarServis;
		this.veterinarMapper = veterinarMapper;
	}

	@GetMapping("/read/veterinar/{idVeterinar}")
	public ResponseEntity<VeterinarDTO> readVeterinarianAndHisSpecialties(@PathVariable Integer idVeterinar) {
		
		Veterinar vet = veterinarServis.read(idVeterinar);
	
		return new ResponseEntity<VeterinarDTO>(veterinarMapper.toDTO(vet) , HttpStatus.OK);
	}
	
	@GetMapping("/readList")
	public ResponseEntity<List<VeterinarDTO>> readListOfVeterinariansAndTheirSpecialties() {
		
		List<Veterinar> vetList = veterinarServis.readList();
	
		return new ResponseEntity<List<VeterinarDTO>>(veterinarMapper.toListDTO(vetList) , HttpStatus.OK);
	}
	
}
