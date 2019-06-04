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
	<s:form action="actionEditProjects">
		<table>
			<tbody>
				<tr>
					<td><s:textfield label="Project ID" name="project_id"></s:textfield>
					</td>
					<td><s:textarea label="Project Title" name="project_name"></s:textarea>
					</td>
				</tr>
				<tr>
					<td><s:submit value="Save" /> <s:submit
							action="actionClearEditProjects" value="Clear" /></td>
				</tr>
			</tbody>
		</table>
	</s:form>

</body>
</html>