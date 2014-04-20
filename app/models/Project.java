package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Project extends Model {
	
	public enum Status {
		active,
		inactive,
		completed
	};

	public String name;
	public String description;
	public Status status;
	
	
	public Date startDate;
	public Date endDate;
	
	@ManyToOne
	public User owner;
	
	@ManyToMany
	public List<User> partners;
	
	@OneToMany
	public List<Task> tasks;
	
	public Project(String name, String description, User owner) {
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.status = Status.active;
		this.partners = new ArrayList<User>();
		
		this.startDate = new Date();
	}
	
	public boolean canBeSeenBy(User u) {
		if(owner == u)
			return true;
		for(User partner : partners) {
			if(partner == u) {
				return true;
			}
		}
		return false;
	}
	
	public void completeProject() {
		this.status = Status.completed;
		this.endDate = new Date();
	}
}