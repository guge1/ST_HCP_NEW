<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Users list</title>
    <style type="text/css">
    	table {
			border-collapse: collapse;
		}
    </style>
  </head>
  
  <body>
  	<br /><br /><br /><br />
    <table border="1" width="50%" align="center">
    	<tr bgcolor="#cccc00">
    		<td align="center">UserId</td>
    		<td align="center">UserName</td>
    		<td align="center">Password</td>
    		<td colspan="2" align="center">Options</td>
    	</tr>
    	<s:iterator value="%{#request.list}" var="user">
    	<tr>
    		<td align="center"><s:property value="#user.id" /></td>
    		<td align="center"><s:property value="#user.username" /></td>
    		<td align="center">&nbsp;<s:property value="#user.password" /></td>
    		<td align="center"><a href="update.action?id=<s:property value='#user.id' />&action=loading" >update</a></td>
    		<td align="center"><a href="delete.action?id=<s:property value='#user.id' />" >delete</a></td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>