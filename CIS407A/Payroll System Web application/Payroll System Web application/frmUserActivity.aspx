<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmUserActivity.aspx.cs" Inherits="frmUserActivity" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>User Activity</title>
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
                       <asp:ImageButton ID="Image1" runat="server" ImageAlign="Middle" ImageUrl="~/Images/CIS407A_iLab_ACITLogo.jpg" CssClass="img-fluid" PostBackUrl="~/frmMain.aspx" />
                    </div>
                    <div class="d-flex justify-content-center">
                        <asp:Panel ID="Panel1" runat="server">
                            <div class="row">                               
                                
                                <asp:Label ID="Label1" runat="server" Text="User Activity" CssClass="h2 text-center w-100 mb-2"></asp:Label>
                                <div class="d-flex justify-content-center">
                                    <asp:GridView ID="grdUserActivity" runat="server" CssClass="table table-bordered"></asp:GridView>
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
