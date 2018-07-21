<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmSalaryCalculator.aspx.cs" Inherits="frmSalaryCalculator" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Annyal Salary Calculator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous" />
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="offset-2 col-8">
                <div class="card p-4 mt-3">
                    <form id="form1" runat="server">
                        <div class="d-flex justify-content-center">
                            <asp:ImageButton ID="Image1" runat="server" ImageAlign="Middle" ImageUrl="~/Images/CIS407A_iLab_ACITLogo.jpg" CssClass="img-fluid" PostBackUrl="~/frmMain.aspx" />
                        </div>
                        <div class="form-group row">
                            <asp:Label ID="lblAnnualHours" runat="server" Text="Annual Hours" CssClass="col-sm-4 col-form-label"></asp:Label>
                            <div class="col-sm-8">
                                <asp:TextBox ID="txtAnnualHours" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                        <div class="form-group row">
                            <asp:Label ID="lblPayRate" runat="server" Text="Rate" CssClass="col-sm-4 col-form-label"></asp:Label>
                            <div class="col-sm-8">
                                <asp:TextBox ID="txtPayRate" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                        <div class="d-flex justify-content-center">
                            <asp:Button ID="btnCalculateSalary" runat="server" Text="Calculate Salary" OnClick="btnCalculateSalary_Click" CssClass="mt-2 btn btn-primary" />
                        </div>
                        <div class="mt-5">
                            <h3>Result:</h3> <asp:Label ID="lblAnnualSalary" runat="server" Text="Annual Salary is"></asp:Label>
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>
