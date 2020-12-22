// Harrison Arranz - Hurtado
// 500518860
import java.util.ArrayList;

public class CreditCourse extends Course
{
	private String semester ;
	public double grade ;
	public boolean active ;
	// private ArrayList<Course> courses;

	// add a constructor method with appropriate parameters
	// should call the super class constructor
	public CreditCourse(String name, String code, String descr, String fmt, String semester, Double grade) {
		// use super() to inheret variables from Base Class Course
		super(name, code, descr, fmt);
		this.semester = semester;
		this.grade = grade;
	}

	public void setActive() {
		// add code
		active = true;

	}

	public void setInactive() {
		// add code
		active = false;
	}
	
	public String displayGrade()
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		 
		return getCode() + " " + getName() + " Grade " + convertNumericGrade(grade) ;
	}
	
}