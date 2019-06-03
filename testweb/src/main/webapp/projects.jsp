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
						listKey="id" listValue="name" name="selectedLocation" /></td>
				<td><s:select label="Project" headerKey="-1"
						headerValue="--- Select Project---" list="listofProjects"
						listKey="id" listValue="project_title" name="selectedProject" />
				</td>
			</tr>
			<tr>
				<td><s:submit value="Save"/></td>
			</tr>
		</table>
		<table border="1" width="100%" cellpadding="2" cellspacing="1">
			<thead>
				<tr bgcolor="#320A92" style="color: white">
					<td>ID</td>
					<td>Project</td>
					<td>Location</td>
					<td>Active?</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator var="list_project_locations" value="projectLocationList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="project.getProject_title" /></td>
						<td><s:property value="location.name" /></td>
						<td><s:property value="active" /></td>
						<td><a href="actionClearProjects.action?delete=<s:property value="id"/>">
								Delete
							</a></td>
					</tr>
				</s:iterator>

			</tbody>

		</table>
	</s:form>
</body>
</html>