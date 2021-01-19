<%-- 
    Document   : AddPainting
    Created on : Nov 3, 2020, 3:53:02 PM
    Author     : dilbd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add</title>
        <link rel="stylesheet" type="text/css" href="template2.css" />
    </head>
    <body>
        <header id="example1">
            <br/>
            <br/><br/>
            <br/><br/>
        </header>
        <nav>
            <%@include file="/NavBar.html" %>
        </nav>
        <article>  
            <table border="1">
                <th>
                    Current Paintings
                </th>
                <c:forEach var="paintings" items="${paintingarray.paintings}">
                    <tr>
                        <td>

                            ${paintings.serialNumber} ${paintings.name}

                        </td>
                        <td>
                            <form action="AddPaintingServlet">
                                <input type="submit" value="Add Painting"/>                        
                                <input type="hidden" name="serialNumber" 
                                       value="${paintings.serialNumber}"/>
                                <input type="hidden" name="name" 
                                       value="${paintings.name}"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </article>   
        <footer>
            <c:import url="/Footer.jsp" />
        </footer>
    </body>
</html>