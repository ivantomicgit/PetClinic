package com.ivan.entity.model;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class ImeEntitet extends BazniEntitet{

	private static final long serialVersionUID = 1L;

	private String ime;
}
