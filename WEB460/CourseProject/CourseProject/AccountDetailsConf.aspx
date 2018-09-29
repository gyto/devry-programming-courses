<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/PA.master" CodeFile="AccountDetailsConf.aspx.cs" Inherits="AccountDetailsConf" %>
<%@ MasterType VirtualPath="~/PA.master" %>

<asp:Content ContentPlaceHolderID="HeadPlaceHolder" runat="server">
    <style>
        .list-group-item strong { width: 30%; }
        .list-group-item { display: flex; }
    </style>
</asp:Content>

<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1 class="h2 text-center">User Account Confirmation</h1>
    <ul class="list-group">
        <li class="list-group-item"><strong>Username:</strong> gyto</li>
        <li class="list-group-item"><strong>City:</strong> <asp:Label runat="server" ID="lblCity" /></li>
        <li class="list-group-item"><strong>State:</strong> <asp:Label runat="server" ID="lblState" /></li>
        <li class="list-group-item"><strong>FPL:</strong> <asp:Label runat="server" ID="lblFPL" /></li>
        <li class="list-group-item"><strong>Least FPL:</strong> <asp:Label runat="server" ID="lblLeastFPL" /></li>
    </ul>
    <div class="d-flex mt-4">
        <asp:Button Text="Cancel" runat="server" CssClass="btn btn-danger btn-block mr-1" PostBackUrl="~/AccountDetails.aspx" />
        <asp:Button Text="Confirm" runat="server" CssClass="btn btn-primary btn-block mt-0 mr-1" Enabled="False" />
    </div>   
</asp:Content>
