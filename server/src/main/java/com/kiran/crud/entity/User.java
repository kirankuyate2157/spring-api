package com.kiran.crud.entity;


import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User  {

	private String id;
	private String name;
	private SubjectMarks subjectMarks;
	
	public User() {
        this.id = UUID.randomUUID().toString().toString().substring(0, 6);
        this.setSubjectMarks(new SubjectMarks());
    }
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public SubjectMarks getSubjectMarks() {
		return subjectMarks;
	}

	public void setSubjectMarks(SubjectMarks subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

}
