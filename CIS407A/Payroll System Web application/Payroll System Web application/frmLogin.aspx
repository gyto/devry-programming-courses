<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmLogin.aspx.cs" Inherits="frmLogin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>User Activity</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous" />
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="offset-lg-2 col-lg-8 col-12">
            <div class="card p-4 mt-3">
                <form id="form1" runat="server">
                    <div class="d-flex justify-content-center">
                       <asp:ImageButton ID="Image1" runat="server" ImageAlign="Middle" ImageUrl="~/Images/CIS407A_iLab_ACITLogo.jpg" CssClass="img-fluid" />
                    </div>
                    <div class="d-flex justify-content-center">
                        <asp:Login ID="Login1" runat="server" DestinationPageUrl="~/frmMain.aspx" TitleText="Please enter your UserName and Password in order to log in to the system." LoginButtonStyle-CssClass="btn btn-primary btn-block" TextBoxStyle-CssClass="form-control" OnAuthenticate="Login1_Authenticate" PasswordLabelText="Password: " LoginButtonText="Log In" UserNameLabelText="User Name: " LabelStyle-CssClass="pr-3"></asp:Login>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
