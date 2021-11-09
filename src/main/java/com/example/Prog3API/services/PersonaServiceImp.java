package com.example.Prog3API.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Prog3API.entities.Persona;
import com.example.Prog3API.repositories.BaseRepository;
import com.example.Prog3API.repositories.PersonaRepository;

@Service
public class PersonaServiceImp extends BaseServiceImp<Persona, Long> implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;
	
	public PersonaServiceImp(BaseRepository<Persona, Long> baseRepository) { //esto cumple la misma funcion que "@Autowired"
		super(baseRepository);
	}

	@Override
	public List<Persona> search(String filtro) throws Exception {
		try {
			//List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);	//con metodo query
			//List<Persona> personas = personaRepository.search(filtro); //con JPQL
			List<Persona> personas = personaRepository.searchNativo(filtro);	//Con SQL
			return personas;	
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
		try {
			//Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);	//con metodo query
			//Page<Persona> personas = personaRepository.search(filtro, pageable); //con JPQL
			Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);	//Con SQL
			return personas;	
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	

}
