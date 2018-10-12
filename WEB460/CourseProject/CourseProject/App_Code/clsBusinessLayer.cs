using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;

/// <summary>
/// Summary description for clsBusinessLayer
/// </summary>
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
        myDataLayer = new clsDataLayer(dataPath + "ProgramaholicsAnonymous.mdb");
    }

    public dsCourses SelectAllCourses(int userID)
    {
        return myDataLayer.GetAllCourses(userID);
    }

    public DataSet GetUserXMLFile(int userID, string userName)
    {
        DataSet xmlDataSet = new DataSet();

        try
        {
            // Read from a file per user
            xmlDataSet.ReadXml(dataPath + "user-" + userName + ".xml");
        }
        catch
        {
            // If the file is not found grab data from all customers and update XML
            dsCourses courseList = myDataLayer.GetAllCourses(userID);
            courseList.tblCourses.WriteXml(dataPath + "user-" + userName + ".xml");
            xmlDataSet.ReadXml(dataPath + "user-" + userName + ".xml");
        }

        // Return Data set
        return xmlDataSet;
    }

    public DataSet WriteUserXMLFile(System.Web.Caching.Cache appCache, string userName)
    {
        // Read from appCache
        DataSet xmlDataSet = (DataSet)appCache["CoursesDataSet"];

        // Write to the XML
        xmlDataSet.WriteXml(dataPath + "user-" + userName + ".xml");

        // Return written file
        return xmlDataSet;
    }
}