<%-- 
    Document   : About
    Created on : Dec 2, 2020, 4:42:31 PM
    Author     : dilbd
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About </title>
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
        <h2> Learning Web Development</h2>
    </articel>

    <%-- including footer --%>   
    <footer>            
        <c:import url="/Footer.jsp" />
    </footer>
</body>
</html>
