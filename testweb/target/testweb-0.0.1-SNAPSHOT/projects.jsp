<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="actionlistingProjects">
		<h1>Testing Project.</h1>
		<table>
			<tr>				
				<td><s:select label="Location" headerKey="-1"
						headerValue="--- Select Project---" list="listofLocations"
						listKey="id" listValue="project_title" name="selectedProject" />
				</td>
				<td><s:select label="Project" headerKey="-1"
						headerValue="--- Select Project---" list="listofProjects"
						listKey="id" listValue="project_title" name="selectedProject" />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>