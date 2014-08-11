 <%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
 
<%@ page import="javapns.back.PushNotificationManager" %>    
<%@ page import="javapns.back.SSLConnectionHelper" %>    
<%@ page import="javapns.data.Device" %>    
<%@ page import="javapns.data.PayLoad" %>    
<%@ page import="java.lang.Object" %>    
<%@ page import="org.apache.commons.lang.StringUtils" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
 
System.out.println( "start~~!!!" );
 
 
String deviceToken = "7d80065bac96219eab021c2713a4e0d05342c05f0fe9499260207c5340fb11b5";   
//토큰 번호는 아이폰 클라이언트  구현 후 디버그 모드로 출력하면 알 수 있어요. 아래 5번 클라이언트구현 글 참고
 
PayLoad payLoad = new PayLoad();
payLoad.addAlert("hello kim, 반가워~!!");    // 아이폰에 통지 보낼 메세지 내용입니다.
payLoad.addBadge(1);
payLoad.addSound("default");                  
  
PushNotificationManager pushManager = PushNotificationManager.getInstance();

pushManager.addDevice("iPhone", deviceToken);
  
//Connect to APNs
String host = "gateway.sandbox.push.apple.com";
int port = 2195;
String certificatePath = "/home/ebsud89/apns.p12";     // 위에 가정2 4번에 설명한 부분이에요, 복사해놓은 경로명+파일명
String certificatePassword = "mackuru822";                                           // 위에 가정2 1번 부분에 설명한 패스워드에요
pushManager.initializeConnection(host, port, certificatePath, certificatePassword, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
 
//Send Push
Device client = pushManager.getDevice("iPhone");
pushManager.sendNotification(client, payLoad);
pushManager.stopConnection();
pushManager.removeDevice("iPhone");

%>
please wait ...!

</body>
</html>