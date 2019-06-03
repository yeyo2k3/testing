package com.struts.model;

import java.util.ArrayList;
import java.util.List;

import com.struts.control.Control;
import com.struts.entity.Projects;

public class ProjectModel {
	private List<Projects> lProjects=new ArrayList<Projects>();

	public List<Projects> getlProjects() {
		return lProjects;
	}

	public void setlProjects(List<Projects> lProjects) {
		this.lProjects = lProjects;
	}
	
	public List<Projects> getProjects(){		
		Control c=new Control();
		lProjects=c.findProjectList();
		return this.lProjects;
	}
}
