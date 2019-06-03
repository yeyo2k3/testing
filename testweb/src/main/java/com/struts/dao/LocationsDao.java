package com.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.struts.entity.Loc_Elements;


public class LocationsDao {
	
	public ArrayList<Loc_Elements> findLocationsList(Connection conn){
		ArrayList<Loc_Elements> lobj=new ArrayList<Loc_Elements>();
		PreparedStatement ps=null;
		 ResultSet rs=null;
		 Loc_Elements obj=null;
		 String sql="SELECT id,name,is_active FROM loc_elements";
		 try {
			 ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 obj=new Loc_Elements();
				 obj.setId(rs.getInt("id"));
				 obj.setName(rs.getString("name"));
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
