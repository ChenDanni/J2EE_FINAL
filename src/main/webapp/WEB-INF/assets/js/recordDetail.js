/**
 * Created by cdn on 17/3/13.
 */
$(document).ready(function () {
    $(document).on('click','.attend-btn',function () {
        var td = $(this).parents('td').first();
        var cardId = $(this).prev().val();
        var lessonId = $(this).prev().prev().val();

        var data = {
            "lessonId":lessonId,
            "cardId":cardId
        };

        jQuery.ajax({
            async: true,
            data: data,
            url: "record_attend",
            type: "post",
            success: function (res) {
                td.html('<button disabled="disabled" class="btn btn-info">出席</button>');
            }
        });

    });

    $(document).on('click','.absence-btn',function () {
        var td = $(this).parents('td').first();
        var cardId = $(this).prev().val();
        var lessonId = $(this).prev().prev().val();

        var data = {
            "lessonId":lessonId,
            "cardId":cardId
        };
        jQuery.ajax({
            async: true,
            data: data,
            url: "record_absence",
            type: "post",
            success: function (res) {
                td.html('<button disabled="disabled" class="btn btn-danger">缺席</button>');
            }
        });

    });

    $(document).on('click','.score-btn',function () {

        var di = $(this).parent();
        var score = $(this).prev().val();
        var cardId = $(this).prev().prev().val();
        var classId = $(this).prev().prev().prev().val();

        var data = {
            "score": score,
            "cardId": cardId,
            "classId": classId
        };
        jQuery.ajax({
            async: true,
            data: data,
            url: "record_score",
            type: "post",
            success: function (res) {
                di.html('<input type="number" name="score" value="'+ score +'" disabled="disabled"/>');
            }
        });

    });

});