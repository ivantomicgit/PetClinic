package com.ivan.service;

import java.util.List;

import com.ivan.entity.Veterinar;

public interface VeterinarServis {

	Veterinar read(Integer idVeterinar);

	List<Veterinar> readList();

}
