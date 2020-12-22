
// Harrison Arranz - Hurtado
// 500518860
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Registry 
{
	private static ArrayList<Student>  students = new ArrayList<Student>();
	private static ArrayList<ActiveCourse> courses = new ArrayList<ActiveCourse>();


	public Registry() throws IOException {
		
		final Student s1 = new Student("JohnOliver", "34562");
		final Student s2 = new Student("HarryWindsor", "38467");
		final Student s3 = new Student("SophieBrown", "98345");
		final Student s4 = new Student("FaisalQuereshi", "57643");
		final Student s5 = new Student("GenghisKhan", "25347");
		final Student s6 = new Student("SherryTu", "46532");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);

		// sort the students alphabetically - see class Student
		Collections.sort(students);

		ArrayList<Student> list = new ArrayList<Student>();

		// CPS209
		String courseName = "Computer Science II";
		String courseCode = "CPS209";
		String descr = "Learn how to write complex programs!";
		String format = "3Lec 2Lab";
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
		
		// CPS511
		list.clear();
		courseName = "Computer Graphics";
		courseCode = "CPS511";
		descr = "Learn how to write cool graphics programs";
		format = "3Lec";
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "F2020", list));
		
		// CPS643
		list.clear();
		courseName = "Virtual Reality";
		courseCode = "CPS643";
		descr = "Learn how to write extremely cool virtual reality programs";
		format = "3Lec 2Lab";
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));

		// CPS706
		courseName = "Computer Networks";
		courseCode = "CPS706";
		descr = "Learn about Computer Networking";
		format = "3Lec 1Lab";
		courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));

		// CPS616
		courseName = "Algorithms";
		courseCode = "CPS616";
		descr = "Learn about Algorithms";
		format = "3Lec 1Lab";
		courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));

	}

	// Add new student to the registry (students arraylist above)
	public static boolean addNewStudent(String name, String id) throws FileNotFoundException {
		if (findStudent(id) != null)
			return false;
		students.add(new Student(name, id));
		Collections.sort(students);
		return true;
	}

	// Remove student from registry
	public boolean removeStudent(String studentId) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId().equals(studentId)) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}

	// Print all registered students
	public void printAllStudents() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName());
		}

	}

	private static Student findStudent(String studentId) {
		for (int i = 0; i < students.size(); i++) {
			Student s = students.get(i);
			if (s.getId().equals(i))
				return s ;
		}
		return null ;
	}

	private ActiveCourse findCourse(String code)
	{
		for (int i = 0; i < courses.size(); i++){
			if (courses.get(i).getCode().equalsIgnoreCase(code))
				return courses.get(i) ;
		}
		return null;
	}

	// Given a studentId and a course code, add student to the active course
	public void addCourse(String studentId, String courseCode) throws IOException
	{
		Student s = findStudent(studentId) ;
		if (s == null) 
			return ; 
		if (s.takenCourse(courseCode))
			return ;
		ActiveCourse ac = findCourse(courseCode) ;
		if (ac == null)
			return ;
		if (ac.enrolled(studentId))
			return ;

		ac.students.add(s) ;
		s.addCourse(ac.getName(), ac.getCode(), ac.getDescription(), ac.getFormat(), ac.getSemester(), 0);
	}
		
   
   // Given a studentId and a course code, drop student from the active course
   public void dropCourse(String studentId, String courseCode)
   {
	   Student s = findStudent(studentId) ;
	   if (s == null)
		   return ;
		
		ActiveCourse ac = findCourse(courseCode) ;
		if (ac == null)
			return ;
		
		ac.remove(studentId) ;
		s.removeActiveCourse(courseCode) ;
   }
   
   // Print all active courses
   public void printActiveCourses()
   {
	   for (int i = 0; i < courses.size(); i++)
	   {
		   System.out.println(courses.get(i).getDescription()) ;
	   }
   }
   
   // Print the list of students in an active course
   public void printClassList(String courseCode)
   {
		ActiveCourse ac = findCourse(courseCode) ;
		if (ac == null)
			return ;
		ac.printClassList();
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseByName(String courseCode)
   {
		ActiveCourse ac = findCourse(courseCode) ;
		if (ac == null)
			return ;
		ac.sortByName();
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseById(String courseCode)
   {
	  ActiveCourse ac = findCourse(courseCode) ;
	  if (ac == null)
		  return ;
		
		ac.sortById();
   }
   
   // Given a course code, find course and print student names and grades
   public void printGrades(String courseCode)
   {
		ActiveCourse ac = findCourse(courseCode) ;
		if (ac == null)
			return ;
		
		ac.printGrades();
   }
   
   // Given a studentId, print all active courses of student
   public void printStudentCourses(String studentId)
   {
		Student s = findStudent(studentId) ;
		if (s == null)
			return ;
		
		s.printActiveCourses();
	}
   
   // Given a studentId, print all completed courses and grades of student
   public void printStudentTranscript(String studentId)
   {
		Student s = findStudent(studentId) ;
		if (s == null)
			return ;
		
		s.printTranscript();
   }
   
   // Given a course code, student id and numeric grade
   // set the final grade of the student
   public void setFinalGrade(String courseCode, String studentId, double grade)
   {
	   Student s = findStudent(studentId) ;
	   if (s == null)
		   return ;
		s.setGrade(courseCode, grade) ;

		ActiveCourse ac = findCourse(courseCode) ;
		if (ac == null) 
			return ;
		ac.remove(studentId) ;
   }

	// Helper method to open file
   static Scanner scanner1 = new Scanner(System.in);
	public static void openFile() throws IOException
	{
		try {
			scanner1 = new Scanner(new File("students.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	// Helper method to read line by line 
	public static void readFile() 
	{
		while (scanner1.hasNextLine()) {
			String temp_name;
			String temp_id;
			temp_name = scanner1.nextLine();
			temp_id = scanner1.nextLine();
			// Adding student to students arraylist 
			students.add(new Student(temp_name, temp_id));
		}
	}
   
}
