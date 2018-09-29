<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/PA.master" CodeFile="SignUp.aspx.cs" Inherits="SignUp" %>
<%@ MasterType VirtualPath="~/PA.master" %>

<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:Login ID="Login1" DestinationPageUrl="~/AccountDetails.aspx" runat="server"></asp:Login>
</asp:Content>