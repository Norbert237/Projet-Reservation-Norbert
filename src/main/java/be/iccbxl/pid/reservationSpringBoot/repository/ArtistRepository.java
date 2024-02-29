/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.repository;

import be.iccbxl.pid.reservationSpringBoot.entity.Artist;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fotso
 */
public interface ArtistRepository extends CrudRepository<Artist, Long> {

    List<Artist> findByLastname(String lastname);

    Artist findById(long id);

}
