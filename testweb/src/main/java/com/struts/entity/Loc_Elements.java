package com.struts.entity;

public class Loc_Elements {
	private int id;
	private String name;
	private String alphaname;
	private Loc_Element_Types loc_element_type;
	private String pais;
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Loc_Elements(int id, String name, String alphaname, Loc_Element_Types loc_element_type, String pais,
			int active) {
		super();
		this.id = id;
		this.name = name;
		this.alphaname = alphaname;
		this.loc_element_type = loc_element_type;
		this.pais = pais;
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
	
	
	
	
}
