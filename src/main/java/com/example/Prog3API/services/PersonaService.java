package com.example.Prog3API.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Prog3API.entities.Persona;

public interface PersonaService extends BaseService<Persona, Long>{
	List<Persona> search(String filtro) throws Exception;
	Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
