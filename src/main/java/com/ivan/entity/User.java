package com.ivan.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ivan.entity.model.BazniEntitet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User extends BazniEntitet{
	private static final long serialVersionUID = 1L;

	
}
