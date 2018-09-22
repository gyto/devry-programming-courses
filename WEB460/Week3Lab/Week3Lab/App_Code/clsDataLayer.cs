using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

// Include namespaces to enable database access.
using System.Data.OleDb;
using System.Net;
using System.Data;

public class clsDataLayer
{
    // Create a connection to DB
    OleDbConnection dbConnection;
    public clsDataLayer(string Path)
    {
        dbConnection = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;Data Source=" + Path);
    }

    // Find a customer in the DB
    public dsAccounts FindCustomer(string LastName)
    {
        // Find Customer by LastName
        string sqlStmt = "select * from tblCustomers where LastName like '" + LastName + "'";
        OleDbDataAdapter sqlDataAdapter = new OleDbDataAdapter(sqlStmt, dbConnection);

        // Create an Object of dsAccounts
        dsAccounts myStoreDataSet = new dsAccounts();
        sqlDataAdapter.Fill(myStoreDataSet.tblCustomers);

        // Return Data Set
        return myStoreDataSet;
    }

    // Update a customer in the DB
    public void UpdateCustomer(
        string firstName, 
        string lastName,
        string address1,
        string address2,
        string city,
        string state,
        string phoneNumber,
        int customerID)
    {
        // Open Db Connection
        dbConnection.Open();

        // Find and Update the record in db
        string sqlStmt = "UPDATE tblCustomers SET FirstName = @first, " +
            "LastName = @last, " +
            "Address1 = @address1, " +
            "Address2 = @address2, " +
            "City = @city, " +
            "State = @state, " +
            "PhoneNumber = @phone " +
            "WHERE (tblCustomers.CustomerID = @id)";

        // Connect to db table
        OleDbCommand dbCommand = new OleDbCommand(sqlStmt, dbConnection);

        // Add param from sqlStatement
        OleDbParameter param = new OleDbParameter("@first", firstName);
        dbCommand.Parameters.Add(param);

        dbCommand.Parameters.Add(new OleDbParameter("@last", lastName));
        dbCommand.Parameters.Add(new OleDbParameter("@address1", address1));
        dbCommand.Parameters.Add(new OleDbParameter("@address2", address2));
        dbCommand.Parameters.Add(new OleDbParameter("@city", city));
        dbCommand.Parameters.Add(new OleDbParameter("@state", state));
        dbCommand.Parameters.Add(new OleDbParameter("@phone", phoneNumber));
        dbCommand.Parameters.Add(new OleDbParameter("@id", customerID));

        // Execute the query
        dbCommand.ExecuteNonQuery();

        // Close DB connection
        dbConnection.Close();
    }

    // Create new customer in DB
    public void InsertCustomer(
        string firstName,
        string lastName,
        string address1,
        string address2,
        string city,
        string state,
        string phoneNumber)
    {
        // Open Connection
        dbConnection.Open();

        // Inser the record to db
        string sqlStmt = "INSERT INTO tblCustomers (" +
            "FirstName, " +
            "LastName, " +
            "Address1, " +
            "Address2, " +
            "City, " +
            "State, " +
            "PhoneNumber) ";
        sqlStmt += "VALUES (" +
            "@first, " +
            "@last, " +
            "@address1, " +
            "@address2, " +
            "@city, " +
            "@state, " +
            "@phone)";

        // Connect to db table
        OleDbCommand dbCommand = new OleDbCommand(sqlStmt, dbConnection);

        // Add param from sqlStatement
        OleDbParameter param = new OleDbParameter("@first", firstName);
        dbCommand.Parameters.Add(param);

        dbCommand.Parameters.Add(new OleDbParameter("@last", lastName));
        dbCommand.Parameters.Add(new OleDbParameter("@address1", address1));
        dbCommand.Parameters.Add(new OleDbParameter("@address2", address2));
        dbCommand.Parameters.Add(new OleDbParameter("@city", city));
        dbCommand.Parameters.Add(new OleDbParameter("@state", state));
        dbCommand.Parameters.Add(new OleDbParameter("@phone", phoneNumber));

        // Execute the query
        dbCommand.ExecuteNonQuery();

        // Close DB connection
        dbConnection.Close();
    }
}