<%@ Page Language="C#" AutoEventWireup="true" CodeFile="frmSalaryCalculator.aspx.cs" Inherits="frmSalaryCalculator" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <div>
        <h1>Week 1: Annual Salary Calculator ASP.NET Web application</h1>
    </div>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="lblAnnualHours" runat="server" Text="Annual Hours"></asp:Label>
&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txtAnnualHours" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="lblPayRate" runat="server" Text="Rate"></asp:Label>
&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txtPayRate" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Button ID="btnCalculateSalary" runat="server" Text="Calculate Salary" OnClick="btnCalculateSalary_Click" />
            <br />
            <br />
            <br />
            <asp:Label ID="lblAnnualSalary" runat="server" Text="$"></asp:Label>
        </div>
    </form>
</body>
</html>
