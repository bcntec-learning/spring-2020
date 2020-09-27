<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Model Sample3 </title>
</head>
<body>

<%--@elvariable id="customer" type="course.spring.mvc.model.sample3.Customer"--%>
<h2>Customer Information</h2>
<table>
    <tr>
        <td>ID :</td>
        <td>${customer.id}</td>
    </tr>
    <tr>
        <td>Name :</td>
        <td>${customer.name}</td>
    </tr>
    <tr>
        <td>Email :</td>
        <td>${customer.email}</td>
    </tr>
</table>
</body>
</html>