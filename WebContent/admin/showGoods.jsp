<%@page import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>显示商品信息</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>商品id</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>商品单价</th>
			<th>商品描述</th>
		</tr>
		<%
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/eshop";
			//创建一个runoob的数据库
			String username = "root";
			String password = "root";
			try {

				Class.forName("com.mysql.jdbc.Driver");
				//out.println("加载驱动器类时成功");
			} catch (ClassNotFoundException e) {
				out.println("加载驱动器类时出现异常");
			}
			//	try{
			//		Connection conn=DriverManager.getConnection(url,username,password);
			//	}catch(SQLException e){
			//		out.println("链接数据库的过程中出现SQL异常");
			//	}
			try {
				Connection conn = DriverManager.getConnection(url, username, password);

				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select * from goods");

				while (rs.next()) {
		%>
		<tr>

			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getString(5)%></td>

		</tr>
		<%
			}
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("連接失敗");
			}
		%>
	</table>
</body>
</html>