<%@page contentType="text/html; charset=gb2312" language="java"
	errorPage=""%>
<%@page import="java.sql.*"%>
<%
	String url = "jdbc:mysql://localhost:3306/runoob";
	//����һ��runoob�����ݿ�
	String userName = "root";
	String password = "root";
	Connection conn = null;
	try {

		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		out.println("������������ʱ�����쳣");
	}
	try {
		conn = null;
		conn = DriverManager.getConnection(url, userName, password);
	} catch (SQLException e) {
		out.println("�������ݿ�Ĺ����г���SQL�쳣");
	}
	if (conn == null) {
		out.println("�������ݿ�ʧ��");
	} else {
		out.println("�������ݿ�ɹ�");
		try {
			conn.close();
		} catch (SQLException e) {
			out.println("�ر����ݿ�����ʱ����SQL�쳣");
		}
	}
%>
