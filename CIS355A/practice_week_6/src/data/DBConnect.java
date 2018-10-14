package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 * @author Tevis Boulware
 * @version 1.0
 * <p><b>Class Description</b></p>
 * <p>
 * This class contains the inner objects load drivers to an MySQL database, 
 * set the connection, and manage the database connection.
 * </p>
 * <p>
 * Note that this object will store the user credentials in this object and transmit them
 * to the database in an unsecure manner. <span style="font-weight:bold; font-style:italic; color:red;">This is an unsecure technique and should only be use for "educational" purposes!</span>
 * In addition, the exception handling can be made more robust and do more than just print out log messages.
 * </p>
 */

public class DBConnect {
    
    /**
     * SQL Connection object
     */
    private Connection connection = null;
    /**
     * string, which is the URL to the database with no user credentials
     */
    private String strCon;
    /**
     * Registered using name of the database
     */
    private String userName;
    /**
     * Password of the registered user <span style="font-weight:bold; font-style:italic; color:red;">this is an unsecure technique and should only be use for "educational" purposes!</span>.
     */
    private String password;
    private boolean connected = false;
    public static int openConnections = 0;
    
    /**
     * Accepts the connection string (with no user credentials).
     * @param strCon string, which is the URL to the database
     */
    public DBConnect(String strCon) {
        setConnectionString(strCon);
    }
    public DBConnect(String strCon, String userName, String password) {
        setConnectionString(strCon);
        setUserName(userName);
        setPassword(password);
        setConnection();
    }
    /**
     * Sets the database user name
     * @param userName string containing the registered user name. this is not a secure method
     * and should only be used in "educational" programs.
     */
    public void setUserName(String userName) throws IllegalArgumentException {
        if(userName != null && !userName.trim().isEmpty()) {
                this.userName = userName;
        }
        else {
            this.userName = "";
            throw new IllegalArgumentException("username cannot be empty");
        }
    }
    /**
     * Sets the registered users password, this is not a secure method
     * and should only be used in "educational" programs.
     * @param password string containing the registered users password.
     */
    public void setPassword(String password) throws IllegalArgumentException {
        if(password != null && !password.trim().isEmpty()) {
                this.password = password;
        }
        else {
            this.password = "";
            throw new IllegalArgumentException("password cannot be empty");
        }
    }
    /**
     * Validates the connect string is not empty, and then sets the string.
     * @param strCon string, which is the URL to the database
     */
    public final void setConnectionString(String strCon) throws IllegalArgumentException {
        if(strCon != null && !strCon.trim().isEmpty()) {
                this.strCon = strCon;
        }
        else {
            this.strCon = "";
            throw new IllegalArgumentException("connection string cannot be empty");
        }
    }
    /**
     * @return the connection object.
     */
    public Connection getConnection() {
            return connection;
    }
    /**
     * @return boolean value representing if the database connection to database is established and valid.
     */
    public boolean isConnected() {
        return connected;
    }
    /**
     * Loads the MySQL drives, and if successful will attempt to make a connection
     * to the database with the given connection string, username and password.
     * @param conStr the URL to the database
     * @param userName string containing the registered user name. this is not a secure method
     * @param password string containing the registered users password.
     * @return boolean where true = drivers where loaded and connection was successful and user validated, false = means either the drives where not loaded or the connection to the database failed.
     * @exception ClassNotFoundException occurs when the drivers are not loaded correctly, typically caused by the my-sql-connector.jar (or other jar) not being added to project library
     * @exception SQLException caused by a bad connection URL or the user is not validated.
     * @exception Exception general catch all exception
     */
    private void setConnection() {
        boolean valid = false;
        connected = false;
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                valid = true;
            }
            catch (ClassNotFoundException e) {
                String prompt = "\nDatabase Helpers setConnection: cannot find database drivers\n";
                System.out.print("\n" + prompt);
                valid = false;
            }
            if(valid)
            {
                try {
                        connection = DriverManager.getConnection(strCon, userName, password);
                        String prompt = "\nDatabase Helpers, Connected to OmnyBus\n";
                        System.out.print("\n" + prompt);
                        connected = true;
                }
                catch (SQLException e) {
                        String prompt = "\nDatabase Helpers setConnection: Cannot connect to database server\n";
                        System.out.print("\n" + prompt);
                        valid = false;
                }
                catch (Exception e) {
                        String prompt = "\nDatabase Helpers setConnection: Cannot connect to database server\n";
                        System.out.print("\n" + prompt);
                        valid = false;
                }
            }
        }
    }
    /**
     * Closes the database connection object.
     * @throws SQLException if the connection object is corrupt or null.
     */
    public void closeConnection() throws SQLException {
        try {
            if ((connection != null) && (!connection.isClosed())) {
                connection.close();
                connection = null;
            }
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

}
