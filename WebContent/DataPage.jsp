<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Data Page</title>
</head>
<body>


<%@page language="java" import="java.util.*" %>





<table border="1" width="303">
<tr>
<td width="119"><b>User ID</b></td>
<td width="168"><b>User Name</b></td>
</tr>
<%Iterator itr;%>
<% List data= (List)request.getAttribute("data");
for (itr=data.iterator(); itr.hasNext(); )
{
%>
<tr>
<td width="119"><%=itr.next()%></td>
<td width="168"><%=itr.next()%></td>
</tr>
<%}%>
</table>

</body>
</html>