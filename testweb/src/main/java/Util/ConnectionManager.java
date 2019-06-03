package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	 //variable contains driver to conect a database.
    private String driver;
    //Host and BD url.
    private String url;
    //user database
    private String login;
    //password database
    private String password;
    
    /** Creates a new instance of ConnectionManager */
    public ConnectionManager(String driver, String url, String login, String password) throws Exception
    {
        this.driver = driver;
        this.url = url;
        this.login = login;
        this.password = password;
        //System.out.println(""+url+"?user="+login+"&password="+password);
        try
        {
            Class.forName(this.driver).newInstance();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new Exception("This class " + this.driver + " cannot be find");
        }
    }
    
   
    public Connection getConnection() throws Exception
    {
        try
        {
            return DriverManager.getConnection(url,login,password);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new Exception("Cannot find connection with this parameters url:"+url);
        }
    }
    
}
