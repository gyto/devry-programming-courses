using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmViewPersonnel : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if(!Page.IsPostBack)
        {
            // Declare the Database connection
            dsPersonnel myDataSet = new dsPersonnel();

            // write a case if the search is written first
            string strSearch = Request["txtSearch"];

            // Fill the dataset with it and return it from the method.
            myDataSet = clsDataLayer.GetPersonnel(Server.MapPath("PayrollSystem_DB.accdb"), strSearch);

            // Set the DataGrid to the DataSource based on the table
            grdViewPersonnel.DataSource = myDataSet.Tables["tblPersonnel"];

            //Bind the DataGrid
            grdViewPersonnel.DataBind();
        }

    }

    protected void grdViewPersonnel_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}