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
//��ū ��ȣ�� ������ Ŭ���̾�Ʈ  ���� �� ����� ���� ����ϸ� �� �� �־��. �Ʒ� 5�� Ŭ���̾�Ʈ���� �� ����
 
PayLoad payLoad = new PayLoad();
payLoad.addAlert("hello kim, �ݰ���~!!");    // �������� ���� ���� �޼��� �����Դϴ�.
payLoad.addBadge(1);
payLoad.addSound("default");                  
  
PushNotificationManager pushManager = PushNotificationManager.getInstance();

pushManager.addDevice("iPhone", deviceToken);
  
//Connect to APNs
String host = "gateway.sandbox.push.apple.com";
int port = 2195;
String certificatePath = "/home/ebsud89/apns.p12";     // ���� ����2 4���� ������ �κ��̿���, �����س��� ��θ�+���ϸ�
String certificatePassword = "mackuru822";                                           // ���� ����2 1�� �κп� ������ �н����忡��
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