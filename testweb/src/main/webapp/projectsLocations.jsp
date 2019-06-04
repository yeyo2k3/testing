<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: lightblue;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
}

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<s:form action="actionlistingProjects">
		<h1>Testing Project Locations</h1>
		<table>
			<tbody>
				<tr>
					<td><s:select label="Location" headerKey="-1"
							cssClass="customers" headerValue="--- Select Location---"
							list="listofLocations" listKey="id" listValue="name"
							name="selectedLocation" value="locationvalue" /></td>
					<td><s:select label="Project" headerKey="-1"
							cssClass="customers" headerValue="--- Select Project---"
							list="listofProjects" listKey="id" listValue="project_title"
							name="selectedProject" value="projectvalue" /></td>
					<td><s:select label="Active?" cssClass="customers"
							list="#{'1':'Yes', '0':'No'}" name="selectedActive"
							value="activevalue" /></td>
				</tr>
				<tr>
					<td><s:submit value="Save" /> <s:submit
							action="actionClearProjects" value="Clear" /></td>
				</tr>
				<tr>
					<td colspan="3"><s:actionmessage /></td>
				</tr>
			</tbody>
		</table>

		<table id="customers">
			<thead>
				<tr>
					<th>ID</th>
					<th>Project</th>
					<th>Location</th>
					<th>Location type</th>
					<th>Active?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator var="list_project_locations" value="projectLocationList">
					<tr>
						<td><a href="initializeEdit.action?idproject=<s:property value="project.getid"/>"><s:property value="id" /></a></td>
						<td><s:property value="project.getProject_title" /></td>
						<td><s:property value="location.name" /></td>
						<td><s:property value="location.loc_element_type.name" /></td>
						<s:if test='%{active=="0"}'>
							<td>No</td>
						</s:if>
						<s:else>
							<td>Yes</td>
						</s:else>
						<td><a
							href="actionDeleteProjects.action?idvalue=<s:property value="id"/>">
								Delete </a></td>
					</tr>
				</s:iterator>

			</tbody>

		</table>
	</s:form>
</body>
</html>