<%--
  Created by IntelliJ IDEA.
  User: 1802
  Date: 2020/10/30
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.time.LocalDateTime" %>


<html>
<head>
    <title>Hello World --JSP</title>
</head>
<body>
    <%-- JSP Comment --%>
    <h1>Hello World!</h1>
    <p>
        <%
            out.println("Your IP address is ");
        %>
        <span style="color:red">
            <%=request.getRemoteAddr()%>
        </span>

        <span>
            <%
                out.println("locate time is " + LocalDateTime.now().toString());
            %>
        </span>
    </p>
</body>
</html>
