<%-- 
    Document   : CreatePainting
    Created on : Nov 26, 2020, 2:46:25 PM
    Author     : dilbd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Creating a new Painting </title>
        <link rel="stylesheet" type="text/css" href="template2.css" />
    </head>
    <body>
        <%-- Including header --%>
        <header id="example1">
            <br/>
            <br/><br/>
            <br/><br/>
        </header>
        <%-- Including navigation bar --%>
        <nav>
            <%@include file="/NavBar.html" %>
        </nav>    

        <article>
            <%-- form will redirect to the validatePaintingServelet --%>
            <form action="ValidatePaintingServlet">
                <%-- Creating a text field to enter serial number and providing feedback if the field left empty--%>
                S. N : <input type="text" name="serialNumber"
                              value="${param.serialNumber}"/>
                <c:if test="${errors.serialNumberMissing}">
                    Must give a serial number!
                </c:if>  
                <c:if test="${errors.serialNumberIllegal}">
                    Must start serial number either with 19 or 20: Ex: 2020-6
                </c:if> 

                <br /><br />
                <%-- Asing client to enter painting name and giving feedback if the text field letf empty --%>
                Painting name: <input type="text" name="name"
                                      value="${param.name}"/>
                <c:if test="${errors.nameMissing}">
                    Must give a painting name!
                </c:if>  
                <%-- Text field to enter the price and checking if the field is emply or the price is negative. --%>
                <br /><br />
                Price: <input type ="text" name="price"
                              value="${param.price}"/>
                <c:if test="${errors.priceMissing}">
                    Must enter a price!
                </c:if>

                <c:if test="${errors.priceZero}">
                    Price cannot be zero or less!
                </c:if>

                <c:if test="${errors.priceNotNumber}">
                    Price must be a number!
                </c:if>
                <%-- Text field for client to enter short description of the product. --%>
                <br /><br />
                Description:  <input type ="text" name ="description"
                                     value="${param.description}"/>
                <c:if test="${errors.descriptionMissing}">
                    Must enter description!
                </c:if>
                <br /><br />
                <%-- Text field to enter date the product made. --%>
                Painted Date:  <input type ="text" name ="date"
                                      value="${param.date}"/>
                <c:if test="${errors.dateMissing}">
                    Must enter painted date!
                </c:if>
                <br /><br />
                <%-- Select option for the type of painting the client will add  --%>
                Painting Type: <select name="type">
                    <option value="select">Select</option>
                    <c:forEach var="type" items="${paintingarray.types}">
                        <option value=${type} 
                                <c:if test="${param.type == type}">
                                    selected="true"
                                </c:if>
                                >
                            ${type}
                        </option>
                    </c:forEach>
                </select>
                <c:if test="${errors.typeMissing}">
                    Must select a painting type!
                </c:if>
                <%-- Submit Button --%>
                <br/> <br />  
                <input type="submit" value="CREATE Painting"/>    
            </form>
        </article>
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
    </body>
</html>
