<%-- 
    Document   : ViewPainting
    Created on : Nov 3, 2020, 3:44:29 PM
    Author     : dilbd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Template Page </title>
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
            <%-- Calling the servlet --%>   
            <c:if test="${empty paintingarray}">
            <c:redirect url="validateServlet"/>  
            </c:if>
            
            <%-- Viewing the properties of the painting in the table --%>    
            <h2>Viewing Painting</h2>
            <table border="1">
                
               <th>S.N</th>
               <th>Name</th>
               <th>Type</th>
               <th>Painted Date</th>
            <%-- using forEach loop to iterate through the entity items in the entity list and displaying all of the properties --%>   
                  <c:forEach var="showpainting" items="${paintingarray.paintings}">
                     <tr>
                        <td>${showpainting.serialNumber}</td> 
                        <td> ${showpainting.name} </td>
                        <td> ${showpainting.type} </td>
                        <td> ${showpainting.paintedDate} </td>
                         
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

