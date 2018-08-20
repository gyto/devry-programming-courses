<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmEditPersonnel.aspx.cs" Inherits="frmEditPersonnel" %>

<!DOCTYPE html>


<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>User Activity</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous" />
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="offset-lg-2 col-lg-8 col-12">
            <div class="card p-4 mt-3">
                <form id="form1" runat="server">
                    <div class="d-flex justify-content-center">
                       <asp:ImageButton ID="Image1" runat="server" ImageAlign="Middle" ImageUrl="~/Images/CIS407A_iLab_ACITLogo.jpg" CssClass="img-fluid" PostBackUrl="~/frmMain.aspx" />
                    </div>
                    <div class="d-flex justify-content-center">
                        <asp:Panel ID="Panel1" runat="server">
                            <div class="row">                               
                                <div class="col-12">
                                <asp:Label ID="Label1" runat="server" Text="Edit Personnel" CssClass="h2 d-block text-center w-100 mb-2"></asp:Label>
                                <div class="d-flex justify-content-center w-100">
                                    <asp:GridView ID="grdEditPersonnel" runat="server" CssClass="table table-bordered table-responsive-table" OnSelectedIndexChanged="grdEditPersonnel_SelectedIndexChanged" AutoGenerateColumns="False" DataKeyNames="ID" DataSourceID="SqlDataSource2">
                                        <Columns>
                                            <asp:BoundField DataField="ID" HeaderText="ID" InsertVisible="False" ReadOnly="True" SortExpression="ID" />
                                            <asp:BoundField DataField="FirstName" HeaderText="FirstName" SortExpression="FirstName" />
                                            <asp:BoundField DataField="LastName" HeaderText="LastName" SortExpression="LastName" />
                                            <asp:BoundField DataField="PayRate" HeaderText="PayRate" SortExpression="PayRate" />
                                            <asp:BoundField DataField="StartDate" HeaderText="StartDate" SortExpression="StartDate" />
                                            <asp:BoundField DataField="EndDate" HeaderText="EndDate" SortExpression="EndDate" />
                                            <asp:CommandField ShowEditButton="True" />
                                            <asp:CommandField ShowDeleteButton="True" />
                                        </Columns>
                                    </asp:GridView>
                                        <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:PayrollSystem_DBConnectionString %>" DeleteCommand="DELETE FROM [tblPersonnel] WHERE [ID] = ?" InsertCommand="INSERT INTO [tblPersonnel] ([ID], [FirstName], [LastName], [PayRate], [StartDate], [EndDate]) VALUES (?, ?, ?, ?, ?, ?)" ProviderName="<%$ ConnectionStrings:PayrollSystem_DBConnectionString.ProviderName %>" SelectCommand="SELECT * FROM [tblPersonnel]" UpdateCommand="UPDATE [tblPersonnel] SET [FirstName] = ?, [LastName] = ?, [PayRate] = ?, [StartDate] = ?, [EndDate] = ? WHERE [ID] = ?">
                                            <DeleteParameters>
                                                <asp:Parameter Name="ID" Type="Int32" />
                                            </DeleteParameters>
                                            <InsertParameters>
                                                <asp:Parameter Name="ID" Type="Int32" />
                                                <asp:Parameter Name="FirstName" Type="String" />
                                                <asp:Parameter Name="LastName" Type="String" />
                                                <asp:Parameter Name="PayRate" Type="Int32" />
                                                <asp:Parameter Name="StartDate" Type="DateTime" />
                                                <asp:Parameter Name="EndDate" Type="String" />
                                            </InsertParameters>
                                            <UpdateParameters>
                                                <asp:Parameter Name="FirstName" Type="String" />
                                                <asp:Parameter Name="LastName" Type="String" />
                                                <asp:Parameter Name="PayRate" Type="Int32" />
                                                <asp:Parameter Name="StartDate" Type="DateTime" />
                                                <asp:Parameter Name="EndDate" Type="String" />
                                                <asp:Parameter Name="ID" Type="Int32" />
                                            </UpdateParameters>
                                        </asp:SqlDataSource>
                                   
                                </div>
                                
                            </div>
                                </div>
                        </asp:Panel>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
    <script>
$( document ).ready(function() {
  $(".table-responsive-table").parent().addClass('table-responsive');
});
    </script>
</body>
</html>
