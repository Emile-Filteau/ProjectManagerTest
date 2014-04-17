package controllers;

import play.*;
import play.cache.Cache;
import play.mvc.*;
import play.mvc.Scope.Session;

import java.util.*;

import models.*;

public class Public extends Controller {
	
	@Before(unless={"login", "authentication"})
    static void checkAuthentification() {
        if(session.get("user") != null)
        	Personal.index();
    }

    public static void index() {
        render();
    }
    
    public static void login(String username, String password) {
    	String error = "";
    	if(username != null && password != null) {
    		if(!username.equals("") && !password.equals("")) {
    			User user = User.find("name = ? and password = ?", username, password).first();
            	if(user != null) {
            		Session.current().put("user", username);
            		Session.current().put("user_id", user.id);
            		Personal.index();
            	} else {
            		error = "Incorect username and/or password";
            		render(error);
            	}
    		} else {
    			error = "All fields are required";
    			render(error);
    		}
    	} else {
    		render();
    	}
    }
    
    public static void register(String username, String password) {
    	System.out.println("REGISTER");
    	String error = "";
    	if(username != null && password != null) {
    		if(!username.equals("") && !password.equals("")) {
    			User u = User.find("name = ?", username).first();
            	if(u == null) {
            		User newUser = new User(username, password);
            		newUser.save();
            		login(username, password);
            	} else {
            		error = "Username already taken";
            		render(error);
            	}
    		} else {
    			error = "All fields are required";
    			render(error);
    		}
    	} else {
    		render();
    	}
    }
    
    public static void generatedata() {
    	User user = new User("Jesus", "123");
    	user.save();
    	
    	user = new User("John", "123");
    	user.save();
    	
    	user = new User("Bob", "123");
    	user.save();
    	
    	Project pj = new Project("PrototypeJetableWeb", user);
    	pj.save();
    	
    	pj = new Project("Integra", user);
    	pj.save();
    }

}