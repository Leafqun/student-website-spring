<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>门生测试</title>
    <script type="application/javascript" src="js/jquery-1.9.0.min.js?randomId=<%=Math.random()%>" ></script>
    <script src="js/vue.js" type="application/javascript"></script>
    <script src="js/vue-router.js"></script>

</head>
<body>
<h3>首页通知</h3>
<a href="edit_notice.html">添加通知</a>
<div id='content'>
    <table>
        <tr>
            <td>noticeName</td>
            <td>noticeTime</td>
        </tr>
        <tr v-for="notice in noticeList">
            <td><a :href="'../Student_Website/notice.html?noticeId='+notice.noticeId">{{notice.noticeName}}</a></td>
            <td>{{notice.noticeTime|time}}</td>
        </tr>
    </table>
</div>
</body>
<script type="application/javascript">
    var vm=new Vue({
        el:'#content',
        data:{
            noticeList:""
        }
    });
    $.ajax({
        type: "get",
        url: "http://119.23.22.99:8080/Student_Website/notice/getHeadNotice.do",
        data: "pageNum=1",
        success: function (result) {
            var jsd= $.parseJSON(result);
            vm.noticeList=jsd.noticeList;
        }
    });
    Vue.filter('time',
        <!-- value 格式为13位unix时间戳 -->
        <!-- 10位unix时间戳可通过value*1000转换为13位格式 -->
        function(value) {
            var date = new Date(value);
            Y = date.getFullYear(),
                m = date.getMonth() + 1,
                d = date.getDate(),
                H = date.getHours(),
                i = date.getMinutes(),
                s = date.getSeconds();
            if (m < 10) {
                m = '0' + m;
            }
            if (d < 10) {
                d = '0' + d;
            }
            if (H < 10) {
                H = '0' + H;
            }
            if (i < 10) {
                i = '0' + i;
            }
            if (s < 10) {
                s = '0' + s;
            }
            <!-- 获取时间格式 2017-01-03 10:13:48 -->
            var t = Y+'-'+m+'-'+d+' '+H+':'+i+':'+s;
            <!-- 获取时间格式 2017-01-03 -->
            <!--var t = Y + '-' + m + '-' + d;-->
            return t;
        });
</script>
</html>
