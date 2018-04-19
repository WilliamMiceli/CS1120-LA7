package edu.wmich.cs1120.williambowen;

import java.util.ArrayList;

public class Course implements ICourse {
	private String courseDept;
	private int courseNumber;
	private int capacity;
	private ArrayList<String> students;
	/**
	 * The constructor
	 * @param courseDept The department of the course
	 * @param courseNumber The number of the course
	 * @param capacity The capacity of the course
	 */
	public Course(String courseDept, int courseNumber, int capacity) {
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.capacity = capacity;
	}@Override
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
	/**
	 * Getter for the course department
	 * @return course department
	 */
	public String getCourseDept() {
		return this.courseDept;
	}
	/**
	 * Getter for the course number
	 * @return course number
	 */
	public int getCourseNumber() {
		return this.courseNumber;
	}
	/**
	 * Getter for the course capacity
	 * @return course capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}
}
