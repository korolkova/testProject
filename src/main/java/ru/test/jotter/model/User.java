package ru.test.jotter.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition="serial", nullable = false, insertable = true, updatable = true)
	private long id;
	
	@Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 64)
	private String name;
		
	@Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 64)
	private String email;
	
	public User(int id, String name, String email){
		this.id=id;
		this.name=name;
		this.email=email;
	}
	public User(){
		this.id=-1;
		this.name=null;
		this.email=null;
	}
				
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int)id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}