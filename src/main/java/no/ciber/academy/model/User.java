package no.ciber.academy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;

@Entity(name="UserTable")
public class User {
	@Id @GeneratedValue
	private long id;
	
	private String name;
	
	private String password;
	
	private boolean isAdmin;
	
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> loans = new HashSet<Book>();
	
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

	public Set<Book> getLoans() {
		return loans;
	}

	public void setLoans(Set<Book> loans) {
		this.loans = loans;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
