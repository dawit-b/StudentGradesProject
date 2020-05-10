package studentRecord;

public class StudentGPA {
	String studentID;
	double gpa;
	public StudentGPA( String studentID, double gpa){
		this.studentID = studentID;
		this.gpa = gpa;
		
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
}
