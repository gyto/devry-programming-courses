<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/PA.master" CodeFile="AccountDetails.aspx.cs" Inherits="AccountDetails" %>
<%@ MasterType VirtualPath="~/PA.master" %>

<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1 class="h2 text-center">Howdy, GYTO</h1>

    <div class="form-group">
        <asp:Label Text="Username: " runat="server" />
        <asp:TextBox runat="server" Text="GYTO" ReadOnly="True" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <asp:Label Text="City: " runat="server" />
        <asp:TextBox runat="server" ID="txtCity" cssClass="form-control" />
    </div>
    <div class="form-group">
        <asp:Label Text="State: " runat="server" />
        <asp:TextBox runat="server" ID="txtState" cssClass="form-control" />
    </div>
    <div class="form-group">
        <asp:Label Text="FPL: " runat="server" />
        <asp:TextBox runat="server" ID="txtFPL" cssClass="form-control" />
    </div>
    <div class="form-group">
        <asp:Label Text="Least FPL: " runat="server" />
        <asp:TextBox runat="server" ID="txtLeastFPL" cssClass="form-control"/>
    </div>
    <div>
        <h2 class="text-center">An Applications Completed table</h2>
        <p>Comming soon</p>
    </div>
    <div>
        <asp:Button Text="Update Account Information " runat="server" CssClass="btn btn-primary btn-block" onClick="BtnUpdateInformation_Click"/>
    </div>
</asp:Content>