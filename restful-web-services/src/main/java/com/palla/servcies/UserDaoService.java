package com.palla.servcies;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


import com.palla.data.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	private static int userCount = 3;
	
	static {
		users.add(new User(1,"Raj",new Date()));
		users.add(new User(2,"Kiran",new Date()));
		users.add(new User(1,"Palla",new Date()));
	}
	
	public User getUser( Integer id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
	public User saveUser(User user) {
		if(user.getId() == null){
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public List<User> getAllUsers(){
		return users;
	}

}
