package edu.wmich.cs1120.williambowen;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements IController {
	private PriorityQueue<Request> requestQueue;
	private ArrayList<Course> courses;
	private BufferedReader fileIn;
	private BufferedReader fileIn1;
	
	public Controller (PriorityQueue<Request> requestQueue, ArrayList<Course> courses, BufferedReader fileIn, BufferedReader fileIn1) {
		this.requestQueue = requestQueue;
		this.courses = courses;
		this.fileIn = fileIn;
		this.fileIn1 = fileIn1;
	}
	
	@Override
	public void readCourseFile() {
		String inputLine;
		String[] input;
		for(int i = 0; i < 2; ++i) { // Skips the first two lines of the text file
			try {
				fileIn.readLine();
			} catch (IOException e) {
				System.out.println("Course File Read Error");
			}
		}
		while(true) {
			try {
				inputLine = fileIn.readLine();
				if(inputLine == null) {
					break;
				}
				System.out.println(inputLine);
				input = inputLine.split(",");
				courses.add(new Course(input[0],Integer.parseInt(input[1]),Integer.parseInt(input[2])));
			} catch (IOException e) { // End of file reached
				break;
			}
		}
	}
	@Override
	public void readRequestFile() {
		String inputLine;
		String[] input;
		try { // Skips the first line of the text file
			fileIn1.readLine();
		} catch (IOException e) {
			System.out.println("Request File Read Error");
		}
		while(true) {
			try {
				inputLine = fileIn1.readLine();
				if(inputLine == null) {
					break;
				}
				input = inputLine.split(",");
				addRequest(new Request(input[0],input[2],input[1],input[3],Integer.parseInt(input[4])));
			} catch (IOException e) { // End of file reached
				break;
			}
		}
	}
	@Override
	public void addRequest(Request req) {
		requestQueue.enqueue(req);
	}
	@Override
	public void processRequests() {
		Request currentRequest;
		Course requestedCourse;
		
		while(!requestQueue.isEmpty()) {
			currentRequest = requestQueue.dequeue();
			requestedCourse = getCourse(currentRequest.getCourseDept(), currentRequest.getCourseNumber());
			
			System.out.println("Request processed");
			if(requestedCourse.isFull()) {
				System.out.println(currentRequest.getStudentName() + " cannot register for " + currentRequest.getCourseDept() + " " + currentRequest.getCourseNumber());
			} else {
				requestedCourse.addStudent(currentRequest.getStudentName());
				System.out.println(currentRequest.getStudentName() + " successfully registered " + currentRequest.getCourseDept() + " " + currentRequest.getCourseNumber());
			}
		}
	}
	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		for(int i = 0; i < courses.size(); ++i) {
			if(this.courses.get(i).getCourseDept().compareTo(courseDept) == 0 && this.courses.get(i).getCourseNumber() == courseNumber) {
				return this.courses.get(i);
			}
		}
		return null;
	}
	@Override
	public void printClassList() {
		for(int i = 0; i < this.courses.size(); ++i) {
			this.courses.get(i).printClassList();
			System.out.println();
		}
	}
}
