package com.struts.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Locale;

import com.struts.dao.LocationsDao;
import com.struts.dao.ProjectDao;
import com.struts.dao.ProjectLocationsDao;
import com.struts.entity.Loc_Elements;
import com.struts.entity.ProjectLocations;
import com.struts.entity.Projects;

import Util.ConnectionManager;

public class Control {
	Locale loc = Locale.getDefault();
	ConnectionManager connmgr;
	LocationsDao locationsDao;
	ProjectDao projectDao;
	ProjectLocationsDao projectlocDao;

	public Control() {
		initDriver();
		initDao();

	}

	private void initDao() {
		locationsDao = new LocationsDao();
		projectDao = new ProjectDao();
		projectlocDao = new ProjectLocationsDao();
	}

	private void initDriver() {
		String driver = "";
		String host = "";
		String db = "";
		String user = "";
		String password = "";
		loc = new Locale("es", "CO");
		Locale.setDefault(loc);
		try {
			File config = new File("C:\\Testweb\\config\\config.ini");
			FileReader fr = new FileReader(config);
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			if (br.ready()) {
				linea = br.readLine();
			}
			br.close();
			if (linea != null) {
				if (linea.contains(",")) {
					driver = linea.substring(0, linea.indexOf(','));
					linea = linea.substring(linea.indexOf(',') + 1);
					if (linea.contains(",")) {
						host = linea.substring(0, linea.indexOf(','));
						linea = linea.substring(linea.indexOf(',') + 1);
						if (linea.contains(",")) {
							db = linea.substring(0, linea.indexOf(','));
							linea = linea.substring(linea.indexOf(',') + 1);
							if (linea.contains(",")) {
								user = linea.substring(0, linea.indexOf(','));
								linea = linea.substring(linea.indexOf(',') + 1);
								if (linea.contains(",")) {
									password = linea.substring(0, linea.indexOf(','));
								}
							}
						}
					}
				}
			}
			connmgr = new ConnectionManager(driver, host + "/" + db, user, password);
		} catch (Exception e) {

		}

	}

	public ArrayList<Projects> findProjectList() {
		Connection conn = null;
		ArrayList<Projects> lobj = new ArrayList<Projects>();
		try {
			conn = connmgr.getConnection();
			lobj=projectDao.findProjectList(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {

			}
		}
		return lobj;

	}
	
	public ArrayList<Loc_Elements> findLocationsList(){
		Connection conn = null;
		ArrayList<Loc_Elements> lobj = new ArrayList<Loc_Elements>();
		try {
			conn = connmgr.getConnection();
			lobj=locationsDao.findLocationsList(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {

			}
		}
		return lobj;

	}
	
	public ArrayList<ProjectLocations> getAllProjectLocations(){
		Connection conn = null;
		ArrayList<ProjectLocations> lobj=new ArrayList<ProjectLocations>();
		try {
			conn = connmgr.getConnection();
			lobj=projectlocDao.getAllProjectLocations(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {

			}
		}
		return lobj;
	}

}