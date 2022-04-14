<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpringBootApplication</title>
</head>
<body>
<div>
    <#if userdata??>
    <#list userdata as data>
    <div>${data.id} - ${data.passport}  </div>
    </#list>

    </#if>

</div>
</body>
</html>