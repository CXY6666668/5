<%@page import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加商品信息</title> 
</head>
<body>
<form action="<%=basePath%>admin/addGoodsDo.jsp" method="post">
商品名称：<input name="name" placeholder="请给出商品名称" required></br>
商品数量:<input name="number" placeholder="请给出商品数量" required type="number" min="0"></br>
商品价格：<input name="price" placeholder="请给出商品价格" type="number" min="0" required></br>
商品描述：<input name="depict" size="30"></br>
<input type="submit" value="添加">
<input type="reset" value="取消">
</form>
</body>
</html>