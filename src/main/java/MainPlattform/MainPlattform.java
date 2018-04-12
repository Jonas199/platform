package MainPlattform;



import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Plattform")
public class MainPlattform {
	
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
        	retArray = Json.createArrayBuilder()
           	     .add(Json.createObjectBuilder()
           	         .add("UserName", UserName)
           	         .add("Status", "success"))
           	     .build();
        }
        catch(Exception e){
        	System.out.println("get data as json failed");
        }
        return retArray;
    }
       
}