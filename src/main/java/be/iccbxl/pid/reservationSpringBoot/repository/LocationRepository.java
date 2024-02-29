/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.repository;

import be.iccbxl.pid.reservationSpringBoot.entity.Location;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fotso
 */
public interface LocationRepository extends CrudRepository<Location, Long> {
	Location findByDesignation(String designation);
	Optional<Location> findById(Long id);
}
