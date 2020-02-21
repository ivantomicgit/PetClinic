package com.ivan.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VlasnikDTO {

	private int id;
	private String ime;
	private String prezime;
	private String email;
//	private String adressa;
//	private String grad;
//	private String telefon;

//	private LocalDate datum_rodjenja;
	private List<LjubimacDTO> ljubimci = new ArrayList<LjubimacDTO>();
	
}
