/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.entity;

import be.iccbxl.pid.reservationSpringBoot.repository.LocationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fotso
 */
@Service
public class LocationService {
	@Autowired
	private LocationRepository repository;
	
	
	public List<Location> getAll() {
		List<Location> locations = new ArrayList<>();
		
		repository.findAll().forEach(locations::add);
		
		return locations;
	}
	
	public Location get(String id) {
		Long indice = (long) Integer.parseInt(id);
		Optional<Location> location = repository.findById(indice); 
		
		return location.isPresent() ? location.get() : null;
	}

	public void add(Location location) {
		repository.save(location);
	}

	public void update(String id, Location location) {
		repository.save(location);
	}

	public void delete(String id) {
		Long indice = (long) Integer.parseInt(id);
		
		repository.deleteById(indice);
	}
}
