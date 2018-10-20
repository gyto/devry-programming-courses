<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/PA.master" CodeFile="SignUp.aspx.cs" Inherits="SignUp" %>
<%@ MasterType VirtualPath="~/PA.master" %>

<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1 class="text-center h3 mb-3">Login</h1>
    <div class="form-group row align-items-center">
        <asp:Label ID="lblUserID" CssClass="col-4 col-sm-3" runat="server" Text="User Name:"></asp:Label>
        <div class="col-8 col-sm-9">
            <asp:TextBox ID="txtUserID" runat="server" CssClass="form-control"></asp:TextBox>
        </div>
    </div>
    <div class="form-group row align-items-center">
        <asp:Label ID="lblPassword" CssClass="col-4 col-sm-3" runat="server" Text="Password:"></asp:Label>
        <div class="col-8 col-sm-9">
            <asp:TextBox ID="txtPassword" TextMode="Password" runat="server" CssClass="form-control"></asp:TextBox>
        </div>
    </div>
    <div class="d-flex justify-content-end">
        <asp:Button ID="btnCreateAccount" Text="Create Account" runat="server" CssClass="btn btn-secondary" OnClick="BtnCreateAccount_Click" />
        <asp:Button ID="btnLogin" Text="Login" runat="server" CssClass="btn btn-primary ml-2" OnClick="BtnLogin_Click" />
    </div>
</asp:Content>