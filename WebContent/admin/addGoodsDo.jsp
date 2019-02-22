<%@page import="com.lw.pj5.beans.Goods" %>
<%@page import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加商品信息</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="goods" class="com.lw.pj5.beans.Goods" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="goods"/>
您添加的商品信息：<br/>
商品名称：${goods.name }<br/>
商品数量：${goods.number}<br/> 
商品价格：${goods.price}<br/>
商品描述：${goods.depict}<br/>
<a href="<%=basePath%>admin/showGoods.jsp">填写正确，添加商品</a>
<a href="<%=basePath%>admin/addGoods.jsp">填写有误，返回</a>
</body>
</html>