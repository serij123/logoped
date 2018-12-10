<!doctype html>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Задать вопрос</title>

    <link href="/resources/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/logoped.css" rel="stylesheet">
    <link href="/resources/jquery-ui.min.css" rel="stylesheet">

    <script src="/resources/jquery-3.3.1.min.js"></script>
    <script src="/resources/bootstrap.min.js"></script>
    <script src="/resources/jquery-ui.min.js"></script>
    <script>
        $(document).ready(function() {
            var csrfParam = "${_csrf.parameterName}";

            function gotoHome() {
                window.location = '/';
            }
            dialog = $( "#dialog-div" ).dialog({
                dialogClass: "no-close",
                closeOnEscape:false,
                autoOpen: false,
                height: 200,
                width: 350,
                modal: true,
                buttons: [{
                    text:"Вернуться на главную страницу",
                    click:gotoHome
                }]
            });
            dialogErr = $( "#dialog-err-div" ).dialog({
                dialogClass: "no-close",
                closeOnEscape:false,
                autoOpen: false,
                height: 200,
                width: 350,
                modal: true,
                buttons: [{
                    text:"Вернуться на главную страницу",
                    click:gotoHome
                }]
            });

            document.getElementById("btnSubmit").addEventListener("click", function(event){
                event.preventDefault();
                var postData = {
                    name:document.getElementById("name").value,
                    email:document.getElementById("email").value,
                    text:document.getElementById("text").value
                };
                postData[csrfParam] = "${_csrf.token}";
                $.post(
                    "/api/send_question", 
                    postData,
                    function (data, status) {
                        if (data.code == '0') {
                            dialog.dialog("open");
                        } else {
                            dialogErr.dialog("open");
                        }
                    });
            });

        });
    </script>
</head>

<body class="bg">
<div class="bg-white-transparent">
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 border-bottom shadow-sm bg-red-transparent">
        <h1 class="my-0 mr-md-auto text-white">ЛОГОПЕД И Я</h1>
        <nav class="my-2 my-md-0 mr-md-2" >
            <a class="p-2 text-white text-header" href="../resources">Главная</a>
            <a class="p-2 text-white text-header" href="/about_me.html">О себе</a>
            <a class="p-2 text-white text-header" href="/send_question.html">Задать вопрос</a>
        </nav>
        <!--<a class="btn btn-outline-primary" href="#">Личный кабинет</a>-->
    </div>

    <div class="container contact-form" style="font-size: 20px;">
        <form id=sendQuestionForm" method="post" action="">
            <h2 class="display-5 text-green text-corsiva text-title">Введите пожалуйста свой вопрос</h2>
            <div class="form-group">
                <input type="text" id="name" name="name" class="form-control" placeholder="Ваше имя"  />
            </div>
            <div class="form-group">
                <input type="text" id="email" name="email" class="form-control" placeholder="Ваш e-mail"  />
            </div>
            <div class="form-group">
                <textarea id="text" name="text" class="form-control" placeholder="Вопрос" style="width: 100%; height: 350px;"></textarea>
            </div>
            <div class="form-group">
                <input type="submit" id="btnSubmit" name="btnSubmit" class="btnContact" value="Отправить" />
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <div id="dialog-div" title="">
            <p>Сообщение успешно отправлено</p>
        </div>
        <div id="dialog-err-div" title="">
            <p>К сожалению, произошла ошибка при отправке вопроса</p>
        </div>

        <footer class="pt-4 my-md-5 pt-md-5 border-top">
            <div class="row">
                <div class="col-12 col-md">
                    <!--<img class="mb-2" src="../../assets/brand/bootstrap-solid.svg" alt="" width="24" height="24">-->
                    <small class="d-block mb-3 text-muted">&copy; 2018</small>
                </div>
                <div class="col-6 col-md">
                </div>
                <div class="col-6 col-md">
                </div>
                <div class="col-6 col-md">
                </div>
            </div>
        </footer>
    </div>
</div>
</body>
</html>
