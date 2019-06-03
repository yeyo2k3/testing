<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.t1{
    font-family: cursive;
    font-size: 14px;    
}
</style>
</head>
<body>
	<s:form action="actionlistingProjects">
		<h1>Testing Project Locations</h1>
		<table>
			<tr>
				<td><s:select label="Location" headerKey="-1" cssClass="t1"
						headerValue="--- Select Project---" list="listofLocations"
						listKey="id" listValue="name" name="selectedLocation" /></td>
				<td><s:select label="Project" headerKey="-1" cssClass="t1"
						headerValue="--- Select Project---" list="listofProjects"
						listKey="id" listValue="project_title" name="selectedProject" />
				</td>
				<td><s:select label="Active?" cssClass="t1"
						 list="#{'1':'Yes', '0':'No'}"
						 name="selectedActive" /></td>
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
			<tbody class="t1">
				<s:iterator var="list_project_locations" value="projectLocationList">
					<tr>
						<td><s:property  value="id" /></td>
						<td><s:property value="project.getProject_title" /></td>
						<td><s:property value="location.name" /></td>
						<s:if test='%{active=="0"}'>
							<td>No</td>
						</s:if>
						<s:else>
   	 						<td>Yes</td>
						</s:else>
						<td><a href="actionClearProjects.action?idvalue=<s:property value="id"/>">
								Delete
							</a></td>
					</tr>
				</s:iterator>

			</tbody>

		</table>
	</s:form>
</body>
</html>