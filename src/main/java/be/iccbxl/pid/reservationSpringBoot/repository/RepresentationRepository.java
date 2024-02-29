/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.repository;

import be.iccbxl.pid.reservationSpringBoot.entity.Location;
import be.iccbxl.pid.reservationSpringBoot.entity.Representation;
import be.iccbxl.pid.reservationSpringBoot.entity.Show;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fotso
 */
public interface RepresentationRepository extends CrudRepository<Representation, Long> {
	List<Representation> findByShow(Show show);
	List<Representation> findByLocation(Location location);
	List<Representation> findByWhen(LocalDateTime when);
}