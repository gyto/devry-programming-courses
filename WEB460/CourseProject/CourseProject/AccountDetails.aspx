<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/PA.master" CodeFile="AccountDetails.aspx.cs" Inherits="AccountDetails" %>
<%@ MasterType VirtualPath="~/PA.master" %>

<asp:Content ID="ContentArea1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="d-flex justify-content-end">
        <div class="form-inline">
            <asp:TextBox ID="txtFindUser" runat="server" CssClass="form-control" placeholder="Search for User" />
            <asp:Button Text="Find User" runat="server" CssClass="btn btn-primary ml-2" OnClick="BtnFindUser_Click" />
        </div>
    </div>
    <hr />


    <h1 class="h2 text-center mb-3 text-capitalize">Howdy, <asp:Label ID="lblWelcome" runat="server" Text="Stranger!"></asp:Label></h1>
    <div class="form-group row">
        <asp:Label Text="Username: " runat="server" CssClass="col-sm-3 col-form-label" />
        <div class="col-sm-9 input-group">
            <asp:TextBox ID="txtUser" runat="server" Text="Stranger" ReadOnly="True" cssClass="form-control"/>
            <div class="d-none" ID="userID" runat="server">
                <span class="input-group-text">ID:&nbsp;<asp:Label ID="lblUserID" Text="0" runat="server"></asp:Label></span>
            </div>
        </div>
    </div>
    <div class="form-group row">
        <asp:Label Text="City: " runat="server" CssClass="col-sm-3 col-form-label" />
        <div class="col-sm-9"><asp:TextBox runat="server" ID="txtCity" cssClass="form-control" /></div>
    </div>
    <div class="form-group row">
        <asp:Label Text="State: " runat="server" CssClass="col-sm-3 col-form-label" />
        <div class="col-sm-9"><asp:TextBox runat="server" ID="txtState" cssClass="form-control" /></div>
    </div>
    <div class="form-group row">
        <asp:Label Text="FPL: " runat="server" CssClass="col-sm-3 col-form-label" />
        <div class="col-sm-9"><asp:TextBox runat="server" ID="txtFPL" cssClass="form-control" /></div>
    </div>
    <div class="form-group row">
        <asp:Label Text="Least FPL: " runat="server" CssClass="col-sm-3 col-form-label" />
        <div class="col-sm-9"><asp:TextBox runat="server" ID="txtLeastFPL" cssClass="form-control"/></div>
    </div>
    <div>
        <h3 class="text-center">Completed Applications</h3>
        <div class="table-responsive">
            <asp:GridView ID="gvCourseList" Font-Size="12px" runat="server" CssClass="table table-hover table-bordered mb-0" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="ID" HeaderText="ID"/>
                    <asp:BoundField DataField="courseName" HeaderText="Name"/>
                    <asp:BoundField DataField="courseLanguage" HeaderText="Language"/>
                    <asp:BoundField DataField="courseDate" HeaderText="Date"/>
                </Columns>
            </asp:GridView>
            <asp:GridView ID="gvXML" runat="server" CssClass="d-none table table-hover table-bordered mb-0"></asp:GridView>
        </div>
    </div>
    <asp:Button Text="Export Stats" runat="server" ID="btnExportXML" CssClass="d-none" OnClick="BtnExportToXML_Click" />
    <div class="d-flex mt-2">
        <asp:Button Text="Delete Account" runat="server" ID="btnDelete" CssClass="d-none" OnClick="BtnDeleteAccount_Click" />
        <asp:Button Text="Update Account Information" ID="btnUpdateAccount" runat="server" CssClass="btn btn-primary btn-block mt-0" onClick="BtnUpdateInformation_Click"/>
        <asp:Button Text="Save Account Information" ID="btnSaveAccount" runat="server" CssClass="btn btn-success btn-block mt-0" onClick="BtnSaveInformation_Click"/>
    </div>
</asp:Content>