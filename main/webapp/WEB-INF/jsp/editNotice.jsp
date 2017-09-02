<%--
  Created by IntelliJ IDEA.
  User: Leafqun
  Date: 2017/4/19
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加内容</title>
    <style type="text/css" >
        .content{
            color: #262626;
            max-width: 70%;
            position: relative;
            margin:200px 20px 200px 400px;
        }
        .detail{
            margin:0 0 20px 0;
            width:100%;
        }
        .location{
            margin-left: 300px;
            width:100%;
        }
    </style>
    <script type="text/javascript">
        var filePath = $("input[name=cfile]").val();
        if("" != filePath){
            //获取附件大小（单位：KB）
            var fileSize = document.getElementById("file").files[0].size / 1024;
            if(fileSize > 55078532){
                alert("图片大小不能超过55MB");
             }
        }
    </script>
</head>
<body>
<div class="content">
    <label>添加内容：</label>
    <form action="../contents/updateContents.html" method="post" enctype="multipart/form-data">
        <input type="hidden" name="contentid" value="${contents.contentid}"/>
        <input type="hidden" name="userid" value="${contents.userid}"/>
        <input type="hidden" name="file" value="${contents.file}"/>
        <div class="detail">
            <textarea rows="10" cols="100" name="content">${contents.content}</textarea>
        </div>
        <div class="detail">
            <div><span>附件：<a href="../pic/${contents.file }" download="${contents.file }">${contents.file }</a></span><input type="file" name="cfile"/></div>
        </div>
        <div class="location">
            <button>提交</button>
        </div>
    </form>
</div>

</body>

</html>