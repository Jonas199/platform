package CourseManager;

import java.io.Serializable;
import java.util.ArrayList;







import javax.json.Json;



import javax.json.JsonObject;

import UserManager.User;

public class Course implements Serializable{
	private static int id = 0;
	private String name;
	private String topic;
	int numberOfParticipants;
	private int CourseId;
	private User owner;
	private ArrayList<String> tags;
	private ArrayList<User> participantList;
	
	public Course(String name, String topic){
		this.name = name;
		this.topic = topic;
		this.participantList = new ArrayList<User>();
		this.tags = new ArrayList<String>();
		this.CourseId = id;
		id++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public ArrayList<User> getParticipants(){
		return this.participantList;
	}
	
	public void addParticipant(User u){
		this.participantList.add(u);
	}
	
	public void deleteParticipant(int id){
		this.participantList.remove(id);
	}
	
	public int getCourseId(){
		return this.CourseId;
	}
	
	public User getOwner(){
		return this.getOwner();
	}
	
	public int getNumberOfParticipants(){
		return this.numberOfParticipants;
	}
	
	public void addTag(String tag){
		this.tags.add(tag);
	}
	public JsonObject getAsJson(){
		JsonObject CmpMsg = Json.createObjectBuilder()
			 .add("CourseId", CourseId)
			 .add("name", name)
	         .add("topic", topic)
	         .add("numberOfParticipants",numberOfParticipants )
	         .build();
//		JsonObject CmpMsg = new JsonObject();
//		 CmpMsg.addProperty("CourseId", CourseId);
//		 CmpMsg.addProperty("name", name);
//		 CmpMsg.addProperty("topic", topic);
//		 CmpMsg.addProperty("numberOfParticipants",numberOfParticipants );
		return CmpMsg;
	}



	public void setOwner(User owner) {
		this.owner = owner;
	}
}
