<%-- 
    Document   : Template
    Created on : Nov 3, 2020, 3:46:16 PM
    Author     : dilbd
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Template Page </title>
        <link rel='stylesheet' type='text/css' href='tempcss.css'>
        <style>
           * {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  padding: 10px;
  height: 600px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
        </style>
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
<h2>Two Equal Columns</h2>

<div class="row">
  <div class="column" style="background-color:#aaa;">
    <img src="Flowers.jpg" alt="${currentpainting.paintedDate}" width="40%">
    <p>Some text..</p>
  </div>
  <div class="column" style="background-color:#bbb;">
    <h2>Column 2</h2>
    <p>Some text..</p>
  </div>
</div>

    <%-- including footer --%>   
    <footer>            
        <c:import url="/Footer.jsp" />
    </footer>
</body>
</html>
