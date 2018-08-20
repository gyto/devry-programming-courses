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
        <div class="offset-lg-2 col-lg-8 col-12">
            <div class="card p-4 mt-3">
                <form id="form1" runat="server">
                    <div class="d-flex justify-content-center">
                       <asp:ImageButton ID="Image1" runat="server" ImageAlign="Middle" ImageUrl="~/Images/CIS407A_iLab_ACITLogo.jpg" CssClass="img-fluid"  />
                    </div>
                    <div class="d-flex justify-content-center">
                        <asp:Panel ID="Panel1" runat="server">
                            <div class="row">
                                <div class="col-12 col-md-6 col-xl-4" id="CalculatorBox" runat="server">
                                    <div class="card mb-2">
                                        <asp:ImageButton ID="imgbtnCalculator" runat="server" ImageUrl="~/Images/calculator.jpg" CssClass="card-img-top" PostBackUrl="~/frmSalaryCalculator.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="linkbtnCalculator" runat="server" PostBackUrl="~/frmSalaryCalculator.aspx" CssClass="btn btn-primary btn-block">Annual Salary Calculator</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6 col-xl-4" id="NewEmployeeBox" runat="server">
                                    <div class="card mb-2">
                                        <asp:ImageButton ID="imgbtnNewEmployee" runat="server" ImageUrl="~/Images/employee.jpg" CssClass="card-img-top" PostBackUrl="~/frmPersonnel.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="linkbtnNewEmployee" runat="server" PostBackUrl="~/frmPersonnel.aspx" CssClass="btn btn-primary btn-block">Add New Employee</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6 col-xl-4" id="ViewUserActivityBox" runat="server">
                                    <div class="card mb-2">
                                        <asp:ImageButton ID="imgbtnViewUserActivity" runat="server" ImageUrl="~/Images/user-activity.jpg" CssClass="card-img-top" PostBackUrl="~/frmUserActivity.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="linkbtnViewUserActivity" runat="server" PostBackUrl="~/frmUserActivity.aspx" CssClass="btn btn-primary btn-block">View User Activity</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6 col-xl-4" id="ViewPeronnelBox" runat="server">
                                    <div class="card mb-2">
                                        <asp:ImageButton ID="imgbtnViewPersonnel" runat="server" ImageUrl="~/Images/view-personnel.png" CssClass="card-img-top" PostBackUrl="~/frmViewPersonnel.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="linkbtnViewPersonnel" runat="server" PostBackUrl="~/frmViewPersonnel.aspx" CssClass="btn btn-primary btn-block">View Personnel</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6 col-xl-4" id="SearchBox" runat="server">
                                    <div class="card mb-2">
                                        <asp:ImageButton ID="imgbtnSearch" runat="server" ImageUrl="~/Images/search.png" CssClass="card-img-top" PostBackUrl="~/frmSearchPersonnel.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="linkbtnSearch" runat="server" PostBackUrl="~/frmSearchPersonnel.aspx" CssClass="btn btn-primary btn-block">Search Personnel</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6 col-xl-4" id="EditEmployeeBox" runat="server">
                                    <div class="card mb-2">
                                        <asp:ImageButton ID="imgbtnEditEmployees" runat="server" ImageUrl="~/Images/employee.jpg" CssClass="card-img-top" PostBackUrl="~/frmEditPersonnel.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="linkbtnEditEmployees" runat="server" PostBackUrl="~/frmEditPersonnel.aspx" CssClass="btn btn-primary btn-block">Edit Employee</asp:LinkButton>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6 col-xl-4" id="ManageUsersBox" runat="server">
                                    <div class="card mb-2">
                                        <asp:ImageButton ID="imgbtnManageUsers" runat="server" ImageUrl="~/Images/employee.jpg" CssClass="card-img-top" PostBackUrl="~/frmManageUsers.aspx" />
                                        <div class="card-body">
                                            <asp:LinkButton ID="linkbtnManageUsers" runat="server" PostBackUrl="~/frmManageUsers.aspx" CssClass="btn btn-primary btn-block">Manage Users</asp:LinkButton>
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
