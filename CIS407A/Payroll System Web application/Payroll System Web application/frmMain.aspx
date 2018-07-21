<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmMain.aspx.cs" Inherits="frmMain" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Home Page</title>
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
                    <div class="d-flex justify-content-center">
                        <asp:Panel ID="Panel1" runat="server" Height="300px" Width="500px">
                            <div class="row">
                                <div class="col-6">
                                    <div class="card">
                                        <asp:ImageButton ID="imageCalculator" runat="server" ImageUrl="~/Images/calculator.jpg" CssClass="card-img-top" PostBackUrl="~/frmSalaryCalculator.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="LinkButton1" runat="server" PostBackUrl="~/frmSalaryCalculator.aspx" CssClass="btn btn-primary btn-block">Annual Salary Calculator</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="card">
                                        <asp:ImageButton ID="imageEmployee" runat="server" ImageUrl="~/Images/employee.jpg" CssClass="card-img-top" PostBackUrl="~/frmPersonnel.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="LinkButton2" runat="server" PostBackUrl="~/frmPersonnel.aspx" CssClass="btn btn-primary btn-block">Add New Employee</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </asp:Panel>    
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
