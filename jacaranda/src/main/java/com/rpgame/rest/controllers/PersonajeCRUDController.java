package com.rpgame.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpgame.entity.Personaje;

/**
 * Personaje CRUD Controller
 * @author estudiante
 *	
 */


@RestController
@RequestMapping(path = "/personaje")
public class PersonajeCRUDController {
	private List<Personaje> personajes = new ArrayList<>();
	
	
}
