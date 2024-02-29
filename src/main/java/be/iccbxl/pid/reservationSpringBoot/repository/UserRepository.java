/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.repository;

import be.iccbxl.pid.reservationSpringBoot.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fotso
 */
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByLastname(String lastname);

	User findById(long id);
	User findByLogin(String login);
	User findByEmail(String email);
}


