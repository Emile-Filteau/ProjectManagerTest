package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Project extends Model {
	
	public enum ProjectStatus {
		created,
		conception,
		developement,
		production,
		dead
	};

	public String name;
	public ProjectStatus status;
	
	@ManyToMany
	public List<User> members;
	
	public Project(String name) {
		this.name = name;
		this.status = ProjectStatus.created;
	}
}
/**
package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class User extends Model {
 
    public String email;
    public String password;
    public String fullname;
    public boolean isAdmin;
    
    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
 
}
*/