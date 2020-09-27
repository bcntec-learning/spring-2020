<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Model Sample2</title>
</head>
<body>

<%--@elvariable id="employee" type="course.spring.mvc.model.sample2.Employee"--%>
<h2>Employee Information</h2>
<table>
    <tr>
        <td>ID :</td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>Name :</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Email :</td>
        <td>${employee.email}</td>
    </tr>
</table>
</body>
</html>