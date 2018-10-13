using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class pgLogin : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Master.UserFeedback.Text = "Please enter username and password.";
        Master.UserFeedback.CssClass = "alert alert-info";
    }

    protected void BtnLogin_Click(object sender, EventArgs e)
    {
        // Connect the database
        clsBusinessLayer myBusinessLayer = new clsBusinessLayer(Server.MapPath("~/App_Data/"));

        // Validate the user
        bool isValidUser = myBusinessLayer.CheckUserCredentials(Session, txtUserID.Text, txtPassword.Text);

        // if user valid then
        if (isValidUser)
        {
            // Redirect user to page
            Response.Redirect("~/pgCheckOut.aspx");
        }
        else if (Convert.ToBoolean(Session["LockedSession"]))
        {
            Master.UserFeedback.Text = "Account is disabled. Contact System Administrator";
            Master.UserFeedback.CssClass = "alert alert-info";

            // Hide login button
            btnLogin.Visible = false;
        }
        else
        {
            // Let user know that he/she has an error
            Master.UserFeedback.Text = "The User ID and/or Password supplied is incorrect. Please try again!";
            Master.UserFeedback.CssClass = "alert alert-danger";
        }
    }
}