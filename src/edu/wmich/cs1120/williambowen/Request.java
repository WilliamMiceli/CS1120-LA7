package edu.wmich.cs1120.williambowen;

public class Request implements Comparable<Request>{
	private String studentName;
	private String studentDept;
	private String studentLevel;
	
	private String courseDept;
	private int courseNumber;
	
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
	 * @return
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
	 * 
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
	 * 
	 * @param other
	 * @return
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
	 * 
	 * @return
	 */
	public String getStudentName() {
		return this.studentName;
	}
	/**
	 * 
	 * @return
	 */
	public String getStudentDept() {
		return this.studentDept;
	}
	/**
	 * 
	 * @return
	 */
	public String getStudentLevel() {
		return this.studentLevel;
	}
	/**
	 * 
	 * @return
	 */
	public String getCourseDept() {
		return this.courseDept;
	}
	/**
	 * 
	 * @return
	 */
	public int getCourseNumber() {
		return this.courseNumber;
	}
}
