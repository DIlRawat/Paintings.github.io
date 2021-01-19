<%--
    Document   : ViewPainting_Button
    Created on : Nov 3, 2020, 3:45:31 PM
    Author     : dilbd
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Painting and detail Button </title>
        <link rel="stylesheet" type="text/css" href="template2.css" />

    </head>
    <body>
        <%-- including logo --%>   
        <header id="example1">
            <br/>
            <br/><br/>
            <br/><br/>
        </header>


        <%-- including havigation bar  --%>   
        <nav>
            <%@include file="/NavBar.html" %>
        </nav>   

        <article>
            <%-- Calling the servlet   --%> 
            <c:if test="${empty paintingarray}">
                <c:redirect url="validateServlet"/>  
            </c:if>

            <%-- Viewing the properties of the painting in the table --%>    
            <h2>Viewing Painting with detail button</h2>
            <table border="1">

                <th>S.N</th>
                <th>Painting Name</th>
                <th>Price</th>
                <th>Info</th>

                <%-- using forEach loop to iterate through the entity items in the entity list 
                     and adding a link button for additional details --%>   
                <c:forEach var="showpainting" items="${paintingarray.paintings}">
                    <tr>
                        <td>${showpainting.serialNumber}</td> 
                        <td> ${showpainting.name} </td>  
                        <td> $${showpainting.price} </td> 
                        <td>
                            <form action = "GeneratePaintingServlet">
                                <input type = "submit" value = "Details"/>
                                <input type = "hidden" name = "serialNumber"
                                       value = "${showpainting.serialNumber}"/>
                                <input type = "hidden" name = "name" 
                                       value = "${showpainting.name}" />
                            </form>

                        </td>
                    </tr>
                </c:forEach>
            </table>

        </article>
        <%-- including footer --%>   
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
    </body>
</html>
