package com.example.Prog3API.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prog3API.entities.Localidad;
import com.example.Prog3API.services.LocalidadServiceImp;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImp<Localidad, LocalidadServiceImp>{

}
