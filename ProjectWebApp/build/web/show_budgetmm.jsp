<%@page import="java.util.Iterator"%>
<%@page import="model.BudgetMonth"%>
<%@page import="model.BudgetMothService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Budget Strategy </title>
    </head>
    <jsp:useBean id="data" class="model.BudgetMonth" scope="request"/>
    <%
                       
            List<BudgetMonth> dataList = BudgetMothService.getData((String)request.getAttribute("year"), (String)request.getAttribute("dept_id"));
            Iterator<BudgetMonth> itr = dataList.iterator();
            
     %>
    <body>
    <center>
        <h1>Budget Strategy List</h1>
        <table border="1">
          <tr>
            <th>Month</th>
            <th>Amount</th>
            <th>Year</th>
          </tr>
          <%
              
               while(itr.hasNext()) {
                   data = itr.next();
                   out.println("<tr>");
                   out.println("<td> "+ data.getMonth()+ "</td>");
                   out.println("<td> "+ data.getAmount() + "</td>");
                   out.println("<td> "+ data.getYear() + "</td>");
                   out.println("<tr>");
               }
          %>
    </table>
     <a href="index.html">Back to Menu</a>
    </center>
    </body>
</html>
