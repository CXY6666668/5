<%@ page language="java" import="java.util.*,java.sql.*"  pageEncoding="utf-8"%>
  <%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+
    request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加商品信息</title>
</head>
<body>
添加成功！</br>
<a href=" <%=basePath %> admin/addGoods.jsp">继续添加</a>
<a href=" <%=basePath %>admin/queryGoods.jsp ">查看商品</a>

</body>
</html>