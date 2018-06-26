<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>易理铺ESL管理系统</title>
    <style>* {
        font-family: Microsoft YaHei
    }</style>

    <link href="<c:url value="/static/css/bootstrap/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/Font-Awesome-master/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap/bootstrap-table.css"/>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <style>
        form {
            top: 100px;
        }

        input:focus {
            border-color: #E08031 !important;
        }

        #reset-submit {
            width: 50%;
            margin-top: 30px;
            background-color: #E08031;
            border: 0 !important;
            font-weight: bold;
        }

        #reset-submit:hover {
            background-color: #cc5d11;
        }

        #reset-submit:focus {
            outline-color: #E08031 !important;
        }

        input::-webkit-input-placeholder, input::-moz-placeholder {
            color: indianred;
        }

        label.empty:after {
            content: "*";
            color: red;
        }


    </style>
</head>

<body>

<div class='container'>
    <div class='row'>
        <form role="form" class='col-md-6 col-md-offset-3'>
            <div class='form-group'>
                <label id="password-label" for='password-in'>密码</label>
                <input id="password-in"
                       class='form-control'
                       type='password'
                       name='password'
                       autofocus='autofocus'
                       maxlength='20'/>
            </div>
            <div class='form-group'>
                <label id='re-password-label' for='re-password-in'>重复密码</label>
                <input id="re-password-in"
                       class='form-control'
                       type='password'
                       name='re-password'
                       maxlength='20'/>
            </div>
            <div id='reset-submit' class='btn btn-primary center-block'>重置密码</div>
        </form>
    </div>
</div>

<script>
    $("#reset-submit").click(function(){
        var password =  $("#password-in").val();
        var repassword = $("#re-password-in").val();
        if(repassword!=password||repassword==''){
            addOnce($("#re-password-in"), $("#re-password-label"));
            return;
        }
        if(password==''){
            addOnce($("#password-in"), $("#password-label"));
            return;
        }
        $.get("/service/user/resetPassword.do?password="+password, function(data){
            if(data=='success'){
                window.location.href = "/service/main";
            }
        })

    });

    function addOnce($element, $label){
        $label.addClass("empty");
        $element.one("keypress", function(){
            $label.removeClass("empty");
        }).focus();
    }
</script>

</body>
</html>