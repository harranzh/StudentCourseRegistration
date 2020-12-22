// Harrison Arranz - Hurtado
// 500518860
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
public class ActiveCourse extends Course 
{
	public ArrayList<Student> students; 
   private String             semester;
   public Integer lectureStart ;
   public Integer lectureDuration ;
   public String lectureDay ;
   
   public ActiveCourse(String name, String code, String descr, String fmt,String semester, ArrayList<Student> students)
   {
      super(name, code, descr, fmt); 
      this.students = new ArrayList<Student>(students) ;
      this.semester = semester ;
   }

   public void lectureDay(String Day)
   {
      this.lectureDay = Day ;
   }

   public void lectureDuration(int Duration)
   {
      this.lectureDuration = Duration ;
   }

   public void lectureStart(int Start)
   {
      this.lectureStart = Start ;
   }
   
   public void setStart()
   {
      lectureStart = 0 ;
   }

   public void setDuration()
   {
      lectureDuration = 0 ;
   }

   public void setDate()
   {
      lectureDay = " " ;
   }

   public String getSemester()
   {
	   return semester ;
   }
   
   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
      for (int i = 0; i < students.size(); i++) {
         System.out.println(students.get(i).toString()) ;
      }
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   public void printGrades()
   {
	   for (int i = 0; i < students.size(); i++) {
         Student s = students.get(i) ;
         System.out.println(s.getId() + " " + s.getName() + " " + s.getGrade(getCode())) ;
      }
  }
   
   // Returns the numeric grade in this course for this student
   // If student not found in course, return 0 
   public double getGrade(String studentId)
   {
	  // Search the student's list of credit courses to find the course code that matches this active course
	  // see class Student method getGrade() 
     // return the grade stored in the credit course object
     for (int i = 0; i < students.size(); i++) {
        if (studentId.equals(students.get(i).getId())){
           return  students.get(i).getGrade(getCode()) ;
        }
      }
      return 0 ;
   }

   public boolean enrolled(String studentId)
   {
      for (int i = 0; i < students.size(); i++){
         if (studentId.equals(students.get(i).getId()))
            return true ;
      }
      return false ;
   }

   public void remove(String id){
      for (int i = 0; i < students.size(); i++){
         Student s = students.get(i) ;
         if (s.getId().equals(id)){
            students.remove(i);
            return ;
         }
      }
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   @Override
   public String getDescription()
   {
      return super.getDescription() + " " + semester + " Enrollment: " + students.size() + "\n" ;
   }
    
   
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {
 	  Collections.sort(students, new NameComparator()) ;
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator<Student>
   {
      @Override
      public int compare(Student a, Student b) {
         return a.getName().compareTo(b.getName()) ;
      }
   } 
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
 	  Collections.sort(students, new IdComparator()) ; 
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator<Student> 
   {
      @Override
   	public int compare(Student a, Student b) {
         return a.getId().compareTo(b.getId()) ;
      }
   }
}
