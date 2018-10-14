 package data;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import business.*;
import javax.swing.JOptionPane;

public class DataIO {
   private final String CONNECTION_STRING = "jdbc:mysql://devry.edupe.net:4300/CIS355A_Kovtun";  //TODO: put in your user name
    private final String ORDER_TABLE = "PizzaOrder";
    private final String USER_NAME = "4017";  //TODO: put in your user name
    private final String PASSWORD = "76HKcUIAfG";  //TODO: put in your password
    
    private final DBConnect dbConnect;
    
    public DataIO()  {
        dbConnect = new DBConnect(CONNECTION_STRING, USER_NAME, PASSWORD);
    }
    public boolean add(PizzaOrder aOrder) {
        boolean success = false;
        PreparedStatement statement;
	StringBuilder sqlStr = new StringBuilder();
	int rowCount;
        
        if (aOrder != null && dbConnect != null && dbConnect.isConnected()) {
            try {
                sqlStr.append("INSERT INTO ");
                sqlStr.append(ORDER_TABLE);
                sqlStr.append(" (firstName, lastName, size, cheese, sausage, ham, total)");
                sqlStr.append(" VALUES (?,?,?,?,?,?,?)");
                
                statement = dbConnect.getConnection().prepareStatement(sqlStr.toString(), Statement.RETURN_GENERATED_KEYS);
               //TODO:  add the code to insert a pizza order into the database
               
                statement.setString(1, aOrder.getFirstName());
                statement.setString(2, aOrder.getLastName());
                statement.setString(3, aOrder.getPizzaSize());
                statement.setBoolean(4, aOrder.getCheese());
                statement.setBoolean(5, aOrder.getSausage());
                statement.setBoolean(6, aOrder.getHam());
                statement.setDouble(7, aOrder.getTotal());

                rowCount = statement.executeUpdate();
                if (rowCount == 1) {
                    ResultSet rs = statement.getGeneratedKeys();
                    if(rs.next()) {
                        aOrder.setId(rs.getInt(1));
                    }
                    success = true;
                }
            }
            catch  (SQLException e) {
                String prompt = e.getMessage() 
                            + " cannot save pizza order information for " 
                            + aOrder.getFullName();
                JOptionPane.showMessageDialog(null, prompt, "SQL Server Error: Insert", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (aOrder == null) {
            throw new NullPointerException("Pizza Order object is null");
        }
        else {
            throw new IllegalStateException("Database is not connected");
            
        }
        return success;
    }
    public boolean delete(PizzaOrder aOrder) {
        boolean success = false;
        PreparedStatement statement = null;
	StringBuilder sqlStr = new StringBuilder();
	int rowCount;
        
        if(aOrder != null && dbConnect != null && dbConnect.isConnected()){
            try {
                //TODO:  create the SQL statement to delete a record from the database with a given id
                sqlStr.append("DELETE FROM " + ORDER_TABLE + " WHERE id = ?");
                               
                statement = dbConnect.getConnection().prepareStatement(sqlStr.toString());
                statement.setInt(1, aOrder.getId());
                rowCount = statement.executeUpdate();
                if (rowCount == 1) {
                    success = true;
                }
            }
            catch  (SQLException e) {
                String prompt = e.getMessage() 
                                + " cannot delete pizza order information for " 
                                + aOrder.getFullName();
                JOptionPane.showMessageDialog(null, prompt, "SQL Server Error: Delete", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (aOrder == null) {
            throw new NullPointerException("Pizza Order object is null");
        }
        else {
            throw new IllegalStateException("Database is not connected");
            
        }
        return success;
    }
    public boolean update(PizzaOrder aOrder)  {
        boolean success = false;
        PreparedStatement statement = null;
	StringBuilder sqlStr = new StringBuilder();
	int rowCount;
        
        if(aOrder != null && dbConnect != null && dbConnect.isConnected()) {
            try {
                //TODO create the SQL and prepared statements to update an order in the database
                sqlStr.append("UPDATE ");
                sqlStr.append(ORDER_TABLE);
                sqlStr.append(" SET total = ?");
                sqlStr.append(" WHERE id = ?");

                statement = dbConnect.getConnection().prepareStatement(sqlStr.toString());
                statement.setDouble(1, aOrder.getTotal());
                statement.setInt(2, aOrder.getId());
                
                rowCount = statement.executeUpdate();
            }
            catch  (SQLException e) {
                String prompt = e.getMessage() 
                                + " cannot update pizza order information for " 
                                + aOrder.getFullName();
                JOptionPane.showMessageDialog(null, prompt, "SQL Server Error: Update", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (aOrder == null) {
            throw new NullPointerException("Pizza Order object is null");
        }
        else {
            throw new IllegalStateException("Database is not connected");
            
        }
        return success;
    }
    public ArrayList<PizzaOrder> getList() {
        ArrayList<PizzaOrder> list = new ArrayList<>();
        String sqlStr = "Select * from " + ORDER_TABLE;
        Statement statement;
        ResultSet rs;
        int id;
        PizzaOrder aOrder;
        
        try {
            statement = (Statement) dbConnect.getConnection().createStatement();
            rs = statement.executeQuery(sqlStr);
            while (rs.next()) {
                aOrder = new PizzaOrder();
                aOrder.setId(rs.getInt(1));
                aOrder.setFirstName(rs.getString(2));
                aOrder.setLastName(rs.getString(3));
                //TODO create the code to:
                //1. set the pizza size
                //2. set the cheese selection
                //3. set the sausage selection
                //4. set the ham selection
                //5. set the total
                //6. add the order to the array list
                aOrder.setPizzaSize(rs.getString(4));
                aOrder.setCheese(rs.getBoolean(5));
                aOrder.setSausage(rs.getBoolean(6));
                aOrder.setHam(rs.getBoolean(7));
                aOrder.setTotal(rs.getDouble(8));
                
                list.add(aOrder);
            }
        }
        catch (SQLException ex) {
             String prompt = ex.getMessage() 
                                + " cannot retrieve the list from the server.";
            JOptionPane.showMessageDialog(null, prompt, "SQL Server Error: getList", JOptionPane.ERROR_MESSAGE);
	}
        return list;
    }
}
