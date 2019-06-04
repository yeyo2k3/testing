package com.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.struts.entity.Projects;

//class to controls project list on database
public class ProjectDao {
	public ArrayList<Projects> findProjectList(Connection conn) {
		ArrayList<Projects> lobj = new ArrayList<Projects>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Projects obj = null;
		String sql = "SELECT id,project_title,is_active FROM projects";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				obj = new Projects(rs.getInt("id"), rs.getString("project_title"), rs.getInt("is_active"));
				lobj.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e2) {

			}
		}
		return lobj;
	}

	public Projects getProject(int id, Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Projects obj = null;
		String sql = "SELECT id,project_title,is_active FROM projects WHERE ID=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				obj = new Projects(rs.getInt("id"), rs.getString("project_title"), rs.getInt("is_active"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e2) {

			}
		}
		return obj;
	}
	
	public boolean updateProject(int id, String title,Connection conn) {
		boolean execute=true;
		String sql="update projects set project_title=? where id=?";
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			execute=false;
		}finally {
			try {
			
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e2) {

			}
		}
		return execute;
	}
}
