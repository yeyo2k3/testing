package com.struts.entity;

public class Loc_Element_Types {
	private int id;
	private String name;
	private int active;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Loc_Element_Types(int id, String name, int active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}
	public Loc_Element_Types() {
		super();
	}
	
	
}
