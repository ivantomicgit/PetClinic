package com.ivan.controller;

import java.util.Arrays;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.dto.VlasnikDTO;
import com.ivan.entity.Vlasnik;
import com.ivan.mapper.VlasnikMapper;
import com.ivan.service.VlasnikServis;

@RestController
@RequestMapping("/api/vlasnik")
@CrossOrigin
public class VlasnikKontroler {

	private final VlasnikServis vlasnikServis;
	private final VlasnikMapper vlasnikMapper;

	@Autowired
	public VlasnikKontroler(VlasnikServis vlasnikServis, VlasnikMapper vlasnikMapper) {
		super();
		this.vlasnikServis = vlasnikServis;
		this.vlasnikMapper = vlasnikMapper;
	}

	@PostMapping("/create")
	public ResponseEntity<VlasnikDTO> insertVlasnika(@RequestBody VlasnikDTO vlasnikDTO) {

		Vlasnik vlasnik = vlasnikServis.insert(vlasnikMapper.toVlasnik(vlasnikDTO));

		return new ResponseEntity<VlasnikDTO>(vlasnikMapper.toVlasnikDTO(vlasnik), HttpStatus.CREATED);

	}

	@GetMapping("/read/vlasnik/{idVlasnika}")
	public ResponseEntity<VlasnikDTO> readVlasnik(@PathVariable Integer idVlasnika) {

		return new ResponseEntity<VlasnikDTO>(vlasnikMapper.toVlasnikDTO(vlasnikServis.read(idVlasnika)),
				HttpStatus.OK);

	}

	@GetMapping("/listaVlasnika")
	public ResponseEntity<?> sviVlasnici() {

		List<VlasnikDTO> listVlasnika = vlasnikMapper.toListDTOs(vlasnikServis.findAll());
		System.out.println(Arrays.toString(listVlasnika.toArray()));

		return new ResponseEntity<List<VlasnikDTO>>(listVlasnika, HttpStatus.OK);

	}

	@GetMapping("/prezime/{prezime}")
	public ResponseEntity<?> vratiVlasnikaPoPrezimenu(@PathVariable String prezime) {
		List<Vlasnik> listaSaIstimPrezimenom = vlasnikServis.findVlasnikByPrezime(prezime);

		return new ResponseEntity<List<VlasnikDTO>>(vlasnikMapper.toListDTOs(listaSaIstimPrezimenom), HttpStatus.OK);

	}

	@PutMapping("/update/vlasnik/{idVlasnika}")
	public ResponseEntity<VlasnikDTO> updateVlsnika(@PathVariable Integer idVlasnika,
			@RequestBody VlasnikDTO vlasnikDTO) {

		Vlasnik vlasnik = vlasnikServis.update(idVlasnika, vlasnikMapper.toVlasnik(vlasnikDTO));

		return new ResponseEntity<VlasnikDTO>(vlasnikMapper.toVlasnikDTO(vlasnik), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVlasnik(@PathVariable Integer id) {

		vlasnikServis.delete(id);
		return new ResponseEntity<String>("Vlasnik za id: " + id + " je obrisan", HttpStatus.OK);

	}

}
