using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class AccountDetails : System.Web.UI.Page
{
    // Create a class to Business layer
    clsBusinessLayer myBusinessLayer;

    protected void Page_Load(object sender, EventArgs e)
    {
        // Create a path to APP DATA
        myBusinessLayer = new clsBusinessLayer(Server.MapPath("~/App_Data/"));

        // Check for the user after he/she login
        dsAccountInfo dsUserName;
        dsUser dsUserId;
        dsCourses dsCourse;

        string tempPath = Server.MapPath("~/App_Data/ProgramaholicsAnonymous.mdb");
        clsDataLayer dataLayerObj = new clsDataLayer(tempPath);
        dsUserName = dataLayerObj.FindUser(Session["LoginUser"].ToString());

        // hide button for new users
        btnSaveAccount.Visible = false;


        if (dsUserName.tblAccountInfo.Rows.Count > 0)
        {
            // fill out user information
            lblWelcome.Text = dsUserName.tblAccountInfo[0].userName;
            txtUser.Text = dsUserName.tblAccountInfo[0].userName;
            txtCity.Text = dsUserName.tblAccountInfo[0].city;
            txtState.Text = dsUserName.tblAccountInfo[0].state;
            txtFPL.Text = dsUserName.tblAccountInfo[0].favLanguage;
            txtLeastFPL.Text = dsUserName.tblAccountInfo[0].leastLanguage;

            userID.Attributes.Add("class", "input-group-append d-flex");
            lblUserID.Text = dsUserName.tblAccountInfo[0].userID.ToString();

            btnDelete.CssClass = "btn btn-danger btn-block mr-1";
            btnUpdateAccount.CssClass = "btn btn-primary btn-block mt-0 ml-1";
            btnExportXML.CssClass = "btn btn-secondary btn-block mt-4";

            // get all courses if they exist
            dsCourse = dataLayerObj.GetAllCourses(Convert.ToInt32(lblUserID.Text));

            // Bind Courses GridView
            BindCoursesGridView();

            // Do a check if the table is not empty for this user
            if (dsCourse.tblCourses.Rows.Count > 0)
            {
                // Bind XML GridView
                BindXMLGridView();
            }
        }
        else
        {
            // find a user by ID
            dsUserId = dataLayerObj.FindId(Session["LoginUser"].ToString());

            userID.Attributes.Add("class", "input-group-append d-flex");
            lblUserID.Text = dsUserId.tblUsers[0].ID.ToString();

            // hide to update the account information and insert it for the new one
            btnUpdateAccount.Visible = false;
            btnSaveAccount.Visible = true;

            // Get as much data as we can
            lblWelcome.Text = Session["LoginUser"].ToString();
            txtUser.Text = Session["LoginUser"].ToString();
            Session["txtUser"] = Session["LoginUser"].ToString();
        }
    }


    // On click save the fields content to session and redirect to the next page
    protected void BtnUpdateInformation_Click(object sender, EventArgs e)
    {
        Session["txtCity"] = txtCity.Text;
        Session["txtState"] = txtState.Text;
        Session["txtFPL"] = txtFPL.Text;
        Session["txtLeastFPL"] = txtLeastFPL.Text;
        Session["lblUserID"] = lblUserID.Text;
        Session["txtUser"] = txtUser.Text;

        Response.Redirect("AccountDetailsConf.aspx");
    }

    protected void BtnFindUser_Click(object sender, EventArgs e)
    {
        // Connect to dsPA
        dsAccountInfo dsUserName;
        dsCourses dsCourse;

        // Find a db file
        string tempPath = Server.MapPath("~/App_Data/ProgramaholicsAnonymous.mdb");
        clsDataLayer dataLayerObj = new clsDataLayer(tempPath);

        try
        {
            // Try to find a customer by User Name
            dsUserName = dataLayerObj.FindUser(txtFindUser.Text);

            // if the customer is exist then fill the records
            if (dsUserName.tblAccountInfo.Rows.Count > 0)
            {
                // Take records from a field
                lblWelcome.Text = dsUserName.tblAccountInfo[0].userName;
                txtUser.Text = dsUserName.tblAccountInfo[0].userName;
                txtCity.Text = dsUserName.tblAccountInfo[0].city;
                txtState.Text = dsUserName.tblAccountInfo[0].state;
                txtFPL.Text = dsUserName.tblAccountInfo[0].favLanguage;
                txtLeastFPL.Text = dsUserName.tblAccountInfo[0].leastLanguage;

                userID.Attributes.Add("class", "input-group-append d-flex");
                lblUserID.Text = dsUserName.tblAccountInfo[0].userID.ToString();

                btnDelete.CssClass = "btn btn-danger btn-block mr-1";
                btnUpdateAccount.CssClass = "btn btn-primary btn-block mt-0 ml-1";
                btnExportXML.CssClass = "btn btn-secondary btn-block mt-4";

                Master.UserFeedback.Text = "Record is Found!";
                Master.UserFeedback.CssClass = "alert alert-success d-block";

                dsCourse = dataLayerObj.GetAllCourses(Convert.ToInt32(lblUserID.Text));

                // Bind the User Grid Information
                BindCoursesGridView();

                // Do a check if the table is not empty for this user
                if (dsCourse.tblCourses.Rows.Count > 0)
                {
                    // Bind XML GridView
                    BindXMLGridView();
                }
            }
            else
            {
                Master.UserFeedback.Text = "No records were Found!";
                Master.UserFeedback.CssClass = "alert alert-danger d-block";
            }
        }
        catch (Exception error)
        {
            string message = "Something went wrong - ";
            Master.UserFeedback.Text = message + error.Message;
            Master.UserFeedback.CssClass = "alert alert-danger d-block";
        }
    }

    protected void BtnDeleteAccount_Click(object sender, EventArgs e)
    {

        // Find a db file
        string tempPath = Server.MapPath("~/App_Data/ProgramaholicsAnonymous.mdb");
        clsDataLayer myDataLayer = new clsDataLayer(tempPath);

        try
        {
            myDataLayer.DeleteAccount(Convert.ToInt32(lblUserID.Text));

            // Reset Form
            lblWelcome.Text = "Stranger";
            txtUser.Text = "Stranger";
            txtCity.Text = "";
            txtState.Text = "";
            txtFPL.Text = "";
            txtLeastFPL.Text = "";
            lblUserID.Text = "0";
            txtFindUser.Text = "";

            Response.Redirect("~/SignUp.aspx");

            Master.UserFeedback.Text = "User was Deleted from Database";
            Master.UserFeedback.CssClass = "alert alert-success d-block";
        }
        catch (Exception error)
        {
            string message = "Something went wrong - ";
            Master.UserFeedback.Text = message + error.Message;
            Master.UserFeedback.CssClass = "alert alert-danger d-block";
        }
    }

    private dsCourses BindCoursesGridView()
    {
        // Find a db file
        string tempPath = Server.MapPath("~/App_Data/ProgramaholicsAnonymous.mdb");
        clsDataLayer myDataLayer = new clsDataLayer(tempPath);

        // Call the class and bind it to the customer listing
        dsCourses userCourses = myBusinessLayer.SelectAllCourses(Convert.ToInt32(lblUserID.Text));

        // Bind to the GridView
        gvCourseList.DataSource = userCourses.tblCourses;

        //Bind the data
        gvCourseList.DataBind();
        Cache.Insert("CoursesDataSet", userCourses);

        return userCourses;
    }

    public void BtnExportToXML_Click(object sender, EventArgs e)
    {
        // Bind data from a click
        gvXML.DataSource = myBusinessLayer.WriteUserXMLFile(Cache, txtUser.Text);
        gvXML.DataBind();

        // Let user know that it was bind
        Master.UserFeedback.Text = "Successfully Update XML file";
        Master.UserFeedback.CssClass = "alert alert-success";
    }


    public void BindXMLGridView()
    {
        // Bind to the GridView
        gvXML.DataSource = myBusinessLayer.GetUserXMLFile(Convert.ToInt32(lblUserID.Text), txtUser.Text);
        gvXML.DataBind();
    }

    protected void BtnSaveInformation_Click(object sender, EventArgs e)
    {
        // Find a db file
        string tempPath = Server.MapPath("~/App_Data/ProgramaholicsAnonymous.mdb");
        clsDataLayer myDataLayer = new clsDataLayer(tempPath);

        //Save user and then find user

        myDataLayer.SaveAccountInfo(txtCity.Text, txtState.Text, txtFPL.Text, txtLeastFPL.Text, Convert.ToInt32(lblUserID.Text));

        Response.Redirect("~/AccountDetails.aspx");
    }
}