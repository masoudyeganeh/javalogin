<%
    if(request.getSession(false) == null || request.getSession().getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
welcome <%
    request.getSession().getAttribute("username");
%>
<a href="/logout.do">logout</a>