package com.example.Prog3API.controller;


import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prog3API.entities.Persona;
import com.example.Prog3API.services.PersonaServiceImp;

@RestController
@CrossOrigin(origins = "*")	//permite el acceso a la API desde distintos clientes
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImp<Persona, PersonaServiceImp>{
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String filtro){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
			
		}
	}
	@GetMapping("/searchPaged")
	public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
			
		}
	}
}
