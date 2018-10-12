using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

// Libraries
using System.Data.OleDb;
using System.Net;
using System.Data;

public class clsDataLayer
{
    // Create DB connectionhttp://localhost:58853/App_Code/clsDataLayer.cs
    OleDbConnection dbConnection;

    public clsDataLayer(string Path)
    {
        // Create a path to file
        dbConnection = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;Data Source=" + Path);
    }

    public dsAccountInfo FindUser(string UserName)
    {
        //string sqlStmt = "SELECT * FROM tblAccountInfo WHERE tblAccountInfo.userName LIKE '" + UserName + "'";
        string sqlStmt = "SELECT * FROM tblUsers INNER JOIN tblAccountInfo ON tblUsers.ID = tblAccountInfo.userID WHERE tblUsers.userName LIKE '" + UserName + "'";
        OleDbDataAdapter sqlDataAdapter = new OleDbDataAdapter(sqlStmt, dbConnection);

        // Create an Object of dsAccounts
        dsAccountInfo myStoreDataSet = new dsAccountInfo();
        sqlDataAdapter.Fill(myStoreDataSet.tblAccountInfo);

        // Return Data Set
        return myStoreDataSet;
    }

    public void UpdateAccountInfo(
        string state,
        string city,
        string favLanguage,
        string leastLanguage,
        int userID)
    {
        // Open DB connection
        dbConnection.Open();

        string sqlStmt = "UPDATE tblAccountInfo SET " +
            "state = @state, " +
            "city = @city, " +
            "favLanguage = @favLanguage, " +
            "leastLanguage = @leastLanguage " +
            "WHERE (tblAccountInfo.ID = @id)";

        // Connect to db table
        OleDbCommand dbCommand = new OleDbCommand(sqlStmt, dbConnection);

        // Add param from sqlStatement
        OleDbParameter param = new OleDbParameter("@state", state);
        dbCommand.Parameters.Add(param);

        dbCommand.Parameters.Add(new OleDbParameter("@city", city));
        dbCommand.Parameters.Add(new OleDbParameter("@favLanguage", favLanguage));
        dbCommand.Parameters.Add(new OleDbParameter("@leastLanguage", leastLanguage));
        dbCommand.Parameters.Add(new OleDbParameter("@id", userID));

        // Execute the query
        dbCommand.ExecuteNonQuery();

        // Close DB connection
        dbConnection.Close();
    }

    public void DeleteAccount(int userID)
    {
        // Open DB connection
        dbConnection.Open();

        // not functional
        //string sqlStmt = "DELETE tblUsers.*, tblAccountInfo.*, tblCourses.* FROM tblUsers INNER JOIN tblAccountInfo ON tblUsers.ID = tblAccountInfo.userID AND INNER JOIN tblCourses ON tblUsers.ID = tblCourses.userID WHERE tblUsers.ID = @id";

        // Fully delete all information about the user
        string sqlStmt =
            "DELETE tblUsers.*, tblAccountInfo.* " +
            "FROM tblUsers " +
            "INNER JOIN tblAccountInfo ON tblUsers.ID = tblAccountInfo.userID " +
            "WHERE tblUsers.ID = @id";

        // not functional
        //string userCourses = "DELETE tblUsers.*, tblCourses.* FROM tblUsers INNER JOIN tblCourses ON tblUsers.ID = tblCourses.userID WHERE tblUsers.ID = @id";

        // Getting the user from db
        OleDbCommand dbCommand = new OleDbCommand(sqlStmt, dbConnection);
        OleDbParameter param = new OleDbParameter("@id", userID);
        dbCommand.Parameters.Add(param);

        // Execute the query
        dbCommand.ExecuteNonQuery();

        // Close DB connection
        dbConnection.Close();
    }

    public dsCourses GetAllCourses(int selectedUserID)
    {
        string sqlStmt = "SELECT * FROM tblCourses WHERE tblCourses.userID LIKE '" + selectedUserID + "'";

        // Getting all fields from the table
        OleDbDataAdapter sqlDataAdapter = new OleDbDataAdapter(sqlStmt, dbConnection);

        // Create an Object of dsCourses
        dsCourses myStoreDataSet = new dsCourses();
        sqlDataAdapter.Fill(myStoreDataSet.tblCourses);

        // Return Data Set
        return myStoreDataSet;
    }
}