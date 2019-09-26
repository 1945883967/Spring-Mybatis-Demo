<%--
  Created by IntelliJ IDEA.
  User: minghai
  Date: 2019/9/25
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>文件上传</h3>
    <form action="/user/fileupload1" method="post" ectype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
