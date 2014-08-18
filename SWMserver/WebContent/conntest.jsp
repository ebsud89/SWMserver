<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.servlet.RequestDispatcher, java.io.*"%>

<%
	String resultStr = "{\"glossary\": {\"title\": \"example glossary\",\"GlossSee\": \"markup\"}}";
%>
<%
	out.print(resultStr);
%>