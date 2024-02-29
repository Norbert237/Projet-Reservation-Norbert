/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.entity;

import be.iccbxl.pid.reservationSpringBoot.repository.ArtistRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fotso
 */
@Service
public class ArtistService {
	@Autowired
	private ArtistRepository artistRepository;
		
	public List<Artist> getAllArtists() {
		List<Artist> artists = new ArrayList<>();
		
		artistRepository.findAll().forEach(artists::add);
		
		return artists;
	}
	
	public Artist getArtist(String id) {
		int indice = Integer.parseInt(id);
		
		return artistRepository.findById(indice);
	}

	public void addArtist(Artist artist) {
		artistRepository.save(artist);
	}

	public void updateArtist(Long id, Artist artist) {
		artistRepository.save(artist);
	}

	public void deleteArtist(String id) {
		Long indice = (long) Integer.parseInt(id);
		
		artistRepository.deleteById(indice);
	}
}

