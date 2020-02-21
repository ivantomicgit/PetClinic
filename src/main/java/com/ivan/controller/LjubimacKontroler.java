package com.ivan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.dto.LjubimacDTO;
import com.ivan.entity.Ljubimac;
import com.ivan.facade.LjubimacFacade;
import com.ivan.mapper.LjubimacMapper;
import com.ivan.service.LjubimacServis;

@RestController
@RequestMapping("/api/ljubimac")
public class LjubimacKontroler {

	private final LjubimacServis ljubimacServis;
	private final LjubimacFacade ljubimacFacade;
	private final LjubimacMapper ljubimacMapper;

	@Autowired
	public LjubimacKontroler(LjubimacServis ljubimacServis, LjubimacFacade ljubimacFacade,
			LjubimacMapper ljubimacMapper) {
		super();
		this.ljubimacServis = ljubimacServis;
		this.ljubimacFacade = ljubimacFacade;
		this.ljubimacMapper = ljubimacMapper;
	}

	@PostMapping("/kreirajLjubimca/vlasnik/{idVlansika}/ljubimacTip/{idLjubimacTip}")
	public ResponseEntity<?> kreirajLJubimca(@PathVariable Integer idVlansika, @PathVariable Integer idLjubimacTip,
			@Valid @RequestBody LjubimacDTO ljubimacDTO, BindingResult bindinResult) {
//		ResponseEntity<?> errorMap = validatorService.validacijaServisa(bindinResult);
//		if (errorMap != null)
//			return errorMap;
//		LjubimacDTO ljubimacDTO1 = ljubimacFacade.save(idVlansika, idLjubimacTip, ljubimacDTO);
		return new ResponseEntity<LjubimacDTO>(ljubimacFacade.save(idVlansika, idLjubimacTip, ljubimacDTO),
				HttpStatus.OK);
	}

	@GetMapping("/read/ljubimac/{idLjubimac}")
	public ResponseEntity<LjubimacDTO> readLjubimac(@PathVariable Integer idLjubimac) {

		return new ResponseEntity<LjubimacDTO>(ljubimacMapper.toLjubimacDTO(ljubimacServis.read(idLjubimac)),
				HttpStatus.OK);
	}

	@GetMapping("/listLjubimaca")
	public ResponseEntity<List<LjubimacDTO>> findAll() {
		List<LjubimacDTO> listDTO = ljubimacMapper.toListDTOs((ljubimacServis.listaLjubimaca()));
		
		return new ResponseEntity<List<LjubimacDTO>>(listDTO, HttpStatus.OK);
	}

	@PutMapping("/updateLjubimca/vlasnik/{idVlasnika}/ljubimacTip/{idLjubimacTip}")
	public ResponseEntity<LjubimacDTO> updateLjubimca(@PathVariable Integer idVlasnika,
			@PathVariable Integer idLjubimacTip, @RequestBody LjubimacDTO ljubimacDTO) {
		
		return new ResponseEntity<LjubimacDTO>(ljubimacFacade.update(idVlasnika, idLjubimacTip, ljubimacDTO),
				HttpStatus.OK);
	}

	@DeleteMapping("/delete/ljubimac/{idLjubimca}")
	public ResponseEntity<String> obrisiLjubimca(@PathVariable Integer idLjubimca) {
		
		ljubimacServis.delete(idLjubimca);

		return new ResponseEntity<String>("Obrisan ljubimac za id"+ idLjubimca, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteList")
	public ResponseEntity<String> obrisiListuLjubimaca(@RequestBody List<LjubimacDTO> lista) {
		List<Ljubimac> listaLjubimaca = ljubimacMapper.toList(lista);
		ljubimacServis.deleteAll(listaLjubimaca);

		return new ResponseEntity<String>("Obrisani ljubimci", HttpStatus.OK);
	}
}
