package com.ivan.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import com.ivan.entity.model.ImeEntitet;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ljubimac extends ImeEntitet{
	private static final long serialVersionUID = 1L;
	
	
	private String tezina;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vlasnik_id")
	private Vlasnik vlasnik;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tip_id")
	private LjubimacTip ljubimacTip;
	
	@OneToMany(mappedBy = "ljubimac", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Poseta> setPoseta = new LinkedHashSet<Poseta>();
	
	@ManyToMany(mappedBy = "ljubimaci")
	private Set<Veterinar> setVeterinara = new HashSet<>();
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datumRodjenja;
	
	
	public void addPoseta(Poseta poseta) {
		setPoseta.add(poseta);
		poseta.setLjubimac(this);
	}
	public void remove(Poseta poseta) {
		setPoseta.remove(poseta);
		poseta.setLjubimac(null);
	}
	
	public void addVeterinar(Veterinar veterinar) {
		setVeterinara.add(veterinar);
		veterinar.getLjubimaci().add(this);
		
	}
	public void removeVeterinara(Veterinar veterinar) {
		setVeterinara.remove(veterinar);
		veterinar.getLjubimaci().remove(this);
	}
	
	
	
	
}
