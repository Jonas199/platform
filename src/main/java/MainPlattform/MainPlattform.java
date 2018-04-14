package MainPlattform;



import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;








import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.swing.UIManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;






import UserManager.UserManager;
import CourseManager.Course;
import CourseManager.CourseManager;

@Path("/Plattform")
public class MainPlattform {
	
	UserManager userManager = new UserManager();
	CourseManager courseManager = new CourseManager();
	
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
        	UserName = data.get("UserName").toString();
        	
        	userManager.createNewUser(UserName);
        	
//        	retArray = Json.createArrayBuilder()
//           	     .add(Json.createObjectBuilder()
//           	         .add("UserName", UserName)
//           	         .add("Status", "success"))
//           	     .build();
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
        	CourseName = data.get("CourseName").toString();
        	CourseTopic = data.get("CourseTopic").toString();
        	courseManager.createCourse(CourseName, CourseTopic);
        	
//        	retArray = Json.createArrayBuilder()
//           	     .add(Json.createObjectBuilder()
//           	         .add("UserName", CourseName)
//           	         .add("Status", "success"))
//           	     .build();
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
		System.out.println("Show all courses:");
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for(Course c : courseManager.getCourseList()){
			builder.add(c.getAsJson().toString());
			System.out.println("CourseName: "+c.getName());
		}
		return builder.build();
    }  

}