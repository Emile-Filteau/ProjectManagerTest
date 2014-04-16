package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void users() {
    	List<User> users = User.findAll();
    	
    	render(users);
    }
    
    public static void datageneration() {
    	User user = new User("Jesus", User.UserRole.boss);
    	user.save();
    	
    	user = new User("John", User.UserRole.developer);
    	user.save();
    	
    	user = new User("Bob", User.UserRole.developer);
    	user.save();
    	
    	Project pj = new Project("PrototypeJetableWeb");
    	pj.save();
    	
    	pj = new Project("Integra");
    	pj.save();
    }

}