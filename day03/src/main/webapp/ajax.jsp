<%--
  Created by IntelliJ IDEA.
  User: TangLei
  Date: 2019/12/19
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
</head>
<body>
<input type="button" id="but" value="加载员工数据">
<div id="show"></div>


<table id="dg"></table>
</body>
<script>
    $("#but").click(function(){
        $(function (){
            $('#dg').datagrid({
                url:'getEmp2',
                columns:[[
                    {field:'eid',title:'员工编号',width:100},
                    {field:'ename',title:'姓名',width:100},
                    {field:'esex',title:'性别',width:100},
                    {field:'estartime',title:'入职时间',width:100},
                    {field:'epay',title:'工资',width:100},
                    {field:'did',title:'部门编号',width:100}
                ]]
            });
        })
    });
</script>
</html>
