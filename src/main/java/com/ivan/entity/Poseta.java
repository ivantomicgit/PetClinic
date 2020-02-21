package com.ivan.entity;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.ivan.entity.model.BazniEntitet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Poseta extends BazniEntitet{
	private static final long serialVersionUID = 1L;

	private String opis;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datum_posete;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ljubimac_id")
	private Ljubimac ljubimac;
	
	@Override
	public int hashCode() {
		
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poseta other = (Poseta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
