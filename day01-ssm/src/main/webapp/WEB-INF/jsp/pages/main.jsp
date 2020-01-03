<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: TangLei
  Date: 2019/12/16
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>员工信息</h1>
    <table border="1" cellpadding="5" cellspacing="0" width="80%">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>时间</th>
            <th>工资</th>
        </tr>
            <c:forEach items="${empList}" var="list">
               <tr>
                   <td>${list.eid}</td>
                   <td>${list.ename}</td>
                   <td>${list.esex}</td>
                   <td><fmt:formatDate value="${list.estartime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                   <td>${list.epay}</td>
               </tr>
            </c:forEach>

    </table>
</center>

</body>
</html>
