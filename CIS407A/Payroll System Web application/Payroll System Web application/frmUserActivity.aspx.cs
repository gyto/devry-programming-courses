using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmUserActivity : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // Check if the Admin is present
        if (Session["SecurityLevel"] != "A")
        {
            Response.Redirect("frmLogin.aspx");
        }

        if (!Page.IsPostBack)
        {
            // Define the DataSet
            dsUserActivity myDataSet = new dsUserActivity();

            // Fill the DataSet with what is returned from the function
            myDataSet = clsDataLayer.GetUserActivity(Server.MapPath("PayrollSystem_DB.accdb"));

            // Sets teh DataGrid to the DataSource based on the table
            grdUserActivity.DataSource = myDataSet.Tables["tblUserActivity"];

            // Binds the DataGrid
            grdUserActivity.DataBind();
        }
    }
}