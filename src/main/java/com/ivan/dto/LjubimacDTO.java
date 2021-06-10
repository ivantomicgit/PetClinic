package com.ivan.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LjubimacDTO {

	private int id;
	private String ime;
	private List<PosetaDTO> listaPoseta;
//	private String tezina;
//	private LocalDate datumRodjenja;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
