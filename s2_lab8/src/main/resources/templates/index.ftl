<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpringBootApplication</title>
</head>
<body>
<div>
    <h1>${user}</h1>
    <h1>${text!}</h1>

    <form method="post"  action="/save">
        <div><label for="username">username:</label><input type="text" name="userName" id="username"></div>
        <div><label for="password">passsword:</label><input type="text" name="password" id="password"></div>
        <div><label for="passport">passport:</label><input type="text" name="passport" id="passport"></div>
        <div><label for="email">email:</label><input type="text" name="email" id="email"></div>
        <div><input type="submit"></div>
    </form>
</div>
</body>
</html>