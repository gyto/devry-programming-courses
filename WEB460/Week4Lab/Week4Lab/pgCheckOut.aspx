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

<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- User Information -->
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

            <div>
                <asp:Label ID="lblGVDataBase" Text="Customers in Database:" cssClass="h4 mt-2 d-block" runat="server"></asp:Label>
                <div class="table-responsive">
                    <asp:GridView ID="gvCustomerList" Font-Size="12px" runat="server" CssClass="table table-hover table-bordered mb-0"></asp:GridView>
                </div>
            </div>
            <div>
                <asp:Label ID="lblGVXML" Text="Customers in XML File:" cssClass="h4 mt-2 d-block" runat="server"></asp:Label>
                <div class="table-responsive">
                    <asp:GridView ID="gvXML" Font-Size="12px" runat="server" CssClass="table table-hover table-bordered mb-0"></asp:GridView>
                </div>
            </div>
        </div>
    </div>
</asp:Content>

<asp:Content ID="ContentArea2" ContentPlaceHolderID="ContentPlaceHolder2" runat="server">
    <!-- Payment Method -->
    <div class="border rounded mt-3">
        <div class="bg-light p-2">
            <h3 class="mb-0">Payment Method</h3>
        </div>
        <div class="p-2">
            <asp:RadioButtonList ID="rblCCType" runat="server" CssClass="paymentSystem" OnSelectedIndexChanged="RblCCType_SelectedIndexChanged">
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

    <!-- Custemer Inforation -->
    <div class="border rounded mt-3">
        <div class="bg-light p-2">
            <h3 class="mb-0">Returning Customer</h3>
        </div>
        <div class="p-2">
            <strong><asp:Label ID="lblCustID" Text="Customer ID: " runat="server" /></strong><asp:Label ID="customerID" runat="server" />
            <asp:Button ID="btnFindLastName" Text="Find Last Name" CssClass="btn btn-info btn-block mt-2" runat="server" OnClick="BtnFindLastName_Click" />
            <div class="d-flex">
                <asp:Button ID="btnUpdateCustoemr" Text="Update Customer" CssClass="btn btn-dark btn-block mt-2 mr-2" runat="server" OnClick="BtnUpdateCustomer_Click" />
                <asp:Button ID="btnAddCustomer" Text="Insert Customer" CssClass="btn btn-dark btn-block mt-2 ml-2" runat="server" OnClick="BtnAddCustomer_Click" />
            </div>
        </div>
    </div>
    <div>
        <asp:Button ID="btnUpdateXML" Text="Update XML File" CssClass="btn btn-secondary btn-block mt-2" runat="server" OnClick="BtnUpdateXML_Click"></asp:Button>
    </div>
    <div class="d-flex">
        <asp:Button ID="btnClearForm" CssClass="btn btn-secondary btn-block mt-3 mr-2" Text="Clear Form" OnClick="BtnClearForm_Click" runat="server" />
        <asp:Button ID="btnSubmit" runat="server" Text="Submit" CssClass="btn btn-block btn-primary ml-2 mt-3" PostBackUrl="~/pgConfirm.aspx" OnClick="BtnSubmit_Click" />
    </div>
</asp:Content>