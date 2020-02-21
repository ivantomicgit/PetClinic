package com.ivan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.ivan.entity.model.ApstraktnaOsoba;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vlasnici")
public class Vlasnik extends ApstraktnaOsoba{
	private static final long serialVersionUID = 1L;

	    
    @OneToMany(mappedBy = "vlasnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ljubimac> ljubimci = new ArrayList<Ljubimac>();
    
    
}
