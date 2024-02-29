/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.entity;

import be.iccbxl.pid.reservationSpringBoot.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fotso
 */
@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		
		repository.findAll().forEach(users::add);
		
		return users;
	}
	
	public User getUser(String id) {
		int indice = Integer.parseInt(id);
		
		return repository.findById(indice);
	}

	public void addUser(User user) {
		repository.save(user);
	}

	public void updateUser(String id, User user) {
		repository.save(user);
	}

	public void deleteUser(String id) {
		Long indice = (long) Integer.parseInt(id);
		
		repository.deleteById(indice);
	}
}

