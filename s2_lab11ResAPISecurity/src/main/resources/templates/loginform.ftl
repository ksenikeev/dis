<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>UserLoginFormSpringSecurity</title>

    <link rel='stylesheet' href='/resources/css/lab10.css'>
    <script src='/resources/js/lab10.js'></script>
</head>
<body>

<h1>UserLoginFormSpringSecurity</h1>

<div>
    <form action="/login" method="post" onsubmit="validate()">
        <div><input class="field" name="username" placeholder="имя пользователя"/></div>
        <div><input class="field" name="password" placeholder="пароль"/></div>
        <div><input class="field" type="submit" value="Вход"/></div>
    </form>
</div>

</body>
</html>