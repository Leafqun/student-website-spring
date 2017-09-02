/**
 * Created by Leafqun on 2017/4/18.
 */
$(document).ready(function(){
    $("#log").click(function(){
        $("#register").hide();
        $("#login").show();
        $('#regUserCheck').html("");
        $('#regpwdCheck').html("");
        $('#regpwd2Check').html("");
        $("input#regName").val("");
        $("input#pwd1").val("");
        $("input#pwd2").val("");
    });
    $("#reg").click(function(){
        $("#register").show();
        $("#login").hide();
        $("#userCheck").html("");
        $("#pwdCheck").html("");
        $("input#logname").val("");
        $("input#password").val("");
    });
    var login=false;
    $("input#logname").blur(function(){
        var username=$("input#logname").val();
    	if(username==""){
    		$("#userCheck").html("<img src='img/publish_r.png'/>用户名不能为空！！！");
    		login=false;
    		return false;
    	}
    	if(username.length>10||username.length<3){
    		$("#userCheck").html("<img src='img/publish_r.png'/>用户名必须为4-10位！！！");
    		login=false;
            return false;
    	}
        $.ajax({
            type:"get",
            url:"../loginCheck.do",
            data:"userName="+username,
            success:function(data){
                var rs=$.parseJSON(data);
                if(rs.msg=="用户不存在"){
                    $("#userCheck").html("<img src='img/publish_r.png'/>用户不存在！！！");
                    login=false;
                }else{
                    $("#userCheck").html("<img src='img/page_white_edit.png'/>");
                    login=true;
                }
            }
        });
    });
    $("#loginButton").click(function(){
    	if(login){
            var username=$("input#logname").val();
            var password=$("input#password").val();
    		$.ajax({
    			type:"get",
    			url:"../loginCheck.do",
    			data:"userName="+username+"&userPwd="+password,
    			success:function(data){
    				var rs=$.parseJSON(data);
    				if(rs.msg=="success"){
                        $(location).attr('href', 'index.jsp');
    				}else if(rs.msg=="密码错误"){
    					$("#pwdCheck").html("<img src='img/publish_r.png'/>"+rs.msg);
    				}else{
                        $("#userCheck").html("<img src='img/publish_r.png'/>用户不存在！！！");
                    }
    			}
    		});
    	}
    });
    var loguser=false;
    var logpwd1=false;
    var logpwd2=false;
    var regname=$('input#regName');
    regname.blur(function(){
        if(regname.val().length<3||regname.val().length>10){
            $('#regUserCheck').html("<img src='img/publish_r.png'/>用户名必须为3到10位");
            loguser=false;
            return false;
        }
       $.ajax({
            type:'get',
            url:'../registerCheck.do',
            data:'userName='+regname.val(),
            success:function (result) {
            	var reg=$.parseJSON(result);
            	if(reg.msg=="用户名可用"){
            		$('#regUserCheck').html("<img src='img/page_white_edit.png'/>");
            		loguser=true;
            	}else{
            		$('#regUserCheck').html("<img src='img/publish_r.png'/>"+reg.msg);
            		loguser=false;
            	}
                
            }
        });
    });
    var regpwd1=$('input#pwd1');
    var regpwd2=$('input#pwd2');
    regpwd1.blur(function(){
        if(regpwd1.val().length<3||regpwd1.val().length>10){
        	$('#regpwdCheck').html("<img src='img/publish_r.png'/>密码为4-9位");
        	logpwd1=false;
        }else{
        	$('#regpwdCheck').html("<img src='img/page_white_edit.png'/>");
        	logpwd1=true;
        }
    });
    regpwd2.blur(function () {
        if(regpwd1.val()==regpwd2.val()&&logpwd1){
            logpwd2=true;
            $('#regpwd2Check').html("<img src='img/page_white_edit.png'/>");
        }else{
        	logpwd2=false;
            $('#regpwd2Check').html("<img src='img/publish_r.png'/>两次密码不一致");
            
        }
    });
    $("#regButton").click(function(){
        if(loguser&&logpwd2) {
            $.ajax({
                type:'get',
                url:'../registerCheck.do',
                data:'userName='+regname.val()+'&userPwd='+regpwd2.val(),
                success:function (result) {
                    var reg=$.parseJSON(result);
                    if(reg.msg=="success") {
                        $(location).attr('href', '../login.html');
                    }
                }
            });
        }
    });
});
