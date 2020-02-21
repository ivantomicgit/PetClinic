package com.ivan.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VeterinarDTO {

	private int id;
	private String ime;
	private List<SpecijalnostDTO> specijalnosti;
}
