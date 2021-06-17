package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERDATA")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",columnDefinition = "serial")
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "USERNAME",unique = true, nullable = false)
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PHONE",columnDefinition = "varchar(15)")
	private int phone;
	@Column(name = "AGE")
	private int age;
	@Column(name = "SECRET_QUESTION")
	private String secretQuestion;
	@Column(name = "SECRET_ANSWER")
	private String secretAnswer;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String userName, String password, int phone, int age, String secretQuestion,
			String secretAnswer) {
		super();
		this.name = name;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.age = age;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", phone=" + phone + ", age=" + age + ", secretQuestion=" + secretQuestion
				+ ", secretAnswer=" + secretAnswer + "]";
	}
}

