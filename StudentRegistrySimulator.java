
// Harrison Arranz - Hurtado
// 500518860
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentRegistrySimulator 
{
  public static void main(String[] args) throws IOException 
  {
	  Registry registry = new Registry();
	  try{
		  Registry.openFile() ;
		  Registry.readFile() ;	
	  }
	  catch(FileNotFoundException e){
		System.out.println(e);
	  }
	  
	  Scheduler schedule = new Scheduler() ;

	  Scanner scanner = new Scanner(System.in);
	  
	  System.out.print(">");

		while (scanner.hasNextLine()) {
			String inputLine = scanner.nextLine();
			if (inputLine == null || inputLine.equals(""))
				continue;

			Scanner commandLine = new Scanner(inputLine);
			String command = commandLine.next();

			if (command == null || command.equals(""))
				continue;

			else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST")) {
				registry.printAllStudents();
			} else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
				return ;

			else if (command.equalsIgnoreCase("REG")) {
				// get name and student id string
				// ensure id string is all numeric characters
				String username = null;
				String id = null ;
				// checking if username is only letters from the alphabet
				if (commandLine.hasNext()) {
					// getting username from scanner
					username = commandLine.next() ;
					// ensure name is all alphabetic characters
					String lowercase = username.toLowerCase() ;
					if(!isStringOnlyAlphabet(lowercase))
					{
						System.out.println("Invalid username " + username);
						continue ;
					}
				}
				// getting id from scanner
				if (commandLine.hasNext())
				{
					id = commandLine.next() ;
					if (!isNumeric(id)) 
					{
						System.out.println("ID entered incorrect " + id);
						continue ;	
					}
					if(!registry.addNewStudent(username, id))					
						System.out.println("Student " + username + " already registered.");
				}
			} else if (command.equalsIgnoreCase("DEL")) {
				if (commandLine.hasNext()) {
					// get student id
					String studentId = commandLine.next();
					// ensure numeric
					if (!isNumeric(studentId))
						System.out.println("ID entered incorrect " + studentId);
					// delete a student from registry
					// remove student from registry
					registry.removeStudent(studentId);
				}

			}

			else if (command.equalsIgnoreCase("ADDC")) {
				// add a student to an active course
				// get student id and course code strings
				// add student to course (see class Registry)
				String studentId = null;
				String courseCode = null;
				if (commandLine.hasNext())
					studentId = commandLine.next();
				if (commandLine.hasNext()) {
					courseCode = commandLine.next();
					registry.addCourse(studentId, courseCode);
				}
			} else if (command.equalsIgnoreCase("DROPC")) {
				// get student id and course code strings
				// drop student from course (see class Registry)
				String studentId = null;
				String courseCode = null;
				if (commandLine.hasNext())
					studentId = commandLine.next();
				if (commandLine.hasNext()) {
					courseCode = commandLine.next();
					registry.dropCourse(studentId, courseCode);
				}
			} else if (command.equalsIgnoreCase("PAC")) {
				// print all active courses
				registry.printActiveCourses();
			} else if (command.equalsIgnoreCase("PCL")) {
				// get course code string
				String courseCode = null;
				if (commandLine.hasNext()) {
					courseCode = commandLine.next();
					registry.printClassList(courseCode); // print class list (i.e. students) for this course
				}

			} else if (command.equalsIgnoreCase("PGR")) {
				String courseCode = null;
				if (commandLine.hasNext()) {
					courseCode = commandLine.next();
					registry.printGrades(courseCode);
				}
			} else if (command.equalsIgnoreCase("PSC")) {
				// get student id string
				String studentId = null;
				if (commandLine.hasNext()) {
					studentId = commandLine.next();
					// print all credit courses of student
					registry.printStudentCourses(studentId);
				}

			} else if (command.equalsIgnoreCase("PST")) {
				// get student id string
				String studentId = null;
				if (commandLine.hasNext()) {
					studentId = commandLine.next();
					registry.printStudentTranscript(studentId);
				}
			} else if (command.equalsIgnoreCase("SFG")) {
				String courseCode = null;
				String studentId = null;
				String grade = null;
				double numGrade = 0;

				if (commandLine.hasNext()) {
					courseCode = commandLine.next();
				}
				if (commandLine.hasNext()) {
					studentId = commandLine.next();
				}
				if (commandLine.hasNext()) {
					grade = commandLine.next();
					if (!isNumeric(grade))
						continue;
					numGrade = Integer.parseInt(grade);
					registry.setFinalGrade(courseCode, studentId, numGrade);
				}
			} else if (command.equalsIgnoreCase("SCN")) {
				String courseCode = null;
				if (commandLine.hasNext()) {
					courseCode = commandLine.next();
					registry.sortCourseByName(courseCode);
				}
			} else if (command.equalsIgnoreCase("SCI")) {
				String courseCode = null;
				if (commandLine.hasNext()) {
					courseCode = commandLine.next();
					registry.sortCourseById(courseCode);
				}
			} else if (command.equalsIgnoreCase("SCH")){
				String courseCode = null ;
				String day = null ;
				int start = 0 ;
				int duration = 0 ;
				if(commandLine.hasNext())
				{
					courseCode = commandLine.next() ;
				}
				if(commandLine.hasNext())
				{
					day = commandLine.next() ;
				}
				if(commandLine.hasNext())
				{
					start = commandLine.nextInt() ;
				}
				if(commandLine.hasNext())
				{
					duration = commandLine.nextInt() ;
					// Send courseCode, day, start, and duration parameters to the Scheduler method
					// should also throw exception if any of the checks go through
					schedule.setDayAndTime(courseCode, day, start, duration) ;
				}

			} else if (command.equalsIgnoreCase("CSCH")){
				String courseCode = null ;
				if (commandLine.hasNext())
				{
					courseCode = commandLine.next() ;
					schedule.clearSchedule(courseCode) ;
				}
			} else if (command.equalsIgnoreCase("PSCH")){
				schedule.printSchedule() ;
			}
			System.out.print("\n>");
		}
	}


	private static boolean isStringOnlyAlphabet(String str)
	{
	// write method to check if string str contains only alphabetic characters 
	// if statement to check if str is null, or empty, or matches lower case and uppper case letters
	  	return ((!str.equals("")) &&  (str != null) && (str.matches("^[a-zA-Z]*$"))) ;
	}
  
  public static boolean isNumeric(String str)
  {
	// write method to check if string str contains only numeric characters
	//  used regex to check if str contain numeric values from 0 to 9 
	for (char c : str.toCharArray())
	{
		if (!Character.isDigit(c))
		 	return false ;
	}
	return true ;
  }
  
  
}