package UserManager;

import java.util.ArrayList;

public class UserManager {
	
	ArrayList<User> userList = new ArrayList<User>();
	
	public User createNewUser(String username){
		User u = new User(username);
		userList.add(u);
		return u;
	}
	

}
