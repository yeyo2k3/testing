package com.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.struts.entity.Projects;

public class ProjectDao {
	public ArrayList<Projects>findProjectList(Connection conn){
		 ArrayList<Projects> lobj=new ArrayList<Projects>();
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 Projects obj=null;
		 String sql="SELECT id,project_title,is_active FROM projects";
		 try {
			 ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 obj=new Projects(rs.getInt("id"), rs.getString("project_title"), rs.getInt("is_active"));
				 lobj.add(obj);
			 }
		} catch (Exception e) {
			e.printStackTrace();
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
