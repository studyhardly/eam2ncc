function setHead_jk() {
    $("#title-p").val("EAM系统用户管理");
}
//注册新增按钮的事件
function user_add() {
    $("#myModalLabel").text("新增");
    $('#myModal').modal();
    $("#btn_submit").attr('onclick','user_save()');
    $("#user_codediv").attr("style","display:block");
};
//编辑按钮的事件
function user_upd(bjcode,bjname,bjremark) {
    $("#myModalLabel").text("编辑");
    $('#myModal').modal();
    var id=bjcode;
    $("#user_code").val(bjcode);
    $("#user_name").val(bjname);
    $("#user_remark").val(bjremark);
    $("#user_id").val(id);
    $("#btn_submit").removeAttr("onclick");
    $("#btn_submit").attr('onclick','user_edit()');
    $("#user_codediv").attr("style","display:none");
};
function user_reset() {
    $("#username").val('');
    $("#usercode").val('');
};

/*查询上线用户信息*/
function user_real() {
    var url = "/sysuser/realUsers";
    $.ajax({
        type: 'post',
        url: url,
        data: {},
        // jsonp:"callback",
        success: function (data) {
            //iframe 内容块的页面跳转
            $("#icont").attr("src", "view/usermanagement.html");
            var html = "";
            for (var i = 0; i < data.length; i++) {
                var usercode =data[i].usercode;
                var username =data[i].username;
                var remark =data[i].remark;
                var isblock = data[i].isblock;
                if (isblock==0){
                    html += "<tr>" +
                        "<td>" + (i + 1) + "</td>" +
                        "<td class='td_edit'>" + usercode + "</td>" +
                        "<td class='td_edit'>" + data[i].username + "</td>" +
                        "<td class='td_edit'><i class='fa fa-user-o fa-2x' aria-hidden='true' style='color: #2ecc71'></i></td>" +
                        "<td class='td_edit'>" + data[i].remark + "</td>" +
                        "<td><button class='btn btn-danger btn-sm' onclick=user_upd("+ "'"+usercode+"','"+username+"','"+remark+"')>修改" + "</button>" +
                        "&nbsp;&nbsp;&nbsp;<button class='btn btn-danger btn-sm' onclick=user_clear(" + usercode + ",this)>停用" + "</button></td>" +
                        "</tr>"
                }else if (isblock==1){
                    html += "<tr>" +
                        "<td>" + (i + 1) + "</td>" +
                        "<td class='td_edit'>" + usercode + "</td>" +
                        "<td class='td_edit'>" + data[i].username + "</td>" +
                        "<td class='td_edit'><i class='fa fa-user-o fa-2x' aria-hidden='true' style='color: grey'></i></td>" +
                        "<td class='td_edit'>" + data[i].remark + "</td>" +
                        "<td><button class='btn btn-danger btn-sm' onclick=user_upd("+ "'"+usercode+"','"+username+"','"+remark+"')>修改" + "</button>" +
                        "&nbsp;&nbsp;&nbsp;<button class='btn btn-danger btn-sm' onclick=user_online(" + usercode + ",this)>启用" + "</button></td>" +
                        "</tr>"
                }


            }
            $("#userlist").html(html);
            //父页面获取的值，子页面不显示
            //$('#icont').contents().find("#userlist").html(html);


        },
        error: function (textStatus) {
            console.log("error" + textStatus)
            alert("查询错误!");
        }
    })
}
/*查询所有用户信息*/
function user_all() {
    var url = "/sysuser/all";
    $.ajax({
        type: 'post',
        url: url,
        data: {},
        // jsonp:"callback",
        success: function (data) {
            //iframe 内容块的页面跳转
            $("#icont").attr("src", "view/usermanagement.html");
            var html = "";
            for (var i = 0; i < data.length; i++) {
                var usercode =data[i].usercode;
                var username =data[i].username;
                var remark =data[i].remark;
                var user=data[i];
                var isblock = data[i].isblock;
                if (isblock==0){
                    html += "<tr>" +
                        "<td>" + (i + 1) + "</td>" +
                        "<td class='td_edit'>" + usercode + "</td>" +
                        "<td class='td_edit'>" + data[i].username + "</td>" +
                        "<td class='td_edit'><i class='fa fa-user-o fa-2x' aria-hidden='true' style='color: #2ecc71'></i></td>" +
                        "<td class='td_edit'>" + data[i].remark + "</td>" +
                        "<td><button class='btn btn-danger btn-sm' onclick=user_upd("+ "'"+usercode+"','"+username+"','"+remark+"')>修改" + "</button>" +
                        "&nbsp;&nbsp;&nbsp;<button class='btn btn-danger btn-sm' onclick=user_clear(" + usercode + ",this)>停用" + "</button></td>" +
                        "</tr>"
                }else if (isblock==1){
                    html += "<tr>" +
                        "<td>" + (i + 1) + "</td>" +
                        "<td class='td_edit'>" + usercode + "</td>" +
                        "<td class='td_edit'>" + data[i].username + "</td>" +
                        "<td class='td_edit'><i class='fa fa-user-o fa-2x' aria-hidden='true' style='color: grey'></i></td>" +
                        "<td class='td_edit'>" + data[i].remark + "</td>" +
                        "<td><button class='btn btn-danger btn-sm' onclick=user_upd("+ "'"+usercode+"','"+username+"','"+remark+"')>修改" + "</button>" +
                        "&nbsp;&nbsp;&nbsp;<button class='btn btn-danger btn-sm' onclick=user_online(" + usercode + ",this)>启用" + "</button></td>" +
                        "</tr>"
                }
            }
            $("#userlist").html(html);
            //父页面获取的值，子页面不显示
            //$('#icont').contents().find("#userlist").html(html);


        },
        error: function (textStatus) {
            console.log("error" + textStatus)
            alert("查询错误!");
        }
    })
}
/*查询用户信息*/
function user_qry() {
    var name = $("#username").val();
    var code = $("#usercode").val();
    if(name != null && name != "" || name != null && code != ""){
        name = name.replace(/\s+/g, "");
        code = code.replace(/\s+/g, "");
        $("#name").val(name);
        $("#code").val(code);
        // var path = getRootPath_web();
        var url;
        if (name != null && name != "" || name != null && code != "") {
            url = "/sysuser/queryUser"
        $.ajax({
            type: 'post',
            url: url,
            data: {"username": name, "usercode": code},
            // jsonp:"callback",
            success: function (data) {
                //debugger;
                // var obj = JSON.parse(data);
                // console.log(obj);
                var html = "";

                for (var i = 0; i < data.length; i++) {
                    var usercode =data[i].usercode;
                    var username =data[i].username;
                    var remark =data[i].remark;
                    var user=data[i];
                    var isblock = data[i].isblock;
                    if (isblock==0){
                        html += "<tr>" +
                            "<td>" + (i + 1) + "</td>" +
                            "<td class='td_edit'>" + usercode + "</td>" +
                            "<td class='td_edit'>" + data[i].username + "</td>" +
                            "<td class='td_edit'><i class='fa fa-user-o fa-2x' aria-hidden='true' style='color: #2ecc71'></i></td>" +
                            "<td class='td_edit'>" + data[i].remark + "</td>" +
                            "<td><button class='btn btn-danger btn-sm' onclick=user_upd("+ "'"+usercode+"','"+username+"','"+remark+"')>修改" + "</button>" +
                            "&nbsp;&nbsp;&nbsp;<button class='btn btn-danger btn-sm' onclick=user_clear(" + usercode + ",this)>停用" + "</button></td>" +
                            "</tr>"
                    }else if (isblock==1){
                        html += "<tr>" +
                            "<td>" + (i + 1) + "</td>" +
                            "<td class='td_edit'>" + usercode + "</td>" +
                            "<td class='td_edit'>" + data[i].username + "</td>" +
                            "<td class='td_edit'><i class='fa fa-user-o fa-2x' aria-hidden='true' style='color: grey'></i></td>" +
                            "<td class='td_edit'>" + data[i].remark + "</td>" +
                            "<td><button class='btn btn-danger btn-sm' onclick=user_upd("+ "'"+usercode+"','"+username+"','"+remark+"')>修改" + "</button>" +
                            "&nbsp;&nbsp;&nbsp;<button class='btn btn-danger btn-sm' onclick=user_online(" + usercode + ",this)>启用" + "</button></td>" +
                            "</tr>"
                    }
                }
                $("#userlist").html(html);

            },
            error: function (textStatus) {
                console.log("error" + textStatus)
                alert("查询错误!");
            }
        })
    }
} else {
    // url = path + "/sysuser/realUsers"
    user_real();
}
}
/*用户新增*/
function user_save() {
    var uacode=$("#user_code").val();
    var uaname=$("#user_name").val();
    var uaremark=$("#user_remark").val();
    var url = "/sysuser/add";
    $.ajax({
        type: 'post',
        url: url,
        data: {"usercode": uacode, "username": uaname, "remark": uaremark},
        // jsonp:"callback",
        success: function (data) {
            //debugger;
            alert(data);
            user_real();
        },
        error: function (textStatus) {
            alert(textStatus);
            user_real();
        }
    });

}
/*用户修改*/
function user_edit() {
    var uacode=$("#user_code").val();
    var uaname=$("#user_name").val();
    var uaremark=$("#user_remark").val();
    var url = "/sysuser/edit";
    $.ajax({
        type: 'post',
        url: url,
        data: {"usercode": uacode, "username": uaname, "remark": uaremark},
        // jsonp:"callback",
        success: function (data) {
            //debugger;
            alert(data);
            user_real();
        },
        error: function (textStatus) {
            alert(textStatus);
            user_real();
        }
    });

}

/*用户上线*/
function user_online(usercode,obj) {
    var url = "/sysuser/online"
    if (confirm("确定上线该用户吗？")) {
        $.ajax({
            type: 'post',
            url: url,
            data: {"usercode": usercode},
            // jsonp:"callback",
            success: function (data) {
                //debugger;
                user_all();
            },
            error: function (textStatus) {
                console.log("error" + textStatus)
                alert("查询错误!");
            }
        });

    } else
        return false;
}
/*用户下线*/
function user_clear(usercode,obj) {
    var url = "/sysuser/clear"
    if (confirm("确定下线该用户吗？")) {
        $.ajax({
            type: 'post',
            url: url,
            data: {"usercode": usercode},
            // jsonp:"callback",
            success: function (data) {
                //debugger;
                user_all();
            },
            error: function (textStatus) {
                console.log("error" + textStatus)
                alert("查询错误!");
            }
        });

    } else
        return false;
}

function readyedit(){
    //给所有td添加点击事件
    var tdNods = $(".td_edit");
    tdNods.click(tdClick);//点击调用tdClick方法
}

/*格式化时间*/
function formatDate(time) {
    var date = new Date(time);
    var year = date.getFullYear(),
        month = date.getMonth() + 1,//月份是从0开始的
        day = date.getDate(),
        hour = date.getHours(),
        min = date.getMinutes(),
        sec = date.getSeconds();
    var newTime = year + '-' +
        month + '-' +
        day + ' ' +
        hour + ':' +
        min + ':' +
        sec;
    return newTime;
}
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