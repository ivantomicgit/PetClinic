package com.ivan.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import com.ivan.entity.model.ImeEntitet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Specijalnost extends ImeEntitet{
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy = "specijalnosti")
	private Set<Veterinar> veterinari;
}
