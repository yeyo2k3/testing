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
</style>
</head>
<body>
	<h1>Edit project</h1>
	<s:form action="actionEditProjects">
		<table>
			<tbody>
				<tr>
					<td><s:textfield label="Project ID" name="project_id"></s:textfield>
					</td>
					<td><s:textarea label="Project Title" name="project_name" rows="2" cols="120"></s:textarea>
					</td>
				</tr>
				<tr>
					<td><s:submit value="Save" /> </td>
					<td><a href="initializeList.action">Exit</a></td>
				</tr>
			</tbody>
		</table>
	</s:form>

</body>
</html>