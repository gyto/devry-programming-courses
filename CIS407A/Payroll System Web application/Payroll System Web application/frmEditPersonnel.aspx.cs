using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmEditPersonnel : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // Check if the Admin is present
        if (Session["SecurityLevel"] != "A")
        {
            Response.Redirect("frmLogin.aspx");
        }
    }

    protected void SqlDataSource1_Selecting(object sender, SqlDataSourceSelectingEventArgs e)
    {

    }

    protected void grdEditPersonnel_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}