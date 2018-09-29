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
}