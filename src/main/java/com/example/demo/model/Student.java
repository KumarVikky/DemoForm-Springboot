package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private long studentId;
	private String studentName;
	private int studentRollNumber;
	private int studentAge;
	private String studentEmail;
	private String studentAddress;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentName, int studentRollNumber, int studentAge, String studentEmail,
			String studentAddress) {
		super();
		this.studentName = studentName;
		this.studentRollNumber = studentRollNumber;
		this.studentAge = studentAge;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRollNumber="
				+ studentRollNumber + ", studentAge=" + studentAge + ", studentEmail=" + studentEmail
				+ ", studentAddress=" + studentAddress + "]";
	}

}
