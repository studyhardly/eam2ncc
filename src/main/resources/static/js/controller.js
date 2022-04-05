function setHead_jk() {
    $("#title-p").val("EAM系统在线用户");

}


/*清除锁定用户*/
function lock_user() {
    var path = getRootPath_web();
    var url = path + "/user/clearlock"
    if (confirm("确定要清除所用锁定用户吗？")) {
        $.ajax({
            type: 'post',
            url: url,
            // jsonp:"callback",
            success: function (data) {
                debugger;
                alert(data)
                qry_user();
            },
            error: function (textStatus) {
                console.log("error" + textStatus)
                alert("查询错误!");
            }
        });

    } else
        return false;
}


function qry_reset() {
    $("#username").val('');
    $("#logid").val('');
};

function sync_reset() {
    $("#zcbm").val('');
    $("#ywid").val('');
};

function sync_czreset() {
    $("#dwdh").val('');
    $("#billid").val('');
    $("#ywid").val('');
};

function sync_qry() {
    debugger;
    var zcbm = $("#zcbm").val().replace(/\s+/g, "");
    var ywid = $("#ywid").val().replace(/\s+/g, "");
    $("#zcbm").val(zcbm);
    $("#ywid").val(ywid);
    var path = getRootPath_web();
    var url;
    var data;
    if (zcbm.length == 0 && ywid.length == 0) {
        alert("请输入要查询的资产编码或单据业务ID");
        return false;
    } else if (zcbm.length != 0) {
        url = path + "/sync/zcbm";
        data = {"code": zcbm}
    } else if (ywid.length != 0) {
        url = path + "/sync/ywid";
        data = {"code": ywid}
    }
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        // jsonp:"callback",
        success: function (data) {
            debugger;
            console.log(data);
            // var obj = JSON.parse(data);
            // console.log(obj);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                var synctimd = formatDate(data[i].sysncdate);
                var st = data[i].sysncstatus;
                var tid = data[i].tid;
                html += "<tr>" +
                    "<td style=\"vertical-align: middle;\">" + (i + 1) + "</td>" +
                    "<td style=\"vertical-align: middle;\">" + data[i].tid + "</td>" +
                    "<td style=\"vertical-align: middle;\">" + data[i].posummary + "</td>" +
                    "<td style=\"vertical-align: middle;\">" + data[i].sysncstatus + "</td>" +
                    "<td class=\"text-center \"  style=\"width:380px; height:51px; word-wrap:break-word; word-break:break-all\">" + data[i].sysncmessage + "</td>" +
                    "<td style=\"vertical-align: middle;\">" + synctimd + "</td>" +
                    /*  "<td style=\"vertical-align: middle;\"><a class='btn-danger btn-sm' onclick=sync_status(" + data[i].tid + ")>重发" + "</a></td>" +*/
                    "<td style=\"vertical-align: middle;\"><a class='btn-danger btn-sm' onclick=sync_status(" + tid + "," + st + ")>重发" + "</a></td>" +
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


};

function sync_czqry() {
    debugger;
    var ywid = $("#ywid").val().replace(/\s+/g, "");
    $("#ywid").val(ywid);
    var path = getRootPath_web();
    var url;
    var data;
    if (ywid.length == 0) {
        alert("请输入要查询的资产处置业务ID");
        return false;
    } else if (ywid.length != 0) {
        url = path + "/rJczccz/zccz";
        data = {"ywid": ywid}
    }
    $.ajax({
        type: 'post',
        url: url,
        data: data,
        // jsonp:"callback",
        success: function (data) {
            debugger;
            var html = "";
            for (var i = 0; i < data.length; i++) {
                var synctimd = formatDate(data[i].sysncdate);
                /*      var st = data[i].sysncstatus;
                      var tid = data[i].tid;*/
                html += "<tr>" +
                    "<td style=\"vertical-align: middle;\">" + (i + 1) + "</td>" +
                    "<td style=\"vertical-align: middle;\">" + data[i].tid + "</td>" +
                    "<td style=\"vertical-align: middle; width:380px; height:51px; word-wrap:break-word; word-break:break-all\">" + data[i].posummary + "</td>" +
                    "<td style=\"vertical-align: middle;\">" + data[i].sysncstatus + "</td>" +
                    "<td style=\"vertical-align: middle; width:380px; height:51px; word-wrap:break-word; word-break:break-all\">" + data[i].sysncmessage + "</td>" +
                    "<td style=\"vertical-align: middle;\">" + synctimd + "</td>" +
                    /*  "<td style=\"vertical-align: middle;\"><a class='btn-danger btn-sm' onclick=sync_status(" + data[i].tid + ")>重发" + "</a></td>" +*/
                    /*"<td style=\"vertical-align: middle;\"><a class='btn-danger btn-sm' onclick=sync_status(" + tid + "," + st + ")>重发" + "</a></td>" +*/
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


/*查询用户信息*/
function qry_user() {
    var username = $("#username").val().replace(/\s+/g, "");
    var logid = $("#logid").val().replace(/\s+/g, "");
    $("#username").val(username);
    $("#logid").val(logid);
    var path = getRootPath_web();
    var url;
    if (username.length != 0 || logid.length != 0) {
        url = path + "/user/queryUser"
    } else {
        url = path + "/user/all"
    }
    $.ajax({
        type: 'post',
        url: url,
        data: {"username": username, "logid": logid},
        // jsonp:"callback",
        success: function (data) {
            debugger;
            console.log(data);
            // var obj = JSON.parse(data);
            // console.log(obj);
            var html = "";

            for (var i = 0; i < data.length; i++) {
                var logid = data[i].logid;
                var time = formatDate(data[i].logondate)
                html += "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + data[i].username + "</td>" +
                    "<td>" + data[i].logid + "</td>" +
                    "<td>" + data[i].ip + "</td>" +
                    "<td>" + time + "</td>" +
                    "<td>" + data[i].companycode + "</td>" +
                    "<td><a class='btn-danger btn-sm' onclick=clear_user(" + data[i].logid + ")>下线" + "</a></td>" +
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

/*修改同步状态*/
function sync_status(zcbm, st) {

    if (st == 1) {
        alert("状态已是失败状态，无需修改即可重发！");
        return false;
    }
    var path = getRootPath_web();
    var url = path + "/sync/chbyzcbm"
    if (confirm("确定要修改此条目的推送状态吗？")) {
        $.ajax({
            type: 'post',
            url: url,
            data: {"code": zcbm},
            // jsonp:"callback",
            success: function (data) {
                debugger;
                sync_qry();
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
function clear_user(logid) {
    var path = getRootPath_web();
    var url = path + "/user/clear"
    if (confirm("确定下线该用户吗？")) {
        $.ajax({
            type: 'post',
            url: url,
            data: {"logid": logid},
            // jsonp:"callback",
            success: function (data) {
                debugger;
                qry_user();
            },
            error: function (textStatus) {
                console.log("error" + textStatus)
                alert("查询错误!");
            }
        });

    } else
        return false;
}

/*查询业务id*/


function qry_ywid() {

    var ywid = $("#ywid").val().replace(/\s+/g, "");
    $("#ywid").val(ywid);
    if (ywid.length != 0) {
        sync_czqry();
    } else {
        var dwdh = $("#dwdh").val().replace(/\s+/g, "");
        var billid = $("#billid").val().replace(/\s+/g, "");

        $("#dwdh").val(dwdh);
        $("#billid").val(billid);

        if (dwdh.length != 4 || billid.length < 0) {
            alert("单位代号和单据编码都不可为空，或请直接输入单据YWID进行查询！");
        } else {
            var path = getRootPath_web();
            var url = path + "/qryywid"
            //alert(url);
            $.ajax({
                type: 'post',
                url: url,
                data: {"dwdh": dwdh, "billid": billid},
                // jsonp:"callback",
                success: function (data) {
                    debugger;
                    console.log(data);
                    $("#res").text(data);
                    var obj = JSON.parse(data);
                    var ywid = obj.ywid;
                    doClear();
                    if ($("#zcbm") != undefined) {
                        $("#zcbm").val(ywid);
                    }
                    if ($("#ywid") != undefined) {
                        $("#ywid").val(ywid);
                        sync_czqry();
                    }
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

    }
};

window.onload = function ()//用window的onload事件，窗体加载完毕的时候
{
    var jklx = $("#select-jklx").val();
    // alert("页面加载："+jklx)
    if (jklx == 'zcxz') {
        $("#tip").html("提示：请输入资产编码,资产编码支持批量输入，中间要用英文 \",\" 隔开。")
    } else if (jklx == 'zccz') {
        $("#tip").html("提示：请输入一条资产处置单据 ywid")
    }


};

function change_jklx() {
    debugger;
    var jklx = $("#select-jklx").val();
    if (jklx == 'zcxz') {
        $("#tip").html("提示：请输入资产编码,资产编码支持批量输入，中间要用英文 \",\" 隔开。")
    } else if (jklx == 'zccz') {
        $("#tip").html("提示：请输入一条资产处置单据YWID, 单据YWID可通过查询获得。")
    }
};

function doCopy() {
    var mes = $("#res").val();
    Clipboard.copy(mes);
};


function doSubmit() {
    var code = $("#zcbm").val();
    debugger;
    var path = getRootPath_web();
    var jklx = $("#select-jklx").val();
    var url;

    if (code.length != 0) {
        if (jklx == 'zcxz') {
            url = path + "/zczj";
        } else if (jklx == 'zccz') {
            url = path + "/zccz";
        }
        $.ajax({
            type: 'post',
            url: url,
            data: {"code": code},
            // jsonp:"callback",
            success: function (data) {
                debugger;
                console.log(data);
                $("#res").text(data);

                /*    if (data.statusCode == 200) {

                    } else {
                    }*/
            },
            error: function (textStatus) {
                console.log("error" + textStatus)
                alert("发生错误，请检查输入的资产编码中的逗号是否为中文字符");
            }
        })
    } else {
        if (jklx == 'zcxz') {
            alert("请输入资产卡片编码");
        } else if (jklx == 'zccz') {
            alert("请输入资产处置报账ywid");
        }
    }
};

function doClear() {
    $("#zcbm").val("");
};


//定义函数
window.Clipboard = (function (window, document, navigator) {
    var textArea,
        copy;

    // 判断是不是ios端
    function isOS() {
        return navigator.userAgent.match(/ipad|iphone/i);
    }

    //创建文本元素
    function createTextArea(text) {
        textArea = document.createElement('textArea');
        textArea.innerHTML = text;
        textArea.value = text;
        document.body.appendChild(textArea);
    }


    //选择内容
    function selectText() {
        var range,
            selection;

        if (isOS()) {
            range = document.createRange();
            range.selectNodeContents(textArea);
            selection = window.getSelection();
            selection.removeAllRanges();
            selection.addRange(range);
            textArea.setSelectionRange(0, 999999);
        } else {
            textArea.select();
        }
    }

//复制到剪贴板
    function copyToClipboard() {
        try {
            if (document.execCommand("Copy")) {
                //alert("复制成功！");
            } else {
                alert("复制失败！请手动复制！");
            }
        } catch (err) {
            alert("复制错误！请手动复制！")
        }
        document.body.removeChild(textArea);
    }

    copy = function (text) {
        createTextArea(text);
        selectText();
        copyToClipboard();
    };

    return {
        copy: copy
    };
})(window, document, navigator);

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