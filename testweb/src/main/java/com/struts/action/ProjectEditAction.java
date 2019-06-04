package com.struts.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.control.Control;
import com.struts.entity.Projects;

public class ProjectEditAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String project_id;
	private String project_name;
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String initializeList() {
		project_id= ServletActionContext.getRequest().getParameter("idproject");
		System.out.println(""+project_id);
		Control c=new Control();
		Projects obj=c.getProject(Integer.parseInt(project_id));
		if(obj!=null) {
			project_name=obj.getProject_title();
		}
		return NONE;
	}
	
	public String clear() {
		System.out.println("Salir");
		return SUCCESS;
	}
	
	public String save() {
		System.out.println("Save");
		Control c=new Control();
		Projects obj=c.getProject(Integer.parseInt(project_id));
		if(obj!=null) {
			if(c.updateProject(Integer.parseInt(project_id), project_name)) {
				addActionMessage("Project Edited");
			}
		}
		return SUCCESS;
	}
	
}
