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
    <style>
        * {
            font-family: Microsoft YaHei
        }
    </style>

    <link href="<c:url value="/static/css/bootstrap/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/Font-Awesome-master/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap/bootstrap-table.css"/>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <style>
        body {
            background: url("${pageContext.request.contextPath}/static/src/lightpaperFibers.png") repeat;
        }

        form {
            top: 100px;
        }

        .btn {
            margin-top: 30px;
            background-color: #cc5d11;
            border: 0 !important;
            font-size: 12px;
            letter-spacing: 3px;
        }

        .btn:hover {
            background-color: #B3500F;
        }

        .btn:focus {
            outline-color: #cc5d11 !important;
        }

        label.empty:after {
            content: "*";
            color: red;
        }

        label {
            letter-spacing: 1px;
        }

        input {
            background-color: rgba(0, 0, 0, 0) !important;
            color: black;
            letter-spacing: 1px;
            border: 1px solid #555
        }

        input:focus {
            border-color: #E08031 !important;
        }

        input::-webkit-input-placeholder, input::-moz-placeholder {
            color: indianred;
        }


    </style>
</head>

<body>

<div class='container'>
    <div class='row'>
        <form role="form" class='col-md-6 col-md-offset-3'>
            <div class='form-group'>
                <label id="email-label" for='email-in'>邮箱</label>
                <%--<label id="email-label" for='email-in'>email</label>--%>
                <input id="email-in"
                       class='form-control'
                       type='text'
                       name='email'
                       autofocus='autofocus'
                       maxlength='20'/>
            </div>
            <div class='form-group'>
                <label id='password-label' for='password-in'>密码</label>
                <%--<label id='password-label' for='password-in'>password</label>--%>
                <input id="password-in"
                       class='form-control'
                       type='password'
                       name='password'
                       maxlength='20'/>
            </div>
            <%--<div id='login-submit' class='btn btn-primary col-xs-3 col-xs-offset-2'>Login</div>--%>
            <%--<div id='login-forget' class='btn btn-primary col-xs-3 col-xs-offset-2'>Forget password</div>--%>
            <div id='login-submit' class='btn btn-primary col-xs-3 col-xs-offset-2'>登陆</div>
            <div id='login-forget' class='btn btn-primary col-xs-3 col-xs-offset-2'>忘记密码</div>
        </form>
    </div>
</div>

<script>
    function addFunctions() {
        $('body').keypress(function (event) {
            if (event.keyCode == 13) {
                $('#login-submit').click();
            }
        })

        $('#login-submit').click(function () {
            var email = $('#email-in').val();
            var password = $('#password-in').val();
            if (email == null || email.length == 0) {
                $('#email-label').addClass('empty');
                $('#email-in')[0].focus();
            } else if (password == null || password.length == 0) {
                $('#password-label').addClass('empty');
                $('#password-in')[0].focus();
            } else {
                var obj = new Object();
                obj.password = password;
                obj.email = email;
                $.post("hospital/login.do", obj, function (data) {
                    if (data == 'success') {
                        alert("hello world");
                        return;
                        window.location.href = "main";
                    } else if (data == '{}') {
                        var buff = '<div class="alert alert-warning">\n' +
                            '        <a href="#" class="close" data-dismiss="alert">\n' +
                            '            &times;\n' +
                            '        </a>\n' +
                            '        <h4><strong>账号或密码错误！</strong></h4>\n' +
                            '    </div>';
                        $('body').prepend(buff);
                        return;
                    } else {
                        console.log(data);
                    }
                })
            }
        });

        $('#email-in').click(function () {
            $('#email-label').removeClass('empty');
        }).keypress(function () {
            $('#email-label').removeClass('empty');
        })

        $('#password-in').click(function () {
            $('#password-label').removeClass('empty');
        }).keypress(function () {
            $('#password-label').removeClass('empty');
        })
    }

    $(function () {
        addFunctions();
    })

</script>

</body>
</html>