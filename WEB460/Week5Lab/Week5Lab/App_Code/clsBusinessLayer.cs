using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;

public class clsBusinessLayer
{
    // Declare data path
    string dataPath;

    // Set the class Data Layer
    clsDataLayer myDataLayer;

    public clsBusinessLayer(string serverMappedPath)
    {
        // Set a data path to DB
        dataPath = serverMappedPath;
        myDataLayer = new clsDataLayer(dataPath + "Accounts.mdb");
    }

    public DataSet GetCustomerXMLFile()
    {
        // Crate new data set
        DataSet xmlDataSet = new DataSet();

        try
        {
            // Read from a file
            xmlDataSet.ReadXml(dataPath + "customers.xml");
        }
        catch (System.IO.FileNotFoundException error)
        {
            // If the file is not found grab data from all customers and update XML
            dsAccounts customerListing = myDataLayer.GetAllCustomers();
            customerListing.tblCustomers.WriteXml(dataPath + "customers.xml");
            xmlDataSet.ReadXml(dataPath + "customers.xml");
        }

        // Return Data set
        return xmlDataSet;
    }

    public DataSet WriteCustomerXMLFile(System.Web.Caching.Cache appCache)
    {
        // Read from appCache
        DataSet xmlDataSet = (DataSet)appCache["CustomerDataSet"];

        // Write to the XML
        xmlDataSet.WriteXml(dataPath + "customers.xml");

        // Return written file
        return xmlDataSet;
    }

    public dsAccounts SelectAllCustomers()
    {
        return myDataLayer.GetAllCustomers();
    }

    public string UpdateCustomer(
        string firstName,
        string lastName,
        string address1,
        string address2,
        string city,
        string state,
        string phoneNumber,
        int customerID)
    {
        // result a message for the user
        string resultMessage = "Customer Update Successfully.";

        // try to catch the error
        try
        {
            myDataLayer.UpdateCustomer(
                firstName,
                lastName,
                address1,
                address2,
                city,
                state,
                phoneNumber,
                customerID);
        }
        catch (Exception error)
        {
            // give an error
            resultMessage = "Error updating customer, please check form data.";
            resultMessage = resultMessage + error.Message;
        }

        // return the result
        return resultMessage;
    }

    public string InsertCustomer(
        string firstName,
        string lastName,
        string address1,
        string address2,
        string city,
        string state,
        string phoneNumber)
    {
        // create a user with message
        string resultMessage = "Customer Added Successfully.";

        // try to catch the error
        try
        {
            myDataLayer.InsertCustomer(
                firstName,
                lastName,
                address1,
                address2,
                city,
                state,
                phoneNumber);
        }
        catch (Exception error)
        {
            // give an error
            resultMessage = "Error adding custoemr, please check form data.";
            resultMessage = resultMessage = error.Message;
        }

        // return results
        return resultMessage;
    }

    public dsAccounts FindCustomer(string LastName)
    {
        // check the field by last name from Data Layer
        dsAccounts dsFoundCustomer = myDataLayer.FindCustomer(LastName);

        // check if field is empty and set to be null
        if(dsFoundCustomer.tblCustomers.Rows.Count > 0)
        {
            // Filter the row
            System.Data.DataRow customerRecord = dsFoundCustomer.tblCustomers.Rows[0];

            if (customerRecord["FirstName"] == DBNull.Value)
                customerRecord["FirstName"] = string.Empty;

            if (customerRecord["LastName"] == DBNull.Value)
                customerRecord["LastName"] = string.Empty;

            if (customerRecord["Address1"] == DBNull.Value)
                customerRecord["Address1"] = string.Empty;

            if (customerRecord["Address2"] == DBNull.Value)
                customerRecord["Address2"] = string.Empty;

            if (customerRecord["City"] == DBNull.Value)
                customerRecord["City"] = string.Empty;

            if (customerRecord["State"] == DBNull.Value)
                customerRecord["State"] = string.Empty;

            if (customerRecord["PhoneNumber"] == DBNull.Value)
                customerRecord["PhoneNumber"] = string.Empty;
        }

        return dsFoundCustomer;
    }

    public bool CheckUserCredentials(
        System.Web.SessionState.HttpSessionState currentSession,
        string username,
        string password)
    {
        // Dont lock current session
        currentSession["LockedSession"] = false;

        // Initiate total Attemps
        int totalAttemps = Convert.ToInt32(currentSession["AttemptCount"]) + 1;
        currentSession["AttemptCount"] = totalAttemps;

        // Initiate user Attemps
        int userAttempts = Convert.ToInt32(currentSession[username]) + 1;
        currentSession[username] = userAttempts;

        // If user fails to procced
        if ( (userAttempts > 3) || (totalAttemps > 6) )
        {
            currentSession["LockedSession"] = true;
            myDataLayer.LockUserAccount(username);
        }

        return myDataLayer.ValidateUser(username, password);
    }
}