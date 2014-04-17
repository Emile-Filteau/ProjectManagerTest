package controllers;

import play.*;
import play.cache.Cache;
import play.mvc.*;
import play.mvc.Scope.Session;

import java.util.*;

import models.*;

public class Personal extends Controller {

	@Before
    static void checkAuthentification() {
        if(session.get("user") == null)
        	Public.login();
    }
	
    public static void index() {
        render();
    }
    
    public static void logout() {
    	Session.current().clear();
    	Public.index();
    }
    
    public static void projects() {
    	Long id = Long.parseLong(Session.current().get("user_id"));
    	
    	User u = User.findById(id);
    	
    	List<Project> projects = Project.find("owner = ?", u).fetch();
    	
    	render(projects);
    }
    
    public static void createproject(String projectname) {
    	if(projectname != null) {
    		Long id = Long.parseLong(Session.current().get("user_id"));
        	User u = User.findById(id);
        	
    		Project p = new Project(projectname, u);
    		p.save();
    		
    		projects();
    	} else {
    		render();
    	}
    }

}