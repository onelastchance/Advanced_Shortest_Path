<%@page import="process.Findresult"%>
<html>

<body>

The time on server is <%= new java.util.Date() %>

<br></br>

The source node is <%= request.getParameter("src") %>

<br></br>

The destination node is <%= request.getParameter("dest") %>

<br></br>

The distance between source node and destination node is <%= process.Findresult.gi(Integer.parseInt(request.getParameter("src")),Integer.parseInt(request.getParameter("dest"))) %>;

<br></br>

The time on server is <%= new java.util.Date() %>

<br></br>

</body>



</html>