/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.controller;

import be.iccbxl.pid.reservationSpringBoot.entity.Representation;
import be.iccbxl.pid.reservationSpringBoot.entity.RepresentationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author fotso
 */
@Controller
public class RepresentationController {
	@Autowired
	RepresentationService service;

	@GetMapping("/representations")
public String index(Model model) {
		List<Representation> representations = service.getAll();

		model.addAttribute("representations", representations);
		model.addAttribute("title", "Liste des representations");
		
        	return "representation/index";
}
	
	@GetMapping("/representations/{id}")
public String show(Model model, @PathVariable("id") String id) {
		Representation representation = service.get(id);

		model.addAttribute("representation", representation);
		model.addAttribute("date", representation.getWhen().toLocalDate());
		model.addAttribute("heure", representation.getWhen().toLocalTime());
		model.addAttribute("title", "Fiche d'une representation");
		
        	return "representation/show";
}

}

