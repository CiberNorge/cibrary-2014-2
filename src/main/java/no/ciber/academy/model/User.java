package no.ciber.academy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;

import org.springframework.context.annotation.Scope;

@Entity(name="UserTable")
public class User {
	@Id @GeneratedValue
	private long id;
	
	private String name;
	
	private String password;
	
	private boolean isAdmin;
	
	public User() { }
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
