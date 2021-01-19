<%-- 
    Document   : PaintingCart
    Created on : Nov 3, 2020, 3:51:42 PM
    Author     : dilbd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Painting Cart </title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
        
         <%-- including logo --%>  
        <header>
            <%@include file="/Logo.html" %>
        </header>
        
        <%-- including havigation bar  --%>   
        <nav>
            <%@include file="/NavBar.html" %>
        </nav>  
        
        <article>
            
            <table border = "1">
            <%-- Viewing the properties of the painting in the table --%>  
                <c:choose>
                    <c:when test="${empty paintinglist or paintinglist.size == 0}">
                        <p>No Painting added yet.</p>
                    </c:when>
                    <c:otherwise>

                        <th>S.N </th>
                        <th>Name </th>
                        <th>Price </th>
                        <th>Remove </th>
                        
                            <c:forEach var="painting" items="${paintinglist.paintings}">
                            <tr>
                                <td>${painting.serialNumber}</td>
                                <td>${painting.name} </td>
                                <td>$${painting.price} </td>

                                <td>
                                    <form action="RemovePaintingServlet">
                                        <input type = "submit" value = "Remove Item"/>
                                        <input type = "hidden" name = "serialNumber"
                                               value = "${painting.serialNumber}"/>
                                        <input type = "hidden" name = "name" 
                                               value = "${painting.name}" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                            
                    </c:otherwise>
                </c:choose>
                            
            </table>
                <%-- Viewing the total items and total amount in cart --%>  
            </ br>
            <p><b> Total Items:</b> ${paintinglist.size} </p> </ br>
            <p><b> Total Price</b> $${paintinglist.getTotalPrice(paintinglist)} </p> </ br>

            <%-- Linked buttons to go back and forth--%>  
            <form action="AdditionalDetails.jsp">
                <input type="submit" value="Go Back : Details" />
            </form>
            </br>
            <form action="ViewPainting_Button.jsp">
                <input type="submit" value="Go Back : Painting List" />
            </form>

        </article>
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
    </body>
</html>

