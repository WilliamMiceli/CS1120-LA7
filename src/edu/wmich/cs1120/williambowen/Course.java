package edu.wmich.cs1120.williambowen;

import java.util.ArrayList;

public class Course implements ICourse {
	private String courseDept;
	private int courseNumber;
	private int capacity;
	private ArrayList<String> students;
	
	public Course(String courseDept, int courseNumber, int capacity) {
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.capacity = capacity;
	}
	
	@Override
	public boolean isFull() {
		return (students.size() >= capacity);
	}
	@Override
	public void addStudent(String name) {
		students.add(name);
	}
	@Override
	public void printClassList() {
		System.out.println("Class List for " + courseDept + " " + courseNumber);
		for(int i = 0; i < students.size(); ++i) {
			System.out.println(students.get(i));
		}
	}
	public String getCourseDept() {
		return this.courseDept;
	}
	public int getCourseNumber() {
		return this.courseNumber;
	}
	public int getCapacity() {
		return this.capacity;
	}
}
