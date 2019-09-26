<%--
  Created by IntelliJ IDEA.
  User: minghai
  Date: 2019/9/24
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>
    <a href="anno/testRequestParam">RequestParam</a><br/>
    <a href="anno/testRequestHeader">RequestHeader</a><br/>


    <%--@RequestBody--%>
    <form action="anno/testRequestBody" method="post">
        姓名：<input type="text" name="uname"><br/>
        年龄：<input type="text" name="age"><br/>
        生日：<input type="text" name="date"><br/>

        <input type="submit" value="提交">
    </form>
    <br/>

    <a href="anno/testPathVariable/10" >PathVariable</a><br/>

    <%--@ModelAttribute--%>
    <form action="anno/testModelAttribute" method="post">
        姓名：<input type="text" name="uname"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>
    <br/>

    <a href="anno/testSessionAttribute" >SessionAttribute</a><br/>
    <a href="anno/getSessionAttribute" >getSessionAttribute</a><br/>
    <a href="anno/delSessionAttribute" >delSessionAttribute</a><br/>

</body>
</html>
