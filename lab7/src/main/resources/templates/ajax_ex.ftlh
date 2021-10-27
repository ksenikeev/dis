<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Ajax example page</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Welcome to Ajax example page</h1>


<script type="application/javascript">
    function server_time() {
        console.log('time request');
        var xhr = new XMLHttpRequest();
        xhr.open("GET", '/lab7/server_time', true);
        xhr.onreadystatechange = function () {
            if ((xhr.status == 200) && (xhr.readyState == 4)) {
                document.getElementById('server_time').innerHTML = xhr.responseText;
            }
        }
        xhr.send();
    }

    async function server_time_fetch() {
        console.log('time request by fetch');
        let response = await fetch('/lab7/server_time');

        if (response.ok) { // если HTTP-статус в диапазоне 200-299
                           // получаем тело ответа (см. про этот метод ниже)
            document.getElementById('server_time').innerHTML = await response.text();
        } else {
            alert("Ошибка HTTP: " + response.status);
        }
    }
</script>

<h2>время сервера:</h2>
<div id="server_time">

</div>

<div>
    <button onclick="server_time_fetch()">Запросить время сервера</button>
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