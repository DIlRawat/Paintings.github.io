<%-- 
    Document   : AdditionalDetails
    Created on : Nov 3, 2020, 3:50:08 PM
    Author     : dilbd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Details </title>
        <link rel="stylesheet" type="text/css" href="template2.css" />
    </head>
    <body>
        <%-- including logo --%> 
        <header id="example1" >
            <br/>
            <br/><br/>
            <br/><br/>
        </header>

        <%-- including havigation bar  --%>   
        <nav>
            <%@include file="/NavBar.html" %>
        </nav>  

        <h2>Additional Details of the Painting</h2>

        <div class="row">
            <div class="column">
                <p> <strong>Serial Number: </strong> ${currentpainting.serialNumber} </p></ br>
                <p> <strong>Painting Name: </strong> ${currentpainting.name} </p></ br>
                <p> <strong>Description: </strong> ${currentpainting.description}  </p></ br>
                <p> <strong>Description: </strong> ${currentpainting.paintedDate}  </p></ br>
                <p> <strong>Price: </strong>$${currentpainting.price}  </p></ br>
                <p> <strong>Painting Type: </strong>${currentpainting.type}  </p></ br>

                <form action = "AddPaintingServlet">
                    <input type = "submit" value = "Add to Cart"/>
                    <input type = "hidden" name = "serialNumber"
                           value = "${currentpainting.serialNumber}"/>
                    <input type = "hidden" name = "name" 
                           value = "${currentpainting.name}" />
                </form>
                </br>
                <%-- linked button to go back to painting list  --%>   
                <form action="ViewPainting_Button.jsp">
                    <input type="submit" value="Go Back : Painting List" />
                </form>

            </div>
            <div class="column">
                <img src="${currentpainting.name}.jpg" alt="${currentpainting.paintedDate}" width="50%">

            </div>
        </div>

        <%-- including footer --%>   
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
    </body>
</html>