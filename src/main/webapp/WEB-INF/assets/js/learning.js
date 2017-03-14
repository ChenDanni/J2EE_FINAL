/**
 * Created by cdn on 17/3/8.
 */
$(document).ready(function () {
    $(document).on('click','.packup-btn',function () {
        var btn = $(this);
        $(this).parents('.course-detail-card').siblings('.list-group').slideToggle();
        if (btn.html() == "查看进度") {
            $(this).html("收起进度");
        } else {
            $(this).html("查看进度");
        }
    });

    $(document).on('click','.quit-btn',function(){
        var p = $(this).parent();
        var classId = $(this).next().val();
        var data = {
            "classId":classId
        };
        jQuery.ajax({
            async: true,
            data: data,
            url: "quit_course",
            type: "post",
            success: function (res) {
                p.html('<a href="#" class="btn btn-info packup-btn" role="button">收起进度</a> <a href="#" class="btn btn-warning quit-btn" role="button">已申请退课</a>');
            }
        });
    });

});

