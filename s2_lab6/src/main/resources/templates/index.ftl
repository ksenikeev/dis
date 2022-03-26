<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpringBootApplication</title>
</head>
<body>
<div>
    <h1>${user}</h1>

    <form method="post" enctype="application/x-www-form-urlencoded" action="/save">
        <div><label for="username">username:</label><input type="text" id="username"></div>
        <div><label for="password">passsword:</label><input type="text" id="password"></div>
        <div><input type="submit"></div>
    </form>
</div>
</body>
</html>