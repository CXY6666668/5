<%@page import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!--    <%try {
				Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动，注册到驱动管理器
				String url = "jdbc:mysql://127.0.0.1:3306/runoob";//数据库连接字符串
				String usename = "root";
				String password = "root";
				Connection conn = DriverManager.getConnection(url, usename, password);//创建Connection连接
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select*from websites");
				if (conn != null) {
					System.out.println("数据库链接成功！");
				} else {
					System.out.println("数据库链接bu成功！");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>网站id</th>
			<th>网站名字</th>
			<th>网站链接</th>
			<th>网站</th>
			<th>出厂国家</th>
		</tr>
		<%
			String driverClass = "com.mysql.jdbc.Driver";

			String url = "jdbc:mysql://localhost:3306/runoob";

			String user = "root";

			String password = "root";

			Connection conn;

			try {

				Class.forName(driverClass);

				conn = DriverManager.getConnection(url, user, password);

				Statement stmt = conn.createStatement();

				String sql = "select * from websites";

				ResultSet rs = stmt.executeQuery(sql);

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

			}

			catch (Exception e) {

				e.printStackTrace();

			}
		%>

	</table>
</body>
</html>