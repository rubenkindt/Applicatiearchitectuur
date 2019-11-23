<%-- 
    Document   : overzichtDocent
    Created on : 23-Nov-2019, 15:08:59
    Author     : ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>
            <c:forEach var = "i" items = "${sessionScope.alleReservaties}">
              begindatum: <c:out value="${i.getDatumres()}" />, voor <c:out value="Volo: ${i.getDagen()}" /> dagen
              </br>
            </c:forEach>
            
        </p>
    </body>
</html>
