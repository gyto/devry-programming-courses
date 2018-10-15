using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class PA : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            lblGUID.Text = System.Guid.NewGuid().ToString();
            // Set any user that come to the page as Guest
        }
    }

    public Label UserFeedback
    {
        get { return lblUserFeedBack; }
        set { lblUserFeedBack = value; }
    }
}
