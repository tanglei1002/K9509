$(function(){
    //1.使用datagrid组件绑定数据
    $('#dg').datagrid({
        url:'getDistrictData',
        pagination:true,  //开启分页
        pageSize:3,  //初始化页大小
        pageList:[3,5,8,10,20],  //页大小选项
        toolbar:'#ToolBar',
        columns:[[
            {checkbox:true,width:100,align:'right'},
            {field:'id',title:'编号',width:100,align:'right'},
            {field:'name',title:'区域名称',width:100,align:'right'},
            {field: 'opt', title: '区域编辑', width: 100, align: 'right',
                formatter: function (value, row, index) {
                    //返回的内容就是呈现在单元格的内容
                    //value 表示当前字段的值， row当前行的值 index表示索引
                    return "<a href='#'>修改</a> <a href='javascript:delDistrict("+row.id+")'>删除</a>";
                }
            }
        ]]
    });
});

//打开添加窗口
function goAdd(){
    //打开对话框
    //$("#AddDialog").dialog("open");
    $("#AddDialog").dialog("open").dialog('setTitle',"添加区域");
}

//关闭窗口
function CloseDialog(){
    $("#AddDialog").dialog("close");
}


//保存添加的数据     异步添加
function SaveDialog() {
    //alert("多要保存信息，告诉我接口在哪，我去找他");
    //实现异步技术实现添加,借助ajax技术，
    //方法一:使用jquery发送异步请求
    //$.post("地址",参数，回调函数,"json")
    //将表单序列化参数数据
    /*      var param=$("#addDialogForm").serialize();
          //console.log(param);
           $.post("addDistrict",param,function(data){
               if(data.result>0){
                   //成功关闭窗口
                   $("#AddDialog").dialog("close");
               }else{
                   //alert("sss");
                   $.messager.alert('友情提示','添加失败，请联系管理员:13260601227!','info');

               }
           },"json");*/


    //借助easyui异步提交表单
    $('#addDialogForm').form('submit', {
        url: "addDistrict",
        success: function (data) {  //{"result":1}
            var obj = $.parseJSON(data);   //将json字符串转化为json对象
            if (obj.result > 0) {
                //成功关闭窗口
                $("#AddDialog").dialog("close");
            } else {
                //alert("sss");
                $.messager.alert('友情提示', '添加失败，请联系管理员:13260601227!', 'info');

            }

        }
    });

}

//去打开修改的窗口
function goUpdate(){
    //1.获取datagrid的选中行
    var selObjs=$("#dg").datagrid("getSelections");
    //2.验证是否选中一行
    if(selObjs.length==1){
        $("#upDialog").dialog("open").dialog('setTitle',"编辑区域");

        //还原表单数据  查询数据库，通过id获取单行记录的对象，进行回显？
        // $("#upDialogForm").form('load',json对象:{"表单对象名称":值});
        $("#upDialogForm").form('load',selObjs[0]);

    }else{
        $.messager.alert('友情提示','你可能没有选中行，或者选中多行，请选择一行修改，真他妈笨，选一行都不会','info');
    }
}

//删除区域   id是用于接收删除的编号
function delDistrict(id) {
    $.post("delDistrict",{"id":id},function (data) {
        if (data.result>0){
            $('#dg').datagrid('reload');
        }else {
            $.messager.alert('友情提示','删除失败，请联系管理员:13260601227!','info');

        }
    },"json");
}

//实现修改更新
function updateSaveDialog() {
    //使用easyui提交表单
    $('#upDialogForm').form('submit', {
        url: "updateDistrict",
        success: function (data) {  //{"result":1}
            var obj = $.parseJSON(data);   //将json字符串转化为json对象
            if (obj.result > 0) {
                //成功关闭窗口
                $("#upDialog").dialog("close");
            } else {
                //alert("sss");
                $.messager.alert('友情提示', '添加失败，请联系管理员:13260601227!', 'info');
            }
        }
    });
}
 //批量删除
function deleteMoreDirstrict(){
    //1.获取datagrid的选中行
    var selObjs=$("#dg").datagrid("getSelections");
    //判断有没有选中项
    if(selObjs.length>0) {
        //确认提示框
        $.messager.confirm('友情提示', '确定要删除吗?', function (r) {
            if (r) {  //r=true表示点击ok 否则点击取消
                //发送异步请求调用接口实现批量删除   ids=1,2,3,4
                //获取选中项的值id,拼接成:  值1,值2,值3
                var str="";
                for(var i=0;i<selObjs.length;i++){
                    str=str+selObjs[i].id+",";
                }
                str=str.substring(0,str.length-1);

                //发异步请求
                $.post("delMoreDistrict",{"ids":str},function(data){
                    if(data.result>0){
                        $('#dg').datagrid('reload');  //刷新datagrid
                    }
                    else{
                        $.messager.alert('友情提示','批量删除失败，请联系管理员:13260601227!','info');
                    }
                },"json");
            }
        });
    }else{
        $.messager.alert('友情提示','请至少选择一行进行删除?','info');
    }

}