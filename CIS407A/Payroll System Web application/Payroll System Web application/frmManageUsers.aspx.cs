using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmManageUsers : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btnAddUser_click(object sender, EventArgs e)
    {
        //create sessions
        Session["txtUserName"] = txtUserName.Text; 
        Session["txtUserPassword"] = txtPassword.Text; 
        Session["txtSecurityLevel"] = ddlSecurityLevel.SelectedValue;

        //Saves the User Login data to the database
        if (clsDataLayer.SaveUser(Server.MapPath("PayrollSystem_DB.accdb"), Session["txtUserName"].ToString(), Session["txtUserPassword"].ToString(), Session["txtSecurityLevel"].ToString()))
        {
            txtUserName.Text = "";
            txtPassword.Text = "";
            lblError.Text = "The user was successfully added!";
            grdUsers.DataBind();
        }
        else
        {
            txtUserName.Text = "";
            txtPassword.Text = "";
            lblError.Text = "The user was not added!";
        }
    }
}