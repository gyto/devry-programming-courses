using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class AccountDetailsConf : System.Web.UI.Page
{
    // On page load get the content from previus page session and populate on the page
    protected void Page_Load(object sender, EventArgs e)
    {
        lblUserName.Text = Session["txtUser"].ToString();
        lblCity.Text = Session["txtCity"].ToString();
        lblState.Text = Session["txtState"].ToString();
        lblFPL.Text = Session["txtFPL"].ToString();
        lblLeastFPL.Text = Session["txtLeastFPL"].ToString();
        lblUserID.Text = Session["lblUserID"].ToString();
    }

    protected void BtnUpdateAccountInfo_Click(object sender, EventArgs e)
    {
        // Set update user error to false
        bool updateUserError = false;

        // Find a DB in the files
        string tempPath = Server.MapPath("~/App_Data/ProgramaholicsAnonymous.mdb");
        clsDataLayer myDataLayer = new clsDataLayer(tempPath);

        try
        {
            myDataLayer.UpdateAccountInfo(
                lblState.Text,
                lblCity.Text,
                lblFPL.Text,
                lblLeastFPL.Text,
                Convert.ToInt32(lblUserID.Text));
        }
        catch (Exception error)
        {
            updateUserError = true;
            string message = "Error updating customer, please check form data - ";
            Master.UserFeedback.Text = message + error.Message;
            Master.UserFeedback.CssClass = "alert alert-danger d-block";
        }

        if (!updateUserError)
        {
            Response.Redirect("AccountDetails.aspx");
            // Master.UserFeedback.Text = "User Record Updated";
            // Master.UserFeedback.CssClass = "alert alert-success d-block";
        }
    }
}