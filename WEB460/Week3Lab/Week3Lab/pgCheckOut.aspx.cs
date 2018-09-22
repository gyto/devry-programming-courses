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
    protected void RblCCType_SelectedIndexChanged(object sender, EventArgs e) {}
    protected void BtnSubmit_Click(object sender, EventArgs e) {}

    // On Click Find a Last Name in DB
    protected void BtnFindLastName_Click(object sender, EventArgs e)
    {
        // Connect to the dsAccount Object
        dsAccounts dsFindLastName;

        // Find a DB in the files
        string tempPath = Server.MapPath("~/App_Code/Accounts.mdb");
        clsDataLayer dataLayerObj = new clsDataLayer(tempPath);

        try
        {
            // Find a customer by Last Name
            dsFindLastName = dataLayerObj.FindCustomer(txtLastName.Text);

            // If the customer is exist then fill the records
            if (dsFindLastName.tblCustomers.Rows.Count > 0)
            {
                // Take a recods from the field and path trough the Text Inputs
                txtFirstName.Text = dsFindLastName.tblCustomers[0].FirstName;
                txtLastName.Text = dsFindLastName.tblCustomers[0].LastName;
                txtLine1.Text = dsFindLastName.tblCustomers[0].Address1;
                txtLine2.Text = dsFindLastName.tblCustomers[0].Address2;
                txtCity.Text = dsFindLastName.tblCustomers[0].City;
                txtState.Text = dsFindLastName.tblCustomers[0].State;
                txtPhone.Text = dsFindLastName.tblCustomers[0].PhoneNumber;
                customerID.Text = dsFindLastName.tblCustomers[0].CustomerID.ToString();

                Master.UserFeedback.Text = "Record Found";
                Master.UserFeedback.CssClass = "alert alert-success";
            }
            else
            {
                // Recocd Fails if user was not found
                Master.UserFeedback.Text = "No records were Found!";
                Master.UserFeedback.CssClass = "alert alert-danger";
            }
        }
        catch (Exception error)
        {
            string message = "Something went wrong - ";
            Master.UserFeedback.Text = message + error.Message;
        }
    }

    // On Click Update User Inforation
    protected void BtnUpdateCustomer_Click(object sender, EventArgs e)
    {
        // Set updated Customer error to false
        bool customerUpdateError = false;

        // Find a DB in the files
        string tempPath = Server.MapPath("~/App_Code/Accounts.mdb");
        clsDataLayer myDataLayer = new clsDataLayer(tempPath);

        // Update customer information
        try
        {
            myDataLayer.UpdateCustomer(
                txtFirstName.Text,
                txtLastName.Text,
                txtLine1.Text,
                txtLine2.Text,
                txtCity.Text,
                txtState.Text,
                txtPhone.Text,
                Convert.ToInt32(customerID.Text));
        }
        catch (Exception error)
        {
            // Throw error if it cannot be updated
            customerUpdateError = true;
            string message = "Error updating customer, please check form data.";
            Master.UserFeedback.Text = message + error.Message;
            Master.UserFeedback.CssClass = "alert alert-danger";
        }

        // If customer Update is true then let user give message
        if(!customerUpdateError)
        {
            ClearInputs(Page.Controls);
            customerID.Text = null;
            Master.UserFeedback.Text = "Customer Update Succesfully";
            Master.UserFeedback.CssClass = "alert alert-success";
        }
    }

    // On Click Create new User in DB
    protected void BtnAddCustomer_Click(object sender, EventArgs e)
    {
        // Set updated Customer error to false
        bool customerAddError = false;

        // Find a DB in the files
        string tempPath = Server.MapPath("~/App_Code/Accounts.mdb");
        clsDataLayer myDataLayer = new clsDataLayer(tempPath);

        // Add User information
        try
        {
            myDataLayer.InsertCustomer(
                txtFirstName.Text,
                txtLastName.Text,
                txtLine1.Text,
                txtLine2.Text,
                txtCity.Text,
                txtState.Text,
                txtPhone.Text);
        }
        catch (Exception error)
        {
            // Throw error if it cannot be created
            customerAddError = true;
            string message = "Error adding customer, please check form data. ";
            Master.UserFeedback.Text = message + error.Message;
            Master.UserFeedback.CssClass = "alert alert-danger";
        }

        // If customer Added is true then let user give message
        if (!customerAddError)
        {
            ClearInputs(Page.Controls);
            Master.UserFeedback.Text = "Customer Added Successfully";
            Master.UserFeedback.CssClass = "alert alert-success";
        }
    }

    // Private Clear Input Form
    private void ClearInputs(ControlCollection ctrls)
    {
        foreach (Control ctrl in ctrls)
        {
            if (ctrl is TextBox)
                ((TextBox)ctrl).Text = string.Empty;
            else if (ctrl is DropDownList)
                ((DropDownList)ctrl).ClearSelection();
            else if (ctrl is RadioButton)
                ((RadioButton)ctrl).Checked = false;
            else if (ctrl is RadioButtonList)
                ((RadioButtonList)ctrl).ClearSelection();
            else
                ClearInputs(ctrl.Controls);
        }
    }
    
    // Clear Button Form
    public void BtnClearForm_Click(object sender, EventArgs e)
    {
        ClearInputs(Page.Controls);
        customerID.Text = null;
    }

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