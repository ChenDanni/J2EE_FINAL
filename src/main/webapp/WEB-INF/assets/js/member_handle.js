/**
 * Created by cdn on 17/3/14.
 */
$(document).ready(function () {
    $(document).on('click','.money-back-btn',function () {
        var td = $(this).parent();
        var money = $(this).prev().val();
        var cardId = $(this).next().val();
        var classId = $(this).next().next().val();

        var data = {
            "money":money,
            "cardId":cardId,
            "classId":classId
        };

        console.log(data);

        jQuery.ajax({
            async: true,
            data: data,
            url: "handle_quit",
            type: "post",
            success: function (res) {
                td.html('<td><input type="number" disabled="disabled" value="'+money+'"/>');
            }
        });

    });
});