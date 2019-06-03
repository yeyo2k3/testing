package com.struts.model;

import java.util.ArrayList;
import java.util.List;

import com.struts.control.Control;
import com.struts.entity.Loc_Elements;

public class LocationsModel {
	private List<Loc_Elements> locations=new ArrayList<Loc_Elements>();

	
	
	public List<Loc_Elements> getLocations() {
		return locations;
	}



	public void setLocations(List<Loc_Elements> locations) {
		this.locations = locations;
	}



	public List<Loc_Elements> getlLocations(){
		Control c=new Control();
		locations=c.findLocationsList();
		return this.locations;
	}
}
