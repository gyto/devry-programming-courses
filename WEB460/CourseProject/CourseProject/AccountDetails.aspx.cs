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

        Response.Redirect("AccountDetailsConf.aspx");
    }
}