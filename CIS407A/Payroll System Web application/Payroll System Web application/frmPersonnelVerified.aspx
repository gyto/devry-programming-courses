<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmPersonnelVerified.aspx.cs" Inherits="frmPersonnelVerified" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Employee Added</title>
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
                            <asp:ImageButton ID="Image1" runat="server" ImageAlign="Middle" ImageUrl="~/Images/CIS407A_iLab_ACITLogo.jpg" CssClass="img-fluid" PostBackUrl="~/frmMain.aspx"/>
                        </div>
                        <div class="d-flex justify-content-center">
                            <asp:Panel ID="Panel1" runat="server" Height="250px" Width="650px">
                                <div class="form-group d-flex flex-column align-items-center">
                                    <asp:Label ID="informationToSubmit" runat="server" Text="Information to Submit" CssClass="h3"></asp:Label>
                                    <asp:TextBox ID="txtVerifiedInfo" runat="server" Height="80px" TextMode="MultiLine" Width="400px" CssClass="form-control"></asp:TextBox>
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
