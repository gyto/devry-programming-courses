<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Web460Store.master" CodeFile="pgCheckOut.aspx.cs" Inherits="pgCheckOut" %>
<%@ MasterType VirtualPath="~/Web460Store.master" %>

<asp:Content ID="ContentHeader" ContentPlaceHolderID="HeadPlaceHolder" runat="server">
    <style>
        .paymentSystem {
            width: 100%;
        }
        .paymentSystem > tbody {
            display: flex;
        }
        .paymentSystem label {
            margin-left: 4px;
            margin-right: 20px;
            cursor: pointer;
        }
    </style>
</asp:Content>

<!-- User Information -->
<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="border rounded">
        <div class="bg-light p-2">
            <h3 class="mb-0">User Information</h3>
        </div>
        <div class="p-2">
            <div class="form-group">
                <asp:Label ID="Label1" runat="server" Text="First Name"></asp:Label>
                <asp:TextBox ID="txtFirstName" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <asp:Label ID="Label2" runat="server" Text="Last Name"></asp:Label>
                    <asp:TextBox ID="txtLastName" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <asp:Label ID="Label3" runat="server" Text="Address Line 1"></asp:Label>
                    <asp:TextBox ID="txtLine1" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <asp:Label ID="Label4" runat="server" Text="Address Line 2"></asp:Label>
                    <asp:TextBox ID="txtLine2" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="row">
                <div class="col-8">
                    <div class="form-group">
                        <asp:Label ID="Label5" runat="server" Text="City"></asp:Label>
                            <asp:TextBox ID="txtCity" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="col-4">
                    <div class="form-group">
                        <asp:Label ID="Label6" runat="server" Text="State"></asp:Label>
                        <asp:TextBox ID="txtState" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
            </div>
            <div class="form-group mb-0">
                <asp:Label ID="Label7" runat="server" Text="Phone Number"></asp:Label>
                <asp:TextBox ID="txtPhone" runat="server" CssClass="form-control" TextMode="Number"></asp:TextBox>
            </div>
        </div>
    </div>
</asp:Content>

<!-- Payment Method -->
<asp:Content ID="ContentArea2" ContentPlaceHolderID="ContentPlaceHolder2" runat="server">
    <div class="border rounded mt-3">
        <div class="bg-light p-2">
            <h3 class="mb-0">Payment Method</h3>
        </div>
        <div class="p-2">
            <asp:RadioButtonList ID="rblCCType" runat="server" CssClass="paymentSystem" OnSelectedIndexChanged="rblCCType_SelectedIndexChanged">
                <asp:ListItem> Visa</asp:ListItem>
                <asp:ListItem> Master Card</asp:ListItem>
                <asp:ListItem> Discover</asp:ListItem>
            </asp:RadioButtonList>
            <div class="form-group mb-0">
                <asp:Label ID="Label9" runat="server" Text="Credit Card Number"></asp:Label>
                <asp:TextBox ID="txtCCNumber" runat="server" CssClass="form-control" TextMode="Number"></asp:TextBox>
            </div>
        </div>
    </div>
    <asp:Button ID="btnSubmit" runat="server" Text="Submit" CssClass="btn btn-block btn-primary mt-3" PostBackUrl="~/pgConfirm.aspx" OnClick="btnSubmit_Click" />
</asp:Content>