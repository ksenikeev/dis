<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Organization list</title>

    <script type="text/javascript">
        var vpage = 0;

        document.getElementById("numpage").innerHTML=vpage;

        function inc_page() {
            vpage = vpage + 1;
            document.getElementById("numpage").innerHTML=vpage;
        }

        function dec_page() {
            if (vpage > 0)
            vpage = vpage - 1;
            document.getElementById("numpage").innerHTML=vpage;
        }
        async function getorg() {
            //clear table
            tbody = document.getElementById('tbl_body');
            while(tbody.rows.length > 0) {
              tbody.deleteRow(0);
            }

            // PageableDTO
           let org_pageable = {
              page: vpage,
              size: document.getElementById('num_page').value
            };

            // POST request
            let response = await fetch('/getorgs', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json;charset=utf-8'
              },
              body: JSON.stringify(org_pageable)
            });

            let result = await response.json();

            // add JSON into table
           for (var j = 0; j < result.length; j++) {
                var row = tbody.insertRow (-1);
                var cell1 = row.insertCell(-1);
                cell1.innerHTML = result[j].id;
                var cell2 = row.insertCell(-1);
                cell2.innerHTML = result[j].name;
            }
        }
    </script>

</head>
<body>

    <h1>Organization list</h1>

    <button onclick="getorg()">Показать организации</button>

    <div>
        <table>
            <thead>
                <th>ID</th><th>NAME</th>
            </thead>
            <tbody id="tbl_body">
                <tr>
                    <td>1</td><td>Org1</td>
                </tr>
            </tbody>
        </table>
    </div>

    <div>
    <select id="num_page">
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="50">50</option>
    </select>
    </div>

<div>
    <button onclick="dec_page()"> &lt; </button>
    <span id="numpage"></span>
    <button onclick="inc_page()"> &gt; </button>
</div>
</body>
</html>