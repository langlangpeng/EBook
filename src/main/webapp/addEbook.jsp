<%--
  Created by IntelliJ IDEA.
  User: Mr.lang
  Date: 25/06/2022
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;}
    .tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
        overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
        font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg .tg-baqh{text-align:center;vertical-align:top}
    .tg .tg-c3ow{border-color:inherit;text-align:center;vertical-align:top}
    .tg .tg-0lax{text-align:left;vertical-align:top}
</style>
<script src="statics/js/jquery-1.9.1.min.js"></script>
<form id="form1" name="form1" method="post" action="goaddebook" >
    <table class="tg" style="width: 800px">
        <thead>
        <tr>
            <th class="tg-c3ow" colspan="2">增加电子图书</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="tg-c3ow" style="width: 300px">图书名称(*)</td>
            <td class="tg-c3ow"><input type="text" name="title" id="title"></td>
        </tr>
        <tr>
            <td class="tg-c3ow" style="width: 300px">图书摘要</td>
            <td class="tg-c3ow"><input type="text" name="summary" id="summary"></td>
        </tr>
        <tr>
            <td class="tg-c3ow" style="width: 300px">上传人</td>
            <td class="tg-c3ow"><input type="text" name="uploaduser" id="uploaduser"></td>
        </tr>
        <tr>

            <td class="tg-c3ow" style="width: 300px">上传时间(*)</td>
            <td class="tg-c3ow"><input type="date" name="createdate" id="createdate"></td>
        </tr>
        <tr>
            <td class="tg-c3ow" style="width: 300px">类型(*)</td>
            <td class="tg-c3ow">
                    <select name="categoryid" id="categoryid">
                        <option value="">--请选择--</option>
                    </select>
            </td>
        </tr>
        <tr>
            <td class="tg-c3ow" colspan="2"><button id="send" type="submit" class="btn btn-success">保存</button></td>
        </tr>
        </tbody>
    </table>
</form>
<script>
    $(function () {
    $.get("${pageContext.request.contextPath}/getCategoryByPid",null,function(data){
        for(var i=0;i<data.length;i++){
            var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            $("#categoryid").append(node);//追加一个下拉列表项
        }
    },"json");
});
</script>
</body>
</html>
