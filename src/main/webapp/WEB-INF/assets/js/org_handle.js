/**
 * Created by cdn on 17/3/14.
 */
$(document).ready(function () {
    $(document).on('click','.set-account-btn',function () {
        var td = $(this).parent();
        var money = $(this).prev().val();
        var cardId = $(this).next().val();
        var classId = $(this).next().next().val();
        var orgId = $(this).next().next().next().val();
        var type = $(this).next().next().next().next().val();

        var data = {
            "money":money,
            "cardId":cardId,
            "classId":classId,
            "orgId":orgId,
            "type":type
        };

        console.log(data);

        jQuery.ajax({
            async: true,
            data: data,
            url: "handle_org",
            type: "post",
            success: function (res) {
                td.html('<td><input type="number" disabled="disabled" value="'+money+'"/>');
            }
        });

    });
});