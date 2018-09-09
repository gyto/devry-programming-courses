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
            lblStatus.Text = error.Message;
            // set the color of the text to red
            lblStatus.ForeColor = System.Drawing.Color.Red;
        }
    }

    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        // give greetings to the user when he/she submit the order
        lblStatus.Text = "Thank you. Your order was submitted successfully!";
        // set the color of the text to green
        lblStatus.ForeColor = System.Drawing.Color.Green;
    }
}