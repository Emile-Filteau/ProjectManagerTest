package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class User extends Model {
	
	public enum UserRole {
		client,
		developer,
		boss
	};
	
	public String name;
	public String password;
	public UserRole role;
	
	public User(String name, String password, UserRole role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
}