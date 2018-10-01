using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class AccountDetails : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e) {}


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
                lblUserID.Text = dsUserName.tblAccountInfo[0].ID.ToString();

                btnDelete.CssClass = "btn btn-danger btn-block mr-1";

                Master.UserFeedback.Text = "Record is Found!";
                Master.UserFeedback.CssClass = "alert alert-success d-block";
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
}