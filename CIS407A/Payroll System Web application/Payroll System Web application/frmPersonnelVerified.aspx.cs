using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmPersonnelVerified : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // On submit receive the request from the frmPersonnel.aspx file
        txtVerifiedInfo.Text = Session["txtFirstName"].ToString() +
            "\n" + Session["txtLastName"].ToString() +
            "\n" + Session["txtPayRate"].ToString() +
            "\n" + Session["txtStartDate"].ToString() +
            "\n" + Session["txtEndDate"].ToString();

        // Grab the data that was sent to the server
        if(clsDataLayer.SavePersonnel(Server.MapPath("PayrollSystem_DB.accdb"),
            Session["txtFirstName"].ToString(),
            Session["txtLastName"].ToString(),
            Session["txtPayRate"].ToString(),
            Session["txtStartDate"].ToString(),
            Session["txtEndDate"].ToString()))
        {
            txtVerifiedInfo.Text = txtVerifiedInfo.Text + "\nThe information was successfully saved!";
        }
        else
        {
            txtVerifiedInfo.Text = txtVerifiedInfo.Text + "\nThe information was NOT saved.";
        }
    }
}