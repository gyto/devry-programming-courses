using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmLogin : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
    {
        // Creact objec of the table
        dsUser dsUserLogin;

        // create sring of Security level
        string SecurityLevel;

        // Read from give file and look for login and password
        dsUserLogin = clsDataLayer.VerifyUser(Server.MapPath("PayrollSystem_DB.accdb"), Login1.UserName, Login1.Password);

        // Check if the credentials are right
        if(dsUserLogin.tblUserLogin.Count < 1)
        {
            e.Authenticated = false;
            return;
        }

        // Define User Rules for Account
        SecurityLevel = dsUserLogin.tblUserLogin[0].SecurityLevel.ToString();

        // Switch case when there is different user access level
        switch (SecurityLevel)
        {
            case "A":
                // if the access true then give Admin Access
                e.Authenticated = true;
                Session["SecurityLevel"] = "A";
                break;
            case "U":
                // If the access true tehn give User Access
                e.Authenticated = true;
                Session["SecurityLevel"] = "U";
                break;
            default:
                e.Authenticated = false;
                break;
        }
    }
}