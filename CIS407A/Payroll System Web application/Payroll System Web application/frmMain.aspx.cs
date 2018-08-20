using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmMain : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // Disable some of the boxes for Regular User

        if (Session["SecurityLevel"] == "U")
        {
            linkbtnNewEmployee.Visible = false;
            imgbtnNewEmployee.Visible = false;
            NewEmployeeBox.Visible = false;

            linkbtnViewUserActivity.Visible = false;
            imgbtnViewUserActivity.Visible = false;
            ViewUserActivityBox.Visible = false;

            linkbtnEditEmployees.Visible = false;
            imgbtnEditEmployees.Visible = false;
            EditEmployeeBox.Visible = false;

            imgbtnManageUsers.Visible = false;
            linkbtnManageUsers.Visible = false;
            ManageUsersBox.Visible = false;
        }

        // Save User Activity to the file
        clsDataLayer.SaveUserActivity(Server.MapPath("PayrollSystem_DB.accdb"), "frmPersonnel");
    }
}