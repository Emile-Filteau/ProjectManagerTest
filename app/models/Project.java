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
	
	@ManyToOne
	public User owner;
	
	@ManyToMany
	public List<User> partners;
	
	public Project(String name, User owner) {
		this.name = name;
		this.owner = owner;
		this.status = ProjectStatus.created;
	}
}