package Test;

import CourseManager.Course;
import CourseManager.CourseManager;
import MainPlattform.MainPlattform;
import UserManager.User;
import UserManager.UserManager;

public class CourseMangerTest {
	
	static UserManager uManager = new UserManager();
	static CourseManager cManager = new CourseManager();
	static MainPlattform mPlattform = new MainPlattform();

	public static void main(String[] args) {
		System.out.println("CourseManagerTest");
		User testUser = uManager.createNewUser("TestUser");
		User testUser1 = uManager.createNewUser("TestUser1");
		Course testCourse = cManager.createCourse("Test","Test");
		testCourse.addParticipant(testUser);
		System.out.println(testUser.getUserId());
		System.out.println(testUser1.getUserId());
		printCourseList();
		
		mPlattform.getCourses();
	}
	
	public static void printCourseList(){
		for(Course c : cManager.getCourseList()){
			System.out.println(c.getName());
		}
	}

}
