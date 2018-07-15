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
        double annualHours = 0;
        double payRate = 0;
        double salary = 0;

        annualHours = Double.Parse(txtAnnualHours.Text);
        payRate = Double.Parse(txtPayRate.Text);

        salary = annualHours * payRate;

        lblAnnualSalary.Text = "Annual Salary is " + salary.ToString("C");
    }
}