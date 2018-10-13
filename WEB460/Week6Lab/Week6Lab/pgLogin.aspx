<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Web460Store.master" CodeFile="pgLogin.aspx.cs" Inherits="pgLogin" %>
<%@ MasterType VirtualPath="~/Web460Store.master" %>

<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
<!-- User Information -->
<div class="border rounded">
    <div class="bg-light p-2">
        <h3 class="mb-0">Login</h3>
    </div>
    <div class="p-2">
        <div class="form-group">
            <asp:Label ID="lblUserID" runat="server" Text="User ID:"></asp:Label>
            <asp:TextBox ID="txtUserID" runat="server" CssClass="form-control"></asp:TextBox>
        </div>
        <div class="form-group">
            <asp:Label ID="lblPassword" runat="server" Text="Password:"></asp:Label>
            <asp:TextBox ID="txtPassword" TextMode="Password" runat="server" CssClass="form-control"></asp:TextBox>
        </div>
        <div class="d-flex justify-content-end">
            <asp:Button ID="btnLogin" Text="Login" runat="server" CssClass="btn btn-primary" OnClick="BtnLogin_Click" />
        </div>
    </div>
</div>
</asp:Content>