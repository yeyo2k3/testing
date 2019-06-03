package com.struts.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.control.Control;
import com.struts.entity.Loc_Elements;
import com.struts.entity.ProjectLocations;
import com.struts.entity.Projects;
import com.struts.model.LocationsModel;
import com.struts.model.ProjectModel;

//action class for controls of jsp page extends action support for struts2 use
public class ProjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// variable for project list to show
	private List<Projects> listofProjects;
	// model for fill project list.
	private ProjectModel modProject = new ProjectModel();
	// atribute to store value of project list
	private String selectedProject;
	// variable for locations list to show
	private List<Loc_Elements> listofLocations;
	// model for fill location list.
	private LocationsModel modLocation = new LocationsModel();
	// atribute to store value of location list
	private String selectedLocation;
	// list of project location to show always on page
	private ArrayList<ProjectLocations> projectLocationList;
	// atribute to store value of active or no active
	private String selectedActive;
	private String locationvalue;
	private String projectvalue;
	private String activevalue;

	// get setter and getter from atributes
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

	public String getSelectedActive() {
		return selectedActive;
	}

	public void setSelectedActive(String selectedActive) {
		this.selectedActive = selectedActive;
	}

	public String getLocationvalue() {
		return locationvalue;
	}

	public void setLocationvalue(String locationvalue) {
		this.locationvalue = locationvalue;
	}
	
	

	public String getProjectvalue() {
		return projectvalue;
	}

	public void setProjectvalue(String projectvalue) {
		this.projectvalue = projectvalue;
	}

	public String getActivevalue() {
		return activevalue;
	}

	public void setActivevalue(String activevalue) {
		this.activevalue = activevalue;
	}

	public String execute() {

		return SUCCESS;
	}

	// method to fill projectlist on load page
	public String initializeList() {
		// System.out.println("inicializa");
		Control c = new Control();
		projectLocationList = (c.getAllProjectLocations());
		// System.out.println("Size " + projectLocationList.size());
		return NONE;
	}

	public void prepare() {

	}

	// method to save project location selected of no select ones do not save
	// anything
	public String save() {
		Control c = new Control();
		if (!selectedProject.equals("-1") && !selectedProject.equals("-1")) {
			boolean execute = c.saveProjectLocation(selectedProject, selectedLocation, selectedActive);
		}
		// when save works , list all projectlocation again to refresh.
		projectLocationList = (c.getAllProjectLocations());

		return SUCCESS;
	}

	// method to delete a value of projectlocation
	public String delete() {
		System.out.println("delete");
		String paramValue = ServletActionContext.getRequest().getParameter("idvalue");
		System.out.println("value " + paramValue);
		Control c = new Control();
		// if parameter dont have anything do not delete
		if (paramValue.length() > 0) {
			// find project location before delete.
			if (c.findProjectLocations(Integer.parseInt(paramValue)) != null) {
				if (c.deleteProjectLocation(Integer.parseInt(paramValue))) {

				}
			}
		}
		projectLocationList = (c.getAllProjectLocations());
		return SUCCESS;
	}

	public String clear() {
		locationvalue = "-1";
		this.listofProjects = modProject.getProjects();
		return SUCCESS;
	}

}
