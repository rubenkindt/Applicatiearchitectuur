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
        <title>Overzicht Docent</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>
            <c:forEach var = "i" items = "${sessionScope.alleMachines}">
               In <c:out value="${i.getLokaal()}" />, staat <c:out value="${i.getMnaam()}" /> met SerieNr: <c:out value="${i.getSerieNr()}" />.
              </br>
            </c:forEach>
        </p>
    </body>
</html>
