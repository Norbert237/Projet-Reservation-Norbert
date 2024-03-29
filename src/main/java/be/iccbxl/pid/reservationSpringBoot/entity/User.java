/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.iccbxl.pid.reservationSpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fotso
 */
@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;
    private LocalDateTime created_at;
    
    @ManyToMany(mappedBy = "users")
    private List<Role> roles = new ArrayList<>();
    
    @ManyToMany(mappedBy = "users")
	private List<Representation> representations = new ArrayList<>();



    protected User() {
    }

    public User(String login, String firstname, String lastname) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.created_at = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User addRole(Role role) {
		if(!this.roles.contains(role)) {
			this.roles.add(role);
			role.addUser(this);
		}
		
		return this;
	}
	
	public User removeRole(Role role) {
		if(this.roles.contains(role)) {
			this.roles.remove(role);
			role.getUsers().remove(this);
		}
		
		return this;
	}


        
        public List<Representation> getRepresentations() {
		return representations;
	}

public User addRepresentation(Representation representation) {
		if(!this.representations.contains(representation)) {
			this.representations.add(representation);
			representation.addUser(this);
		}
		
		return this;
	}
	
	public User removeRepresentation(Representation representation) {
		if(this.representations.contains(representation)) {
			this.representations.remove(representation);
			representation.getUsers().remove(this);
		}
		
		return this;
	}


        @Override
	public String toString() {
		return login + "(" + firstname + " " + lastname + ")";
	}
  
    
    
    
    
}
