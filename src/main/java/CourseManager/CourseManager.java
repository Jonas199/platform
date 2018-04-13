package CourseManager;

import java.util.ArrayList;

public class CourseManager {
	
	ArrayList<Course> courseList = new ArrayList<Course>();
	
	public Course createCourse(String name, String topic){
		Course c = new Course(name, topic);
		courseList.add(c);
		return c;
	}
	
	boolean deleteCourse(int id){
		try{
		courseList.remove(id);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	

}
