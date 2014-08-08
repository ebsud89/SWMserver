<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.servlet.RequestDispatcher, java.io.*"%>

<%
	String resultStr = request.getAttribute("result").toString();
%>
<%
	out.print(resultStr);
%>