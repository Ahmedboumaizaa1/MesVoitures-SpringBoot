package com.ahmed.voitures.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.voitures.entities.voiture;
import com.ahmed.voitures.service.VoitureService;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class VoitureRESTController {

	@Autowired
	VoitureService voitureService;

	@GetMapping()
	public List<voiture> getAllVoitures() {
		return voitureService.getAllVoitures();
	}
	
	@GetMapping("/{id}")
	public voiture getVoitureById(@PathVariable("id") Long id) {
	    return voitureService.getVoiture(id);
	}
	
	@PostMapping
	public voiture createVoiture(@RequestBody voiture voiture) {
	    return voitureService.saveVoiture(voiture);
	}
	
	@PutMapping
	public voiture updateVoiture(@RequestBody voiture v) {
	    return voitureService.updateVoiture(v);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVoiture(@PathVariable("id") Long id) {
	    voitureService.deleteVoitureById(id);
	}
	
	@GetMapping("/voitype/{idType}")
	public List<voiture> getVoituresByTypeId(@PathVariable("idType") Long idType) {
	    return voitureService.findByTypeIdType(idType);
	}
	@RequestMapping(value = "/voitByName/{nom}", method = RequestMethod.GET)
	public List<voiture> findByNomVoitureContains(@PathVariable("nom") String nom) {
		return voitureService.findByNomVoitureContains(nom);
	}
}