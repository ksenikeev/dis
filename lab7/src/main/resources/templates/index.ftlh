<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Welcome ${groupp!} from freemarker template! ${date!}</h1>

<div>

<form action="/lab7/logout" method="get">
    <input type="submit" value="Выход">
</form>

</div>

<div>
    <a href="/lab7/logout">Выход</a>
</div>

<div>
    <a href="/lab7/ajax_ex.html">Ajax page</a>
</div>

<div>
<#--
<table>
    <#list groupp_list as lst>
        <tr>
            <td>${lst?counter}</td><td>${lst.num}</td><td>${lst.name}</td>
        </tr>
    </#list>
</table>
-->
</div>
<p>
</body>
</html>