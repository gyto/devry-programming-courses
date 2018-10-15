using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class SignUp : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Master.UserFeedback.Text = "Please enter username and password";
        Master.UserFeedback.CssClass = "alert alert-info";
    }

    protected void BtnLogin_Click(object sender, EventArgs e)
    {
        // Connect to the db
        clsBusinessLayer myBusinessLayer = new clsBusinessLayer(Server.MapPath("~/App_Data/"));

        // validate the user
        bool isValidUser = myBusinessLayer.CheckUserCredentials(Session, txtUserID.Text, txtPassword.Text);

        // if user is valid
        if (isValidUser)
        {
            Session["LoginUser"] = txtUserID.Text;
            Response.Redirect("~/AccountDetails.aspx");
            
        }
        else if (Convert.ToBoolean(Session["LockedSession"]))
        {
            Master.UserFeedback.Text = "Account is disabled. Contact System Administrator";
            Master.UserFeedback.CssClass = "alert alert-info";
            
            // hide the login button
            btnLogin.Visible = false;
        }
        else
        {
            // let user know that he/she has an error
            Master.UserFeedback.Text = "The User Name and/or Password supplied is incorrect. Please try again!";
            Master.UserFeedback.CssClass = "alert alert-danger";
        }
    }

    protected void BtnCreateAccount_Click(object sender, EventArgs e)
    {
        // Check if the fields are not empty
        bool userNameBool = false;
        bool userPasswordBool = false;

        if (txtUserID.Text == "")
        {
            txtUserID.BackColor = System.Drawing.Color.LightGray;
            txtUserID.CssClass = "form-control is-invalid";
            Master.UserFeedback.Text = "User Name cannot be empty";
            Master.UserFeedback.CssClass = "alert alert-danger";
        }
        else
        {
            userNameBool = true;
        }

        if (txtPassword.Text == "")
        {
            txtPassword.BackColor = System.Drawing.Color.LightGray;
            txtPassword.CssClass = "form-control is-invalid";
            Master.UserFeedback.Text = "Password cannot be empty";
            Master.UserFeedback.CssClass = "alert alert-danger";
        }
        else
        {
            userPasswordBool = true;
        }

        if (userNameBool && userPasswordBool)
        {
            // Find a DB in the files
            string tempPath = Server.MapPath("~/App_Data/ProgramaholicsAnonymous.mdb");
            clsDataLayer myDataLayer = new clsDataLayer(tempPath);

            myDataLayer.CreateUserAccount(txtUserID.Text, txtPassword.Text);
            Session["LoginUser"] = txtUserID.Text;
            Response.Redirect("~/AccountDetails.aspx");
        }
    }
}