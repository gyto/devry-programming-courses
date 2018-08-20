using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmPersonnel : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        // Check what security level User have
        if (Session["SecurityLevel"] == "A")
        {
            btnSubmit.Visible = true;
        }
        // Hide the button if the access is not Admin
        else
        {
            btnSubmit.Visible = false;
        }
    }

    // Handle the event when user click on the button to create new employee
    protected void btnAddEmployee_Click(object sender, EventArgs e)
    {

        // Validator Check
        bool firstNameBool = false,
             lastNameBool = false,
             payRateBool = false,
             startEndDateBool = false;

        // Check if the text input for first name is not empty
        if (Request["txtFirstName"].ToString().Trim() == "")
        {
            // Set a class to the input, change bg color for the input and display message
            txtFirstName.BackColor = System.Drawing.Color.Yellow;
            txtFirstName.CssClass = "form-control form-control-sm is-invalid";
            lblError.Text = "Please enter first name.";
        }
        else
        {
            // Send user to verification screen
            txtFirstName.BackColor = System.Drawing.Color.White;
            Session["txtFirstName"] = txtFirstName.Text;
            firstNameBool = true;
        }

        // Check if the text input for last name is not empty
        if (Request["txtLastName"].ToString().Trim() == "")
        {
            // Set a class to the input, change bg color for the input and display message
            txtLastName.BackColor = System.Drawing.Color.Yellow;
            txtLastName.CssClass = "form-control form-control-sm is-invalid";
            lblError.Text = "Please enter last name.";
        }
        else
        {
            // Send user to verification screen
            txtLastName.BackColor = System.Drawing.Color.White;
            Session["txtLastName"] = txtLastName.Text;
            lastNameBool = true;
        }

        // Check if the text input for pay rate is not empty
        if (Request["txtPayRate"].ToString().Trim() == "")
        {
            // Set a class to the input, change bg color for the input and display message
            txtPayRate.BackColor = System.Drawing.Color.Yellow;
            txtPayRate.CssClass = "form-control form-control-sm is-invalid";
            lblError.Text = "Please enter pay rate.";
        }
        else
        {
            // Send user to verification screen
            txtPayRate.BackColor = System.Drawing.Color.White;
            Session["txtPayRate"] = txtPayRate.Text;
            payRateBool = true;
        }

        // Manupulate date to convert them back to the strings
        DateTime startDate = DateTime.Parse(Request["txtStartDate"]);
        DateTime endDate = DateTime.Parse(Request["txtEndDate"]);

        if (DateTime.Compare(startDate, endDate) > 0)
        {
            // Set a class to the input, change bg color for the input and display message
            txtStartDate.BackColor = System.Drawing.Color.Yellow;
            txtStartDate.CssClass = "form-control form-control-sm is-invalid";
            txtEndDate.BackColor = System.Drawing.Color.Yellow;
            txtEndDate.CssClass = "form-control form-control-sm is-invalid";
            lblError.Text = "The end date must be greater than the start date.";
        }
        else
        {
            // Send user to verification screen
            txtStartDate.BackColor = System.Drawing.Color.White;
            txtEndDate.BackColor = System.Drawing.Color.White;
            Session["txtStartDate"] = txtStartDate.Text;
            Session["txtEndDate"] = txtEndDate.Text;
            startEndDateBool = true;
        }

        if(firstNameBool && lastNameBool && payRateBool && startEndDateBool)
        {
            // Set a session variables for all text boxes
            Response.Redirect("frmPersonnelVerified.aspx");
        }

    }
}