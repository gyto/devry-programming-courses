using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class pgCheckOut : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // let user know that he/she need to insert th ebilling information
        Master.UserFeedback.Text = "Please enter billing information.";
        Master.UserFeedback.CssClass = "alert alert-danger";
    }
    protected void rblCCType_SelectedIndexChanged(object sender, EventArgs e) {}
    protected void btnSubmit_Click(object sender, EventArgs e) {}

    /*
     * Creating public TextBoxes to return the value from a form
     * FirstName - user first name 
     * LastName - user last name
     * AddressLine1 - user first address
     * AddressLine2 - user second address
     * City - user city
     * State - user state
     * Phone - user phone
     * CCNumber - user card number
     * CCType - user type of the card, has values (Visa, Master Card, Discovery)
     */

    public TextBox FirstName { get { return txtFirstName; } }
    public TextBox LastName { get { return txtLastName; } }
    public TextBox AddressLine1 { get { return txtLine1; } }
    public TextBox AddressLine2 { get { return txtLine2; } }
    public TextBox City { get { return txtCity; } }
    public TextBox State { get { return txtState; } }
    public TextBox Phone { get { return txtPhone; } }
    public TextBox CCNumber { get { return txtCCNumber; } }
    public RadioButtonList CCType { get { return rblCCType; } }
}