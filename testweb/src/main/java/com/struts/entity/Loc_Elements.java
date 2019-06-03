package com.struts.entity;

public class Loc_Elements {
	//location id
	private int id;
	//location name
	private String name;
	//location shortname
	private String alphaname;
	//objet to identify location type (country, province, etc)
	private Loc_Element_Types loc_element_type;
	//country id
	private String country;
	//active yes or no
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
	public String getAlphaname() {
		return alphaname;
	}
	public void setAlphaname(String alphaname) {
		this.alphaname = alphaname;
	}
	public Loc_Element_Types getLoc_element_type() {
		return loc_element_type;
	}
	public void setLoc_element_type(Loc_Element_Types loc_element_type) {
		this.loc_element_type = loc_element_type;
	}
	public String getCountry() {
		return country;
	}
	public void seCountry(String country) {
		this.country = country;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Loc_Elements(int id, String name, String alphaname, Loc_Element_Types loc_element_type, String country,
			int active) {
		super();
		this.id = id;
		this.name = name;
		this.alphaname = alphaname;
		this.loc_element_type = loc_element_type;
		this.country = country;
		this.active = active;
	}
	public Loc_Elements() {
		super();
	}
	public Loc_Elements(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Loc_Elements(int id, String name, Loc_Element_Types loc_element_type) {
		super();
		this.id = id;
		this.name = name;
		this.loc_element_type = loc_element_type;
	}
	
	
	
	
	
}
