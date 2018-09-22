using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class pgConfirm : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // checking if the record was successfully
        try
        {
            // get the preview page data if exist
            if(PreviousPage.IsCrossPagePostBack)
            {
                // give greetings to the user when he/she submit the order
                Master.UserFeedback.Text = "Please confirm your billing information.";
                Master.UserFeedback.CssClass = "alert alert-danger";

                // get the First and Last Name
                lblName.Text = PreviousPage.FirstName.Text + " " + PreviousPage.LastName.Text;

                // check if Address Line 2 is empty string, if yes then return address with one address
                if (PreviousPage.AddressLine2.Text == "")
                {
                    lblAddress.Text =
                        PreviousPage.AddressLine1.Text + ", " +
                        PreviousPage.City.Text + ", " +
                        PreviousPage.State.Text;
                }
                else
                {
                    lblAddress.Text =
                        PreviousPage.AddressLine1.Text + ", " +
                        PreviousPage.AddressLine2.Text + ", " +
                        PreviousPage.City.Text + ", " +
                        PreviousPage.State.Text;
                }

                // get the Phone number
                lblPhone.Text = PreviousPage.Phone.Text;

                // get credit card type
                lblCCType.Text = PreviousPage.CCType.Text;

                // get credit card number
                lblCCNumber.Text = PreviousPage.CCNumber.Text;
            }
        }
        // catch the error
        catch (Exception error)
        {
            // give the error to the user
            Master.UserFeedback.Text = "Sorry, there was an error processing your request";
            // set the color of the text to red
            Master.UserFeedback.CssClass = "alert alert-danger";
        }
    }

    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        // give greetings to the user when he/she submit the order
        Master.UserFeedback.Text = "Thank you. Your order was submitted successfully!";
        // set the color of the text to green
        Master.UserFeedback.CssClass = "alert alert-success";
    }
}