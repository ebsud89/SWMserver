 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Insert title here</title>
 </head>
 <body>
     <form method="POST" enctype="multipart/form-data" action="Uploader">
         종류: <input type="text" name="type"><br> 
         이름: <input type="text" name="name"><br>
         <input type="file" name="uploadFile"><br>
         <input type="submit" value="파일 올리기"><br>
     </form>
 </body>
 </html>