using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

// Include namespaces to enable database access.
using System.Data.OleDb;
using System.Net;
using System.Data;

// Create public class Data Layer
public class clsDataLayer
{
    public clsDataLayer() {}

    // Function gets the user activuty from the tblUserActivity
    public static dsUserActivity GetUserActivity(string Database)
    {
        // Connect the database to the class
        dsUserActivity DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;

        // Use provider in order to read from file
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" + "Data Source=" + Database);

        // Select everything in table from the database
        sqlDA = new OleDbDataAdapter("select * from tblUserActivity", sqlConn);

        // Instantiate the dataset object
        DS = new dsUserActivity();

        // Put the imported information into the dataset table
        sqlDA.Fill(DS.tblUserActivity);

        // Send the datase back to the calling form for display
        return DS;
    }

    // Function gets the peronnel from the tblPersonnel
    public static dsPersonnel GetPersonnel(string Database, string strSearch)
    {
        // Create a get method to the tblPersonnel in order to get data, similar to GetUserActivity
        dsPersonnel DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;

        // Use provider in order to read from file
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" + "Data Source=" + Database);

        // check if the search was entered first or its null
        if (strSearch == null || strSearch.Trim() == "")
        {
            sqlDA = new OleDbDataAdapter("select * from tblPersonnel", sqlConn);
        }
        else
        {
            sqlDA = new OleDbDataAdapter("select * from tblPersonnel where LastName = '" + strSearch + "'", sqlConn);
        }

        // Instantiate the dataset object
        DS = new dsPersonnel();

        // Put the imported information into the dataset table
        sqlDA.Fill(DS.tblPersonnel);

        // Send the datase back to the calling form for display
        return DS;
    }

    // This function saves the user activity from tblUserActivity
    public static void SaveUserActivity(string Database, string FormAccessed)
    {
        /* 
            The following block of code instantiates an OldDbConnection object called "conn",
            then opens the connection to the database, creates a SQL command, executes the
            SQL command, and then closes the connection.
        */
        OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" + "Data Source=" + Database);
        conn.Open();
        OleDbCommand command = conn.CreateCommand();
        string strSQL;
        strSQL = "Insert into tblUserActivity (UserIP, FormAccessed) values ('" + GetIP4Address() + "', '" + FormAccessed + "')";
        command.CommandType = CommandType.Text;
        command.CommandText = strSQL;
        command.ExecuteNonQuery();
        conn.Close();
    }

    // This function gets the IP Address
    public static string GetIP4Address()
    {
        // Set the user IP to be empty string
        string IP4Address = string.Empty;

        // Check if the IP can be requested from HTTP protocol
        foreach (IPAddress IPA in Dns.GetHostAddresses(HttpContext.Current.Request.UserHostAddress))
        {
            if(IPA.AddressFamily.ToString() == "InterNetwork")
            {
                IP4Address = IPA.ToString();
                break;
            }
        }

        // If the address is not empty then return the IP
        if (IP4Address != string.Empty)
        {
            return IP4Address;
        }

        // Check if the IP can be requested from Host Address
        foreach (IPAddress IPA in Dns.GetHostAddresses(Dns.GetHostName()))
        {
            if(IPA.AddressFamily.ToString() == "InterNetwork")
            {
                IP4Address = IPA.ToString();
                break;
            }
        }

        // Just return IP address to the function
        return IP4Address;
    }

    // This function will save Personeel data to database
    public static bool SavePersonnel(string Database, string FIrstName, string LastName, string PayRate, string StartDate, string EndDate)
    {
        bool recordSaved;
        try
        {
            // Connect to the database records
            OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.ACE.OLEDB.12.0;" + "Data Source=" + Database);
            conn.Open();
            OleDbCommand command = conn.CreateCommand();
            string strSQL;

            // Add created records to the table row
            strSQL = "Insert into tblPersonnel " +
                "(FirstName, LastName, PayRate, StartDate, EndDate) values ('" +
                FIrstName +
                "', '" +
                LastName +
                "', " +
                PayRate +
                ", '" +
                StartDate +
                "', '" +
                EndDate +
                "')";

            // Convert command type
            command.CommandType = CommandType.Text;
            command.CommandText = strSQL;

            // Execute non query function
            command.ExecuteNonQuery();

            // Close connection
            conn.Close();
            recordSaved = true;
        } catch (Exception ex)
        {
            recordSaved = false;
        }

        return recordSaved;
    }
}