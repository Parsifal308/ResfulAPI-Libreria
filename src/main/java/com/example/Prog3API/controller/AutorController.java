package com.example.Prog3API.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prog3API.entities.Autor;
import com.example.Prog3API.services.AutorServiceImp;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImp<Autor, AutorServiceImp> {

}
