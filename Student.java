// Harrison Arranz - Hurtado
// 500518860
import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects are compared by their name
public class Student implements Comparable<Student> 
{
  private String name;
  private String id;
  private  ArrayList<CreditCourse> courses;
  
  // Student Constructor 
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }

  public String getId()
  {
	  return id;
  }
  
  public String getName() 
  {
	  return name;
  }
  
  public boolean takenCourse(String courseCode) // getter method 
{
  for (int i = 0; i < courses.size(); i++) {
    if (courses.get(i).getCode().equalsIgnoreCase(courseCode)) 
      return true ;
  }
  return false ;
}

  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format, String sem, double grade)
  {
    CreditCourse cc = new CreditCourse(courseName, courseCode, descr, format, sem, grade) ;
    cc.setActive();
    courses.add(cc) ;
  }

  public double getGrade(String courseCode){
    for (int i = 0; i < courses.size(); i++){
      if (courses.get(i).getCode().equals(courseCode))
      {
       return courses.get(i).grade ;
      }
    }
    return 0 ;
  }

  public void setGrade(String courseCode, double grade){
    for (int i = 0; i < courses.size(); i++){
      if (courses.get(i).getCode().equalsIgnoreCase(courseCode))
      {
      courses.get(i).grade  = grade ;
      courses.get(i).setInactive() ;
      }
    }
  }


  
  
  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript()
  {
    for (int i = 0; i < courses.size(); i++){
      if (!courses.get(i).active)
        System.out.println(courses.get(i).displayGrade());
    }
  }
  
  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses()
  {
    for (int i = 0; i < courses.size(); i++){
      if (courses.get(i).active)
        System.out.println(courses.get(i).getDescription());
    }
  }

  public void printCompletedCourses(){
    for (int i = 0; i < courses.size(); i++){
      if (!courses.get(i).active)
        System.out.println(courses.get(i).getDescription());
  }
}
  
  // Drop a course (given by courseCode)
  // Find the credit course in courses arraylist above and remove it
  // only remove it if it is an active course
  public void removeActiveCourse(String courseCode)
  {
    for (int i = 0; i < courses.size(); i++){
      if (courses.get(i).getCode().equals(courseCode) && courses.get(i).active){
        courses.remove(i) ;
        return ;
      }
    }
  }
  
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  
  // override equals method inherited from superclass Object
  // if student names are equal *and* student ids are equal (of "this" student
  // and "other" student) then return true
  // otherwise return false
  // Hint: you will need to cast other parameter to a local Student reference variable

  public boolean equals(Object other)
  {
    Student s = (Student) other ;
    return this.name.equals(s.name) && this.id.equals(s.id) ;
  }

  // Override method
  @Override 
  public int compareTo(Student student_name) {
    return this.name.compareTo(student_name.name); 
  }

  public static ArrayList<ActiveCourse> grade() {
	  return grade() ;
  }
  
}
