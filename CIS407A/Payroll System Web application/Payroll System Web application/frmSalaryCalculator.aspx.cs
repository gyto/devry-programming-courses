using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class frmSalaryCalculator : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btnCalculateSalary_Click(object sender, EventArgs e)
    {
        // initiate the items to be set to 0
        double annualHours = 0;
        double payRate = 0;
        double salary = 0;

        // read Annual Hours field and Pay Rate field
        annualHours = Double.Parse(txtAnnualHours.Text);
        payRate = Double.Parse(txtPayRate.Text);

        // multiply the annual hours and pay rate numbers
        salary = annualHours * payRate;

        // give a result and format it to currency
        lblAnnualSalary.Text = "Annual Salary is " + salary.ToString("C");
    }
}