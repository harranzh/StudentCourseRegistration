import java.util.ArrayList;

public class Scheduler 
{
	private ArrayList<ActiveCourse> courses ;
	// Scheduler constructor 
	public Scheduler() {}

	ArrayList<Student> students;
	
	// TreeMap<String,ActiveCourse> schedule;
		
	public Scheduler(ArrayList<ActiveCourse> courses)
	{
	  	courses = new ArrayList<ActiveCourse>();
	}
	

	public void setDayAndTime(String courseCode, String day, int startTime, int duration)
	{
		// Checking for correct courseCode
		if(!isCourseValid(courseCode))
			throw new myExceptions("Unknown Course Code " + courseCode) ;
		
		// Checking for correct date
		if(!isValidDay(day))
			throw new myExceptions("Invalid Lecture Day") ;
		
		// Checking for time
		if(!validTime(startTime))
			throw new myExceptions("Time Lecture Start time") ;
			
		// Checking for correct duration
		if(!validDuration(duration))
			throw new myExceptions("Invalid lecture Duration.") ;
			
		// Checking for time conflict in schedule
		if(!scheduleMixup(day, startTime, duration))
			throw new myExceptions("There is an overlap in the courses selected.") ;
			
		// if all checks go through, set day, start, and duration parameters
		for (ActiveCourse course : courses){
			if(course.getCode().equalsIgnoreCase(courseCode)){
				course.lectureDay(day) ;
				course.lectureDuration(duration);
				course.lectureStart(startTime);
			}
		}
	}

	public void clearSchedule(String courseCode)
	{
		// Compare course codes in arraylist courses with the course code provided
		// if they are equal, set Date Start Duration to default 
		for(int i = 0; 1 < courses.size(); i++){
			if(courses.get(i).getCode().equalsIgnoreCase(courseCode)){
				courses.get(i).setDate();
				courses.get(i).setStart();
				courses.get(i).setDuration();
			}
			else{
				continue ;
			}
		}
	}
		
	public void printSchedule()
	{
		// see assignment doc
		String [] col = { " ", "Mon", "Tue", "Wed", "Thu", "Fri" } ;
		String [] row = {" ", "0800", "0900", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700"} ;
		
		for(String i : col)
            System.out.print(i + "          ") ;
        for (String j : row)
            System.out.println(j + " \n\n") ;
		
	}

    private boolean isCourseValid(String courseCode)
    {
        // Check for correct courseCode
		for (int i = 0; i < courses.size(); i++)
			if(!courses.get(i).getCode().equalsIgnoreCase(courseCode))	
			{
				return true ;
			}
		return false ;
    }

    private boolean isValidDay(String day)
    {
		// check if day given is between Mon - Fri
		String[] days_of_week = {"Mon","Tue","Wed","Thu","Fri"};
		for (String date : days_of_week){
			if (date.equalsIgnoreCase(day))
				return true;
		}
		return false; 
    }

    private boolean validTime(Integer startTime)
    {
        if(startTime < 800 && startTime > 1700)
            return true ;
        return false ;
    }

    private boolean validDuration(Integer duration)
    {
        if (duration < 1 || duration > 3)
            return true ;
        return false ;
    }

    private boolean scheduleMixup(String day, Integer startTime, Integer duration)
    {
		// // these three parameters do not overlap with other scheduled course. 
		// for (ActiveCourse course : courses) {
		// 	if (course.lectureDay(day))
		// 		return true ; 
		// }
		return false ;
    }

	
}
