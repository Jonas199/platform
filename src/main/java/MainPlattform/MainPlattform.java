package MainPlattform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.swing.UIManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Test.CourseManagerTest;
import UserManager.User;
import UserManager.UserManager;
import CourseManager.Course;
import CourseManager.CourseManager;

@Path("/Plattform")
public class MainPlattform {
	
	UserManager userManager = new UserManager();
	CourseManager courseManager = new CourseManager();
	CourseManagerTest test = new CourseManagerTest(); 
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<User> userList = new ArrayList<User>();
	@GET
    @Path("/ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'MessageService' is running ==> ping");
        return "received ping on "+new Date().toString();
    }

	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/USERS")
    public JsonArray createNewUser(JsonObject data) throws Exception{
        JsonArray retArray = null;
        String UserName = null;
        try{
        	UserName = data.getString("UserName");
        	
        	userList.add(new User(UserName));

        }
        catch(Exception e){
        	System.out.println("get data as json failed");
        }
        return retArray;
    }
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/COURSES")
    public JsonArray createNewCourse(JsonObject data) throws Exception{
        JsonArray retArray = null;
        String CourseName = null;
        String CourseTopic = null;
        try{
        	CourseName = data.getString("CourseName");
        	CourseTopic = data.getString("CourseTopic");
        	courseList.add(new Course(CourseName, CourseTopic));
        }
        catch(Exception e){
        	System.out.println("get data as json failed");
        }
        return retArray;
    }
 
	@GET
  @Produces({MediaType.APPLICATION_JSON})
  @Path("/COURSES")
  public JsonArray getCourses() {
    	
		JsonArrayBuilder builder = Json.createArrayBuilder();
				for(Course c : courseList){
					System.out.println("Course Nr. "+c.getCourseId()+"; ->"+c.getName());
					builder.add(Json.createObjectBuilder()
					         .add("CourseId", c.getCourseId())
					         .add("name", c.getName())
					         .add("topic", c.getTopic())
					         .add("numberOfParticipants", c.getNumberOfParticipants()));
				}
		return builder.build();
		}  
	
	  @GET
	  @Produces({MediaType.APPLICATION_JSON})
	  @Path("/USERS")
	  public JsonArray getUsers() {
	    	
			JsonArrayBuilder builder = Json.createArrayBuilder();
					for(User u : userList){
						builder.add(Json.createObjectBuilder()
						         .add("UserId",u.getUserId())
						         .add("name", u.getUsername()));
					}
			return builder.build();
			}  
	

	
	public boolean save(CourseManager cm){
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("C:/Users/User/Desktop/CourseManager.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(cm);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in C:/Users/User/Desktop/CourseManager.ser");
	         return true;
	      } catch (IOException i) {
	         i.printStackTrace();
	         return false;
	      }
	}
	public CourseManager load(CourseManager cm){
		try {
	         FileInputStream fileIn = new FileInputStream("C:/Users/User/Desktop/CourseManager.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         CourseManager result = (CourseManager) in.readObject();
	         in.close();
	         fileIn.close();
	         return result;
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         System.out.println("CourseManager not found");
	         c.printStackTrace();
	         return null;
	      }
	}
}