package com.struts.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.Parameter.Request;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.control.Control;
import com.struts.entity.Loc_Elements;
import com.struts.entity.ProjectLocations;
import com.struts.entity.Projects;
import com.struts.model.LocationsModel;
import com.struts.model.ProjectModel;

public class ProjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Projects> listofProjects;
	private ProjectModel modProject = new ProjectModel();
	private String selectedProject;
	private List<Loc_Elements> listofLocations;
	private LocationsModel modLocation = new LocationsModel();
	private String selectedLocation;
	private ArrayList<ProjectLocations> projectLocationList;

	public List<Projects> getListofProjects() {
		this.listofProjects = modProject.getProjects();
		return listofProjects;
	}

	public void setListofProjects(List<Projects> listofProjects) {
		this.listofProjects = listofProjects;
	}

	public List<Loc_Elements> getListofLocations() {
		this.listofLocations = modLocation.getlLocations();
		return listofLocations;
	}

	public void setListofLocations(List<Loc_Elements> listofLocations) {

		this.listofLocations = listofLocations;
	}

	public String getSelectedLocation() {

		return selectedLocation;
	}

	public void setSelectedLocation(String selectedLocation) {
		this.selectedLocation = selectedLocation;
	}

	public ProjectAction() {
		super();

	}

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public ArrayList<ProjectLocations> getProjectLocationList() {
		return projectLocationList;
	}

	public void setProjectLocationList(ArrayList<ProjectLocations> projectLocationList) {
		this.projectLocationList = projectLocationList;
	}
	
	

	
	
	public String submit() throws Exception {
	    // submit button logic here
	    return SUCCESS;
	}
	 
	public String clear() throws Exception {
	    // clear button logic here
	    return SUCCESS;
	}

	public String execute() {
		
		return SUCCESS;
	}

	public String initializeList() {
		System.out.println("inicializa");
		Control c = new Control();
		projectLocationList = (c.getAllProjectLocations());
		System.out.println("Size " + projectLocationList.size());
		return NONE;
	}

	public void prepare() {

	}

	public String save() {
		Control c = new Control();
		
		System.out.println("selectedLocation " + selectedLocation);
		System.out.println("selectedProject " + selectedProject);
		if(!selectedProject.equals("-1") && !selectedProject.equals("-1")) {
			boolean execute=c.saveProjectLocation(selectedProject, selectedLocation, "1");
		}
		
		projectLocationList = (c.getAllProjectLocations());
				
		return SUCCESS;
	}

	public String delete() {
		System.out.println("delete");
		
		Control c = new Control();
		projectLocationList = (c.getAllProjectLocations());
		return SUCCESS;
	}

}
