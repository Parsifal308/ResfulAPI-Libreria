package com.example.Prog3API.services;

import org.springframework.stereotype.Service;

import com.example.Prog3API.entities.Localidad;
import com.example.Prog3API.repositories.BaseRepository;

@Service
public class LocalidadServiceImp extends BaseServiceImp<Localidad, Long> implements LocalidadService{

	public LocalidadServiceImp(BaseRepository<Localidad, Long> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	
}
