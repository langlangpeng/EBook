<%--
  Created by IntelliJ IDEA.
  User: Mr.lang
  Date: 25/06/2022
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="statics/js/jquery-1.9.1.min.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>

<style type="text/css">
    .tg  {border-collapse:collapse;border-color:#bbb;border-spacing:0;}
    .tg td{background-color:#E0FFEB;border-color:#bbb;border-style:solid;border-width:1px;color:#594F4F;
        font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg th{background-color:#9DE0AD;border-color:#bbb;border-style:solid;border-width:1px;color:#493F3F;
        font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg .tg-996f{background-color:#C2FFD6;border-color:inherit;text-align:center;vertical-align:top}
    .tg .tg-c3ow{border-color:inherit;text-align:center;vertical-align:top}
</style>

<form action="${pageContext.request.contextPath}/searchEbook">
    <input type="hidden" name="page" id="setPage" value="${pageInfo.pageNum}">
    <center>
        <table style="width: 1000px">
            <tr>
                <th colspan="1">
                    <div>
                        <select name="categoryid" id="categoryid">
                            <option value="">--请选择--</option>
                        </select>
                        <button type="submit" class="btn btn-primary"> 查&nbsp;&nbsp;询</button>
                    </div>
                </th>
                <th colspan="1">
                    <div>
<%--                        <input type="button" href="addEbook.jsp" value="新增电子图书">--%>
                        <a href="${pageContext.request.contextPath}/addEbook.jsp">新增电子图书</a>
                    </div>
                </th>
            </tr>
        </table>
        <table class="tg" style="width: 1000px">
            <thead>
            <tr>
                <th class="tg-c3ow" colspan="12" ><span style="font-weight:bold">电子图书列表</span></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="tg-996f" colspan="2">图书编号</td>
                <td class="tg-996f" colspan="2">图书名称</td>
                <td class="tg-996f" colspan="2">图书摘要</td>
                <td class="tg-996f" colspan="2">上传人</td>
                <td class="tg-996f" colspan="2">上传时间</td>
                <td class="tg-996f" colspan="2">操作</td>
            </tr>
            <c:forEach var="ebook" items="${pageInfo.list}">
                <tr>
                    <td class="tg-996f" colspan="2">${ebook.id}</td>
                    <td class="tg-996f" colspan="2">${ebook.title}</td>
                    <td class="tg-996f" colspan="2">${ebook.summary}</td>
                    <td class="tg-996f" colspan="2">${ebook.uploaduser}</td>
                    <td class="tg-996f" colspan="2">${ebook.createdate}</td>
                    <td class="tg-996f" colspan="2"><a href="javascript:location.href='${pageContext.request.contextPath}/editebook?id=${ebook.id}';" class="deleteApp" data-toggle="tooltip" data-placement="top" title="" >修改</a>/<a href="javascript:if (confirm('是否删除？')) location.href='${pageContext.request.contextPath}/deleteebook?id=${ebook.id}';" class="deleteApp" data-toggle="tooltip" data-placement="top" title="" >删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>每页${pageInfo.pageSize}条,当前是第${pageInfo.pageNum}页,共${pageInfo.pages}页,共${pageInfo.total}条记录</div>
        <div><a href="getPageEbookEntryByPage?pageNum=1">首页</a>&nbsp;
            <c:if test="${pageInfo.prePage!=0}"><a href="getPageEbookEntryByPage?pageNum=${pageInfo.prePage}">上一页</a>&nbsp;</c:if>
            <c:if test="${pageInfo.nextPage!=0}"><a href="getPageEbookEntryByPage?pageNum=${pageInfo.nextPage}">下一页</a>&nbsp;</c:if>
            <a href="getPageEbookEntryByPage?pageNum=${pageInfo.lastPage}">尾页</a></div>
    </center>
</form>
</body>
<script type="text/javascript">
    $(function () {
        $.get("${pageContext.request.contextPath }/getCategoryByPid",null,function(data){
            for(var i=0;i<data.length;i++){
                //使用工厂函数创建一个option
                var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                //将节点添加到下拉列表
                $("#categoryid").append(node);//追加一个下拉列表项
            }
            //设置选中项回显
            $("#categoryid").val(${condition.categoryid});
        },"json");

});
    function page_nav(pageNum) {
        $("#setPage").val(pageNum);
        $("#form1").submit();
    }
</script>
</html>