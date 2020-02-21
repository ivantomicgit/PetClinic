package com.ivan.entity;

import java.time.LocalDate;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;


import com.ivan.entity.model.ApstraktnaOsoba;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veterinar extends ApstraktnaOsoba{
	private static final long serialVersionUID = 1L;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate zapolsljen_od;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.MERGE, CascadeType. REFRESH})
//	@JoinTable(name = "veterinar_ljubimac", joinColumns = @JoinColumn(name="veterinar_id"), inverseJoinColumns = @JoinColumn(name="id_ljubimac"))
//	private Set<Ljubimac>setLjubimaca= new HashSet<>();
	@ManyToMany(fetch = FetchType.LAZY, cascade  = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType. REFRESH})
	@JoinTable(name = "veterinar_ljubimac", joinColumns = @JoinColumn(name = "veterinar_id"), inverseJoinColumns = @JoinColumn(name = "ljubimac_id"))	
	private Set<Ljubimac> ljubimaci = new HashSet<>();
	
//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "vehicle_driver", joinColumns = @JoinColumn(name = "vehicle_id"), inverseJoinColumns = @JoinColumn(name = "driver_id"))
	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "veterinar_specijalnost", joinColumns = @JoinColumn(name = "veterinar_id"), inverseJoinColumns = @JoinColumn(name = "specijalnost_id"))
	private Set<Specijalnost> specijalnosti;
}
