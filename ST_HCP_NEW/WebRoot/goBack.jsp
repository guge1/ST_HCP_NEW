<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>保存信息提示</title>
  </head>
  
  <body>
    <br>
    
    <script type="text/javascript">
      <%=
      request.getAttribute("message")
      %>
    
    </script>
     
  </body>
</html>