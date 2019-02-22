<%@ page language="java" import="java.util.*"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+
    request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查询商品信息</title>
<script src="<%=basePath%>js/jquery-1.11.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#searchType1").click(function(){
		$("#searchCondition").show();
	});
	$("#searchType2").click(function(){
		$("#searchCondition").hide();
	});
});

</script>
</head>
<body>
<from action="<%=basePath %>searchGoods" method="post">
请选择查询类型：<input type="radio" id="searchType1" name="searchType" value="按条件查询商品" checked="checked"/>按条件查询商品
<input type="radio" id="searchType2" name="searchType" value="查询所有商品"/>查询所有商品<br/>
<div id="searchCondition">
商品名称：<input type="search " id="name" name="name" placeholder="输入商品名称" /></br>
价格区间：<input type="number " id="number" name="minprice" placeholder="商品最低价" style="width:60px;"/>
--<input type="number " id="number" name="maxprice" placeholder="商品最高价" style="width:60px;"/><br/> 

</div>
<input type="submit" id="submit" value="查询">


</from>
<c:if test=" $ {not empty someGoods}">
<table border="1">
<tr>
<th>商品名称</th> 
<th>商品数量</th>
<th>商品价格</th>
<th>商品描述</th>
</tr>
<c:forEach items=" ${someGoods }" var="goods">
<tr>
<td>${goods.name}</td>
<td>${goods.number}</td>
<td>${goods.price }</td>
<td>${goods.depict }</td>
</tr>
</c:forEach>
</table>

</c:if>
</body>
</html>