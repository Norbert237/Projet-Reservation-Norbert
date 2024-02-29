/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.repository;

import be.iccbxl.pid.reservationSpringBoot.entity.Locality;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fotso
 */
public interface LocalityRepository extends CrudRepository<Locality, Long> {
	Locality findByPostalCode(String postalCode);
	Locality findByLocality(String locality);
}

