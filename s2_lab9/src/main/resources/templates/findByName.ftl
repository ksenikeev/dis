<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpringBootApplication</title>
</head>
<body>
<div>
    <#if users??>
    <#list users as user>
    <div>${user.id} - ${user.name}  </div>
    </#list>

    </#if>

</div>
</body>
</html>