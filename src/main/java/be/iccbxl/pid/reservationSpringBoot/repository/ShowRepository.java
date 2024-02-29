/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.repository;

import be.iccbxl.pid.reservationSpringBoot.entity.Location;
import be.iccbxl.pid.reservationSpringBoot.entity.Show;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fotso
 */
public interface ShowRepository extends CrudRepository<Show, Long> {
	Show findBySlug(String slug);
	Show findByTitle(String title);
	List<Show> findByLocation(Location location);
}

