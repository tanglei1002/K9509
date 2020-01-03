<%--
  Created by IntelliJ IDEA.
  User: TangLei
  Date: 2019/12/17
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>easyui</title>
 <%--   <script language="JavaScript" type="text/javascript" src="/js/jquery-1.12.4.js"></script>
    <script language="JavaScript" type="text/javascript">
        $(function(){
            $("#but").click(function(){
                //使用jquery的post发送异步请求
                //$.post("服务地址","给服务器的参数",回调用函数,"服务器返回类型");
                $.post("getemp",null,function(data){
                      var str ="<table border=2><tr><td>姓名</td><td>年龄</td><td>生日</td><td>工资</td></tr>";
                      for(var i=0; i<data.length;i++){
                          var s = data[i];
                          str=str+"<tr><td>"+s.ename+"</td><td>"+s.esex+"<td></td>"+s.estartime+"<td></td>"+s.pay+"</td></tr>"
                      }
                      str=str+"</tale>";
                      $("#show").html(str);
                },"json");
            });
        });--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/css/demo.css">
    <script src="js/jquery-1.12.4.js" type="text/javascript" language="javascript"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery-1.12.4.js" type="text/javascript" language="javascript"></script>
</head>
<body>
<div id="dv" ></div>
<a id="but"  class="easyui-linkbutton" data-options="iconCls:'icon-search'">点击</a>

</body>
    <script>
        $("#but").click(function(){
            //加载数据
            $('#dv').datagrid({
                url:'${pageContext.request.contextPath}/getemp',
                columns:[[
                    {field:'ename',title:'姓名',width:100,align:'right'},
                    {field:'esex',title:'性别',width:100,align:'right'},
                    {field:'estartime',title:'时间',width:100,align:'right'},
                    {field:'pay',title:'工资',width:100,align:'right'},
                ]]
            });
        });
    </script>
</html>
