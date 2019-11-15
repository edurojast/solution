package com.example.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.exception.PersonaInfoNotFoundException;
import com.example.object.PersonaInfo;
import com.example.services.PersonaInfoService;

@Controller
@RequestMapping(value = "persona")
public class PersonaInfoController {

	@Autowired
	PersonaInfoService personaInfoService;
	
	List<PersonaInfo> listadoPersonas = new ArrayList<PersonaInfo>();
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<PersonaInfo> retrievePersona(@PathVariable Integer id) {
		
		try {
			PersonaInfo personaInfo = personaInfoService.getPersonaById(listadoPersonas, id);
			
			if (personaInfo == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(personaInfo);
			}
        } catch (PersonaInfoNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "persona no encontrada", ex);
        }
		
	}
	
	@PostMapping("/")
	public ResponseEntity<PersonaInfo> createPersona(@RequestBody PersonaInfo personaInfoParam) {
	
		PersonaInfo personaInfo = personaInfoService.createPersona(listadoPersonas, personaInfoParam);
		listadoPersonas.add(personaInfo);
		
		if(personaInfo == null) {
			return ResponseEntity.notFound().build();
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(personaInfo.getId())				
				.toUri();
	 
	        return ResponseEntity.created(uri).body(personaInfo);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PersonaInfo> updatePersona(@RequestBody PersonaInfo personaInfoParam, @PathVariable Integer id) {
		
		try {
			PersonaInfo personaInfo = personaInfoService.updatePersonaById(listadoPersonas, id, personaInfoParam);
			
			if (personaInfo == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(personaInfo);
			}
        } catch (PersonaInfoNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "persona no encontrada para ser editada", ex);
        }
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PersonaInfo> deletePersona(@PathVariable Integer id) {
		
		try {
			PersonaInfo personaInfo = personaInfoService.deletePersonaById(listadoPersonas, id);
			
			if (personaInfo == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(personaInfo);
			}
        } catch (PersonaInfoNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "persona no encontrada para ser eliminada", ex);
        }
		
	}
	
}
