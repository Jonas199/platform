package UserManager;

import javax.json.Json;
import javax.json.JsonObject;

public class User {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	JsonObject getAsJson(){
		JsonObject CmpMsg = Json.createObjectBuilder()
	         .add("username", username)
	         .build();
		return CmpMsg;
	}

}
