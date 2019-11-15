package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.PersonaInfoNotFoundException;
import com.example.object.PersonaInfo;

@Service
public class PersonaInfoService {

	public PersonaInfo getPersonaById(final List<PersonaInfo> listadoPersonas, final Integer id) throws PersonaInfoNotFoundException {

		PersonaInfo personaInfo = null;

		if (listadoPersonas.size() == 0) {
			throw new PersonaInfoNotFoundException("no existen personas registradas");
		}

		for (PersonaInfo personaInfoTmp : listadoPersonas) {
			if (personaInfoTmp.getId().equals(id)) {
				personaInfo = personaInfoTmp;
			}
		}

		if (personaInfo == null) {
			throw new PersonaInfoNotFoundException("persona no encontrada");
		}

		return personaInfo;

	}

	public PersonaInfo createPersona(final List<PersonaInfo> listadoPersonas, final PersonaInfo personaInfoParam) {

		PersonaInfo personaInfo = null;

		Integer lastId = 0;

		for (PersonaInfo personaInfoTmp : listadoPersonas) {
			if (personaInfoTmp.getId() > lastId) {
				lastId = personaInfoTmp.getId();
			}
		}

		personaInfo = personaInfoParam;
		personaInfo.setId(lastId + 1);

		return personaInfo;

	}

	public PersonaInfo updatePersonaById(List<PersonaInfo> listadoPersonas, final Integer id, final PersonaInfo personaInfoParam) throws PersonaInfoNotFoundException {

		PersonaInfo personaInfo = null;

		if (listadoPersonas.size() == 0) {
			throw new PersonaInfoNotFoundException("no existen personas registradas");
		}

		for (PersonaInfo personaInfoTmp : listadoPersonas) {
			if (personaInfoTmp.getId().equals(id)) {
				personaInfo = personaInfoTmp;
				listadoPersonas.remove(personaInfoTmp);
				listadoPersonas.add(personaInfoParam);
			}
		}

		if (personaInfo == null) {
			throw new PersonaInfoNotFoundException("persona no encontrada para ser editada");
		}
		
		return personaInfo;

	}
	
	public PersonaInfo deletePersonaById(List<PersonaInfo> listadoPersonas, final Integer id) throws PersonaInfoNotFoundException {

		PersonaInfo personaInfo = null;

		if (listadoPersonas.size() == 0) {
			throw new PersonaInfoNotFoundException("no existen personas registradas");
		}

		for (PersonaInfo personaInfoTmp : listadoPersonas) {
			if (personaInfoTmp.getId().equals(id)) {
				personaInfo = personaInfoTmp;
				listadoPersonas.remove(personaInfoTmp);
			}
		}

		if (personaInfo == null) {
			throw new PersonaInfoNotFoundException("persona no encontrada para ser eliminada");
		}
		
		return personaInfo;

	}

}
