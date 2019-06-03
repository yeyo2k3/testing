package com.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.struts.entity.Loc_Element_Types;
import com.struts.entity.Loc_Elements;
import com.struts.entity.ProjectLocations;
import com.struts.entity.Projects;

public class ProjectLocationsDao {
	//CRUD method for relationship with projects and Locations 	
	public ProjectLocations getProjectLocation(int id, Connection conn) {
		ProjectLocations obj=null;
		String sql="SELECT * FROM project_locations WHERE id=?";
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(rs.next()) {
				obj=new ProjectLocations();
				obj.setId(id);
				obj.setProject(new Projects(rs.getInt("project_id"),null,0));
				obj.setLocation(new Loc_Elements(rs.getInt("loc_element_id"), null));
				obj.setActive(rs.getInt("is_active"));
			}
		} catch (Exception e) {
			
		}finally {
			
		}
		return obj;
	}
	public boolean saveProjectLocation(int projectid, int locationid,int active, Connection conn) {
		boolean complete=true;
		String sql="INSERT INTO project_locations (project_id,loc_element_id,is_active) VALUES (?,?,?)";
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,projectid);
			ps.setInt(2, locationid);
			ps.setInt(3,active );
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			complete=false;
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			} catch (Exception e2) {
				
			}
		}
		return complete;
	}
	
	public boolean deleteProjectLocation(int id,Connection conn) {
		boolean complete=true;
		String sql="DELETE FROM project_locations WHERE id=?";
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);			
			ps.executeUpdate();
			
		} catch (Exception e) {
			complete=false;
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			} catch (Exception e2) {
				
			}
		}
		return complete;
	}
	
	public boolean updateProjectLocation(int id,int active,Connection conn) {
		boolean complete=true;
		String sql="UPDATE project_locations SET is_active=? WHERE id=?";
		PreparedStatement ps=null;	
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);			
			ps.setInt(1, active);
			ps.setInt(2,id);
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			complete=false;
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			} catch (Exception e2) {
				
			}
		}
		return complete;
	}
	
	public ArrayList<ProjectLocations> getAllProjectLocations(Connection conn){
		ArrayList<ProjectLocations> lobj=new ArrayList<>();
		PreparedStatement ps=null;	
		ResultSet rs=null;
		String sql="SELECT project_locations.*,project_title,loc_elements.name,loc_element_types.id as idtype,loc_element_types.name as nametype FROM project_locations "
				+ "INNER JOIN projects ON projects.id=project_locations.project_id "
				+ "INNER JOIN loc_elements ON loc_elements.id=project_locations.loc_element_id "
				+ "INNER JOIN loc_element_types ON loc_element_types.id=loc_elements.element_type_id order by id desc";
		ProjectLocations obj=null;
		try {
			ps=conn.prepareStatement(sql);			
			rs=ps.executeQuery();
			while(rs.next()) {
				obj=new ProjectLocations();
				obj.setId(rs.getInt("id"));
				obj.setProject(new Projects(rs.getInt("project_id"),rs.getString("project_title"),0));
				obj.setLocation(new Loc_Elements(rs.getInt("loc_element_id"), rs.getString("name"),new Loc_Element_Types(rs.getInt("idtype"), rs.getString("nametype"))));
				obj.setActive(rs.getInt("is_active"));
			
				lobj.add(obj);
			}
		} catch (Exception e) {
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			} catch (Exception e2) {
				
			}
		}
		return lobj;
	}
}
