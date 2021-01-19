<%-- 
    Document   : Contact Us
    Created on : Dec 2, 2020, 4:45:47 PM
    Author     : dilbd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us </title>
        <link rel='stylesheet' type='text/css' href='template2.css'>
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
    <articel>
        <h2 style="text-align:center;"> Dil Rawat</h2>
        <p style="text-align:center;">dbrawat@student.ysu.edu</p>
        <p style="text-align:center;">Youngstown State University</p>
    </articel>

    <%-- including footer --%>   
    <footer>            
        <c:import url="/Footer.jsp" />
    </footer>
</body>
</html>