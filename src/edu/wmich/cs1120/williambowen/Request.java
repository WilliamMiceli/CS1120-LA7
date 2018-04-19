package edu.wmich.cs1120.williambowen;

public class Request implements Comparable<Request>{
	private String studentName;
	private String studentDept;
	private String studentLevel;
	
	private String courseDept;
	private int courseNumber;
	/**
	 * The constructor
	 * @param studentName The name of the student
	 * @param studentDept The department the student is majoring in
	 * @param studentLevel The seniority of the student
	 * @param courseDept The department of the course requested
	 * @param courseNumber The number of the course requested
	 */
	public Request(String studentName, String studentDept, String studentLevel, String courseDept, int courseNumber) {
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
	}
	/**
	 * Returns number of years to graduation (0 for seniors, 1 for juniors etc.).
	 * This is determined from the student's level - senior, junior, etc.
	 * @return The number of years until graduation
	 */
	public int yearsFromGraduation() {
		switch (this.studentLevel) {
		case "Senior":
			return 0;
		case "Junior":
			return 1;
		case "Sophomore":
			return 2;
		case "Freshman":
			return 3;
		default:
			return -1;
		}
	}
	/**
	 * Compares two requests to determine which has priority.
	 * @return positive for higher priority, negative for lower, zero for same
	 */
	public int compareTo(Request other) {
		if(this.compareDept(other) != 0) {
			return this.compareDept(other);
		}else {
			if(this.yearsFromGraduation() < other.yearsFromGraduation()) {
				return 1;
			}else if(this.yearsFromGraduation() > other.yearsFromGraduation()) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	/**
	 * Used by the compareTo method to see if priority can be determined by department
	 * @param other The other request to compare against
	 * @return positive for higher priority, negative for lower, zero for same
	 */
	private int compareDept(Request other) {
		if(this.studentDept.compareTo(this.courseDept) == 0) {
			if(other.getStudentDept().compareTo(other.getCourseDept()) == 0) {
				return 0;
			}else {
				return 1;
			}
		}else {
			if(other.getStudentDept().compareTo(other.getCourseDept()) == 0){
				return -1;
			}else {
				return 0;
			}
		}
	}
	/**
	 * Getter for the student's name
	 * @return studentName
	 */
	public String getStudentName() {
		return this.studentName;
	}
	/**
	 * Getter for the student's department
	 * @return studentDept
	 */
	public String getStudentDept() {
		return this.studentDept;
	}
	/**
	 * Getter for the student's level
	 * @return studentLevel
	 */
	public String getStudentLevel() {
		return this.studentLevel;
	}
	/**
	 * Getter for the student course request's department
	 * @return courseDept
	 */
	public String getCourseDept() {
		return this.courseDept;
	}
	/**
	 * Getter for the student course request's number
	 * @return courseNumber
	 */
	public int getCourseNumber() {
		return this.courseNumber;
	}
}
