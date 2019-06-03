package com.struts.entity;



public class Projects {
	
	//project id
	private int id;
	//project name
	private String project_title;
	//active yes or no
	private int active;
	public Projects(int id, String project_title, int active) {
		super();
		this.id = id;
		this.project_title = project_title;
		this.active = active;
	}
	public Projects() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_title() {
		return project_title;
	}
	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
}
