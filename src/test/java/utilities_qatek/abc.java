package utilities_qatek;

import command_providers.ElementActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import page_objects.RealApr;

import java.sql.*;

public class abc {

    private static final String User = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String Password = ReadConfigFiles.getPropertyValues("DbPassword");
    private static final String Host = ReadConfigFiles.getPropertyValues("DbHost");
    private static final String Port = ReadConfigFiles.getPropertyValues("DbPort");
    private static final String DBName = ReadConfigFiles.getPropertyValues("DbName");

    private static final Logger LOGGER = LogManager.getLogger(abc.class);

    private static final String ConnectionUrl = "jdbc:postgresql://" + Host + ":" + Port + "/" + DBName;

    private static Connection connect() throws Exception{
        Connection conn;
        try{
            conn = DriverManager.getConnection(ConnectionUrl, User, Password);
            if(conn != null){
                LOGGER.debug("Database connection is successful!");
            }
        } catch(SQLException e){
            throw new Exception(e.getMessage());
        }
        return conn;
    }

    public static ResultSet readData(String sql) throws Exception{
        ResultSet rs;
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch(SQLException e){
            throw new Exception(e.getMessage());
        }
        return rs;
    }




}
