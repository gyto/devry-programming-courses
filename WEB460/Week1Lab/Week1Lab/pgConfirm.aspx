<%@ Page Language="C#" AutoEventWireup="true" CodeFile="pgConfirm.aspx.cs" Inherits="pgConfirm" %>
<%@ PreviousPageType VirtualPath="~/pgCheckOut.aspx" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Confirm Checkout Page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous" />
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-6 offset-md-3">
                <form id="form1" runat="server">
                    <div class="bg-light p-2 mt-3 mb-2 border rounded">
                        <h3 class="mb-0">Order Confirmation</h3>
                    </div>
                    <div>
                        <strong>Name:</strong> <asp:Label ID="lblName" runat="server"></asp:Label><br />
                        <strong>Address:</strong> <asp:Label ID="lblAddress" runat="server" Text="Label"></asp:Label><br />
                        <strong>Phone:</strong> <asp:Label ID="lblPhone" runat="server" Text="Label"></asp:Label><br />
                        <strong>Credit Card Type:</strong> <asp:Label ID="lblCCType" runat="server" Text="Label"></asp:Label><br />
                        <strong>Credit Card Number:</strong> <asp:Label ID="lblCCNumber" runat="server" Text="Label"></asp:Label><br />
                    </div>
                    <asp:Label ID="lblStatus" runat="server" CssClass="d-block"></asp:Label>
                    <asp:Button ID="btnSubmit" runat="server" Text="Submit Order" CssClass="btn btn-primary mt-3" OnClick="btnSubmit_Click" />
                </form>
            </div>
        </div>
    </div>
</body>
</html>
