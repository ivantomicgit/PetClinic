package com.ivan.entity.model;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public class ApstraktnaOsoba extends ImeEntitet{
	private static final long serialVersionUID = -3543939344358160377L;

	
	private String prezime;
	private String email;
	private String adressa;
	private String grad;
	private String telefon;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datum_rodjenja;
}
