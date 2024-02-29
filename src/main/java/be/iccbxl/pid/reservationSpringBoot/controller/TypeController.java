/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.controller;

import be.iccbxl.pid.reservationSpringBoot.entity.Type;
import be.iccbxl.pid.reservationSpringBoot.entity.TypeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author fotso
 */
@Controller
public class TypeController {
	@Autowired
	TypeService service;

	@GetMapping("/types")
    public String index2(Model model) {
		List<Type> types = service.getAll();

		model.addAttribute("types", types);
		model.addAttribute("title", "Liste des types");
		
        return "type/index";
    }
	
	@GetMapping("/types/{id}")
    public String show(Model model, @PathVariable("id") String id) {
		Type type = service.getType(id);

		model.addAttribute("type", type);
		model.addAttribute("title", "Fiche d'un type");
		
        return "type/show";
    }
    
    @GetMapping("/types/create")
	public String create(Model model) {
	    Type typee = new Type();

	    model.addAttribute("typee", typee);
		
	    return "type/create";
	}
	
	@PostMapping("/types/create")
	public String store(@Valid @ModelAttribute("typee") Type typee, BindingResult bindingResult, Model model) {
	    
	    if (bindingResult.hasErrors()) {
		return "type/create";
	    }
		    
	    service.addType(typee);
	    
	    return "redirect:/types/"+ typee.getId();
	}


}

