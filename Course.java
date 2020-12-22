// Harrison Arranz - Hurtado
// 500518860
public class Course implements Comparable<Course>
{
	private final String code;
	private final String name;
	private final String description;
	private final String format;
	public Object getCode;
	   
	public Course()
	{
	  this.code        = "";
	  this.name        = "";
	  this.description = "";
	  this.format      = "";
	}
	   
	public Course(final String name, final String code, final String descr, final String fmt)
	{
	  this.code        = code;
	  this.name        = name;
	  this.description = descr;
	  this.format      = fmt;
	}
	   
	public String getCode()
	{
	   return code;
	}
	   
	public String getName()
	{
	  return name;
	}
	   
	public String getFormat()
	{
	  return format;
	}
	   
	public String getDescription()
	{
	  return code + " - " + name + "\n" + description + "\n" + format;
	}
	
	 public String getInfo()
	 {
	   return code + " - " + name;
	 }

	 public int compareTo(Course other)
	 {
		 return this.code.compareTo(other.code) ;
	 }
	 
	 // static method to convert numeric score to letter grade string 
	 // e.g. 91 --> "A+"
	 public static String convertNumericGrade(final double score)
	 {
		// converts score into letter grades
		//  using the Ryerson Standard letter grading
		 if (score >= 90 || score <= 100) {return "A+" ;}
		 else if (score >= 85 || score <= 89) {return "A" ;}
		 else if (score >= 80 || score <= 84) {return "A-" ;}
		 else if (score >= 77 || score <= 79) {return "B+" ;}
		 else if (score >= 73 || score <= 76) {return "B" ;}
		 else if (score >= 70 || score <= 72) {return "B-" ;}
		 else if (score >= 67 || score <= 69) {return "C+" ;}
		 else if (score >= 63 || score <= 66) {return "C" ;}
		 else if (score >= 60 || score <= 62) {return "C-" ;}
		 else if (score >= 57 || score <= 59) {return "D+" ;}
		 else if (score >= 53 || score <= 56) {return "D" ;}
		 else if (score >= 50 || score <= 52) {return "D-" ;}
		 else {
			return "F" ; 
		 }
	 }
	 
}
