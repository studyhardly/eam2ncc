function reset_enum() {
    $("#enumlxid").val('');
    $("#enumlxmc").val('')
    $("#enumvalue").val('')
}

/*查询系统枚举值信息*/
function qry_enum() {
    var enumlxid = $("#enumlxid").val().replace(/\s+/g, "");
    var enumlxmc = $("#enumlxmc").val().replace(/\s+/g, "");
    var enumvalue = $("#enumvalue").val().replace(/\s+/g, "");
    $("#enumlxid").val(enumlxid);
    $("#enumlxmc").val(enumlxmc);
    $("#enumvalue").val(enumvalue);
    var path = getRootPath_web();
    var url;
    if (enumlxid.length != 0 || enumlxmc.length != 0 || enumvalue.length != 0) {
        url = path + "/enum/list"
    } else {
        alert("查询条件不能全为空！");
        return false;
    }
    $.ajax({
        type: 'get',
        url: url,
        data: {"enumlxid": enumlxid, "enumlxmc": enumlxmc, "enumvalue": enumvalue},
        // jsonp:"callback",
        success: function (data) {
            debugger;
            console.log(data);
            // var obj = JSON.parse(data);
            // console.log(obj);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + data[i].enumlxmc + "</td>" +
                    "<td>" + data[i].enumlxid + "</td>" +
                    "<td>" + data[i].enumvalue + "</td>" +
                    "<td>" + data[i].enumid + "</td>" +
                    "</tr>"
            }
            console.log(html);
            $("#user-tab tbody").html(html);

            /*    if (data.statusCode == 200) {

                } else {
                }*/
        },
        error: function (textStatus) {
            console.log("error" + textStatus)
            alert("查询错误!");
        }
    })

}

/*获取项目路径*/
function getRootPath_web() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    // var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    // return (localhostPaht + projectName);
    return (localhostPaht);
}