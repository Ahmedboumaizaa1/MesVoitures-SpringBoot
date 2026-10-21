package com.ahmed.voitures.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.voitures.entities.Type;
import com.ahmed.voitures.repo.TypeRepository;

@RestController
@RequestMapping("/api/type")
@CrossOrigin("*")
public class TypeRESTController {

	@Autowired
	TypeRepository typerepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Type> getAllTypes() {
		return typerepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Type getTypeById(@PathVariable("id") Long id) {
		return typerepository.findById(id).get();
	}
}