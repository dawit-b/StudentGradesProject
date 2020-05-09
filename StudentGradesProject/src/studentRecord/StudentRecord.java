package studentRecord;

public class StudentRecord {
	String studentID;
	String departmentID;
	int courseNum;
	String courseDate;
	int credits;
	int studentGrade;

	public StudentRecord(String[] record) {
		this.studentID = record[0];
		this.departmentID = record[1];
		this.courseNum = Integer.valueOf(record[2]);
		this.courseDate = record[3];
		this.credits = Integer.valueOf(record[4]);
		this.studentGrade = Integer.valueOf(record[5]);

	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public String getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}

	@Override
	public String toString() {
		return studentID + " " + departmentID + " " + courseNum
				+ " " + courseDate + " " + credits + " " + studentGrade;

	}

}
