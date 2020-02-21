package com.ivan.entity;

import javax.persistence.Entity;

import com.ivan.entity.model.BazniEntitet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role extends BazniEntitet{
	private static final long serialVersionUID = 1L;

}
