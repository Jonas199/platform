package CourseManager;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseManager implements Serializable {
	
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
		
	public Course createCourse(String name, String topic){
		Course c = new Course(name, topic);
		this.courseList.add(c);
		return c;
	}
	
	boolean deleteCourse(int id){
		try{
		this.courseList.remove(id);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public ArrayList<Course> getCourseList(){
		return this.courseList;
	}
	

}
