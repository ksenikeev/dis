<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="/lab5/resources/css/main.css">

</head>
<body>
<h1>Welcome ${groupp!} from freemarker template! ${date}</h1>

<div class="tmp">
<table>
    <tr>
        <td>1</td>
        <td>2</td>
    </tr>
<#--
    <#list groupp_list as lst>
        <tr>
            <td>${lst?counter}</td><td>${lst.num}</td><td>${lst.name}</td>
        </tr>
    </#list>
-->
</table>
</div>
<p>
</body>
</html>