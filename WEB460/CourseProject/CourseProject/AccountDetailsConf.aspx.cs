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
        lblCity.Text = Session["txtCity"].ToString();
        lblState.Text = Session["txtState"].ToString();
        lblFPL.Text = Session["txtFPL"].ToString();
        lblLeastFPL.Text = Session["txtLeastFPL"].ToString();
    }
}