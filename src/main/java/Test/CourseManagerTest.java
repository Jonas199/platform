package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.json.Json;
import javax.json.JsonObject;

import CourseManager.Course;
import CourseManager.CourseManager;
import MainPlattform.MainPlattform;
import UserManager.User;
import UserManager.UserManager;

public class CourseManagerTest {
	
	static UserManager uManager = new UserManager();
	static CourseManager cManager = new CourseManager();
	static MainPlattform mPlattform = new MainPlattform();

	public static void main(String[] args) {
//		System.out.println("CourseManagerTest");
//		User testUser = uManager.createNewUser("TestUser");
//		User testUser1 = uManager.createNewUser("TestUser1");
		Course testCourse = cManager.createCourse("Test","Test");
		cManager.createCourse("Test123","Test123");
//		testCourse.addParticipant(testUser);
//		System.out.println(testUser.getUserId());
//		System.out.println(testUser1.getUserId());
//		printCourseList(cManager);
		JsonObject data = Json.createObjectBuilder()
				 .add("CourseName", "TestCourse")
				 .add("CourseTopic", "TestTopic")
		         .build();
		try {
			mPlattform.createNewCourse(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mPlattform.load(cManager);
		mPlattform.save(cManager);
		cManager.createCourse("Testasdf123","Testasdf123");
		mPlattform.save(cManager);
		mPlattform.load(cManager);
		
		mPlattform.getCourses();
	}
	
	public static void printCourseList(CourseManager cM){
		System.out.println("---print courses begin----:");
		for(Course c : cM.getCourseList()){
			System.out.println(c.getName());
		}
		System.out.println("---print courses end----:");
	}

}
