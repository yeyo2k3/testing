package com.struts.entity;

public class ProjectLocations {
	private int id;
	private Projects project;
	private Loc_Elements location;
	private int active;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public Projects getProject() {
		return project;
	}
	public void setProject(Projects project) {
		this.project = project;
	}
	public Loc_Elements getLocation() {
		return location;
	}
	public void setLocation(Loc_Elements location) {
		this.location = location;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public ProjectLocations() {
		super();
	}
	
	
}
