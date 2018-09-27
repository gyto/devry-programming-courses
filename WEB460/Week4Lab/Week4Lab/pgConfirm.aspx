<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Web460Store.master" CodeFile="pgConfirm.aspx.cs" Inherits="pgConfirm" %>
<%@ PreviousPageType VirtualPath="~/pgCheckOut.aspx" %>
<%@ MasterType VirtualPath="~/Web460Store.master" %>


<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- Order Confirmation -->
    <div class="border rounded">
        <div class="bg-light p-2">
            <h3 class="mb-0">Order Confirmation</h3>
        </div>
        <div class="p-2">
            <ul class="list-group">
                <li class="list-group-item"><strong>Name:</strong> <asp:Label ID="lblName" runat="server"></asp:Label></li>
                <li class="list-group-item"><strong>Address:</strong> <asp:Label ID="lblAddress" runat="server" Text="Label"></asp:Label></li>
                <li class="list-group-item"><strong>Phone:</strong> <asp:Label ID="lblPhone" runat="server" Text="Label"></asp:Label></li>
            </ul>
        </div>
    </div> 
</asp:Content>


<asp:Content ID="ContentArea2" ContentPlaceHolderID="ContentPlaceHolder2" runat="server">
    <!-- Credit Card Information -->
    <div class="border rounded mt-2">
        <div class="p-2">
            <ul class="list-group">
                <li class="list-group-item"><strong>Credit Card Type:</strong> <asp:Label ID="lblCCType" runat="server" Text="Label"></asp:Label></li>
                <li class="list-group-item"><strong>Credit Card Number:</strong> <asp:Label ID="lblCCNumber" runat="server" Text="Label"></asp:Label></li>
            </ul>
        </div>
    </div>
    <div class="d-flex justify-content-end">
        <asp:Button ID="btnSubmit" runat="server" Text="Submit Order" CssClass="btn btn-primary mt-3 w-50" OnClick="BtnSubmit_Click" />
    </div>
</asp:Content>