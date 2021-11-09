package com.example.Prog3API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Prog3API.entities.Autor;
import com.example.Prog3API.repositories.AutorRepository;
import com.example.Prog3API.repositories.BaseRepository;

@Service
public class AutorServiceImp extends BaseServiceImp<Autor, Long> implements AutorService{

	@Autowired
	private AutorRepository autorRepository;
	
	public AutorServiceImp(BaseRepository<Autor, Long> baseRepository) {
		super(baseRepository);
	}

}
