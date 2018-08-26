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
        // Check if the Admin is present
        if (Session["SecurityLevel"] != "A")
        {
            Response.Redirect("frmLogin.aspx");
        }
    }

    protected void btnAddUser_click(object sender, EventArgs e)
    {
        //Saves the User Login data to the database
        if (clsDataLayer.SaveUser(Server.MapPath("PayrollSystem_DB.accdb"), txtUserName.Text, txtPassword.Text, ddlSecurityLevel.SelectedValue))
        {
            lblError.Text = "The user was successfully added!";
            grdUsers.DataBind();
        }
        else
        {
            lblError.Text = "The user was not added!";
        }
    }
}