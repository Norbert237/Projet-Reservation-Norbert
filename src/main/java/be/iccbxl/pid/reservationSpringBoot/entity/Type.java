/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;








/**
 *
 * @author fotso
 */
@Entity
@Table(name="types")
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
        @NotEmpty(message = "The type must not be empty.")
	@Size(min=3, max=60, message = "The type must be 60 characters long.")
	private String type;
	
        @ManyToMany
	@JoinTable(
		  name = "artist_type", 
		  joinColumns = @JoinColumn(name = "type_id"), 
		  inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private List<Artist> artists = new ArrayList<>();

	public Type() { 
        }

    public Type(Long id, String type) {
        this.type = type;
    }
	
	
	
	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
        public List<Artist> getArtists() {
		return artists;
	}

	public Type addArtist(Artist artist) {
		if(!this.artists.contains(artist)) {
			this.artists.add(artist);
			artist.addType(this);
		}
		
		return this;
	}
	
	public Type removeType(Artist artist) {
		if(this.artists.contains(artist)) {
			this.artists.remove(artist);
			artist.getTypes().remove(this);
		}
		
		return this;
	}

        
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + "]";
	}
}

