package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Task extends Model {
	
	public enum Status {
		active,
		inactive,
		completed,
		problem,
		late,
		/*etc...*/
	};

	public String name;
	public String description;
	public Status status;
	
	public Date startDate;
	public Date endDate;
	
	@OneToOne
	public User assignedMember;
	
	public Task(String name, String description, User member) {
		this.name = name;
		this.description = description;
		this.assignedMember = member;
		this.status = Status.active;
		
		this.startDate = new Date();
	}
}