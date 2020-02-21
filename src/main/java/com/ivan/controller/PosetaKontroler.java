package com.ivan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ivan.dto.PosetaDTO;
import com.ivan.dto.VlasnikDTO;
import com.ivan.entity.Poseta;

import com.ivan.mapper.PosetaMapper;
import com.ivan.mapper.VlasnikMapper;
import com.ivan.service.PosetaServis;


@RestController
@RequestMapping("/api/poseta")
public class PosetaKontroler {

	private final PosetaServis posetaServis;
	private final PosetaMapper posetaMapper;
	private final VlasnikMapper vlsnikMapper;
	
	
	@Autowired
	public PosetaKontroler(PosetaServis posetaServis, PosetaMapper posetaMapper, VlasnikMapper vlsnikMapper) {
		super();
		this.posetaServis = posetaServis;
		this.posetaMapper = posetaMapper;
		this.vlsnikMapper = vlsnikMapper;
	}
	
	@PostMapping("/kreirajPosetu/ljubimac/{idLjubimca}")
	public ResponseEntity<PosetaDTO> create(@RequestBody PosetaDTO posetaDTO, @PathVariable Integer idLjubimca){
		Poseta poseta = posetaMapper.toPoseta(posetaDTO);
		 poseta = posetaServis.save(poseta, idLjubimca);
		
		return new ResponseEntity<PosetaDTO>(posetaMapper.toPosetaDTO(poseta), HttpStatus.OK);
	}
	
	@GetMapping("/read/poseta/{idPoseta}")
	public ResponseEntity<PosetaDTO> readLjubimac(@PathVariable Integer idPoseta) {

		return new ResponseEntity<PosetaDTO>(posetaMapper.toPosetaDTO(posetaServis.read(idPoseta)),
				HttpStatus.OK);
	}
	
	@PutMapping("/updatePoseta/ljubimac/{idLjubimca}")
	public ResponseEntity<PosetaDTO> updateLjubimca(@PathVariable Integer idLjubimca, @RequestBody PosetaDTO posetaDTO) {
		
		Poseta poseta = posetaMapper.toPoseta(posetaDTO);
		return new ResponseEntity<PosetaDTO>(posetaMapper.toPosetaDTO(posetaServis.update(idLjubimca, poseta)),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/poseta/{idPoseta}")
	public ResponseEntity<String> obrisiLjubimca(@PathVariable Integer idPoseta) {		
		posetaServis.delete(idPoseta);

		return new ResponseEntity<String>("Obrisana poseta za id "+ idPoseta, HttpStatus.OK);
	}
	
	@GetMapping("{idVlasnika}")
	public ResponseEntity<VlasnikDTO>vrati(@PathVariable Integer idVlasnika){
				
    return new ResponseEntity<VlasnikDTO>(vlsnikMapper.toVlasnikDTO(posetaServis.readVlasnik(idVlasnika)), HttpStatus.OK);
		
	}
	
}
