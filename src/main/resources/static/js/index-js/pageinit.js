/*当整个HTML加载完成之后，再执行子函数*/
$(function () {
    //改变div的高度
    $(".content-left").height($(window).height());
    $(".content-right").height($(window).height());


    /*隐藏所有的副标题*/
    $(".nav-menu").each(function () {
        $(this).children(".nav-content").hide();
    });
    /*给所有菜单项的主标题绑定事件*/
    $(".nav-title").each(function () {
        $(this).click(function () {
            /*当点击主标题时，其子标题显示*/
            //获取当前点击主标题下的子标题区
            var navconEle = $(this).parents(".nav-menu").children(".nav-content");
            //判断nav-conEle的display属性值是否为none
            if (navconEle.css("display") != "none") {
                /*navconEle.hide(500);*/
                navconEle.slideUp(500);
            } else {
                /*当展开某一个子标题时，需要将其他所有展开的子标题关闭*/
                var navEle = $(this).parents(".nav-menu");
                /*获取除本类外的其他所有兄弟类*/
                var menuEle = navEle.siblings();
                menuEle.each(function () {
                   // $(this).children(".nav-content").hide(500);
                    $(this).children(".nav-content").slideUp(500)
                });
                //展示
                navconEle.slideDown(500);


            }
        });
    });
})