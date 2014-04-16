package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Scope.Session;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void login(Boolean isError) {
    	if(Session.current().get("username") == null) {
	    	render(isError);
    	} else {
    		index();
    	}
    }
    
    public static void logout() {
    	Session.current().clear();
    	
    	login(false);
    }
    
    public static void authenticate(String username, String password) {
    	User user = User.find("name = ? and password = ?", username, password).first();
    	
    	if(user != null) {
    		Session.current().put("username", username);
    		index();
    	} else {
    		login(true);
    	}
    }
    
    public static void projects() {
    	List<Project> projects = Project.findAll();
    	
    	render(projects);
    }
    
    public static void createproject() {
    	projects();
    }
    
    public static void generatedata() {
    	User user = new User("Jesus", "123", User.UserRole.boss);
    	user.save();
    	
    	user = new User("John", "123", User.UserRole.developer);
    	user.save();
    	
    	user = new User("Bob", "123", User.UserRole.developer);
    	user.save();
    	
    	Project pj = new Project("PrototypeJetableWeb");
    	pj.save();
    	
    	pj = new Project("Integra");
    	pj.save();
    }

}