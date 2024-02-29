/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.controller;

import be.iccbxl.pid.reservationSpringBoot.entity.Locality;
import be.iccbxl.pid.reservationSpringBoot.entity.LocalityService;
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
public class LocalityController {
	@Autowired
	LocalityService service;

	@GetMapping("/localities")
    public String index2(Model model) {
		List<Locality> localities = service.getAll();

		model.addAttribute("localities", localities);
		model.addAttribute("title", "Liste des localités");
		
        return "locality/index";
    }
	
	@GetMapping("/localities/{id}")
    public String show(Model model, @PathVariable("id") String id) {
		Locality locality = service.get(id);

		model.addAttribute("locality", locality);
		model.addAttribute("title", "Fiche d'une localité");
		
        return "locality/show";
    }

}
