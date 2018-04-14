package UserManager;

import javax.json.Json;
import javax.json.JsonObject;




public class User {
	private String username;
	private static int id = 0;
	private int userId;
	
	public User(String username){
		this.username = username;
		this.userId = id;
		id++;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getUserId(){
		return this.userId;
	}
	
	JsonObject getAsJson(){
		JsonObject CmpMsg = Json.createObjectBuilder()
	         .add("username", username)
	         .add("userId", userId)
	         .build();
//		JsonObject CmpMsg = new JsonObject();
//        CmpMsg.addProperty("username", username);
//        CmpMsg.addProperty("userId", userId);
		return CmpMsg;
	}

}
