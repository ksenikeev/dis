<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Новый товар</title>
</head>
<body>t

    <script type="text/javascript">
        function select_merch(id, code) {
            tbody = document.getElementById('tbl_body');
            while(tbody.rows.length > 0) {
              tbody.deleteRow(0);
            }

            document.getElementById("merch_id").innerHTML = id;
            document.getElementById("merch_code").innerHTML = code;

        }

        async function search_merch() {
            //clear table
            tbody = document.getElementById('tbl_body');
            while(tbody.rows.length > 0) {
              tbody.deleteRow(0);
            }


            name = document.getElementById('name').value;

            let response = await fetch('/merch?name='+name);
            let result = await response.json();

            for (var j = 0; j < result.length; j++) {
                var row = tbody.insertRow (-1);
                var cell1 = row.insertCell(-1);
                cell1.innerHTML = result[j].code;
                var cell2 = row.insertCell(-1);
                cell2.innerHTML = result[j].name;
                var cell3 = row.insertCell(-1);
                cell3.innerHTML = "<button onclick='select_merch("+result[j].id +","+ result[j].code+")'>Выбрать</button>"
            }
        }
    </script>

    <h1>Новый товар</h1>
    <div>
        <span>Наименование</span>
        <input id="name" type="text"/>
        <button onclick="search_merch()">Найти</button>
    </div>
    <div>
        <table>
            <thead><th>Код</th><th>Наименование</th><th></th></thead>
            <tbody id="tbl_body"></tbody>
        </table>
    </div>

    <div><span>Выбранный товар:</span>
        <span id="merch_id"></span>&nbsp;
        <span id="merch_code"></span>&nbsp;
        <span id="merch_name"></span>
    </div>

</body>
</html>