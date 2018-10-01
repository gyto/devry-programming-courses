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
        string sqlStmt = "SELECT * FROM tblAccountInfo WHERE userName LIKE '" + UserName + "'";
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

        string sqlStmt = "DELETE FROM tblAccountInfo WHERE tblAccountInfo.ID = @id";

        // Getting the user from db
        OleDbCommand dbCommand = new OleDbCommand(sqlStmt, dbConnection);
        OleDbParameter param = new OleDbParameter("@id", userID);
        dbCommand.Parameters.Add(param);

        // Execute the query
        dbCommand.ExecuteNonQuery();

        // Close DB connection
        dbConnection.Close();
    }
}