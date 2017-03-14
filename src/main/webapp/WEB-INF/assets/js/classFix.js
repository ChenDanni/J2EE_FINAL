/**
 * Created by cdn on 17/3/15.
 */
$(document).ready(function(){

    function getFormJson(frm) {
        var o = {};
        var a = $(frm).serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    }


    $(document).on('click','#apply-btn',function () {
        var obj = getFormJson("form");
        console.log(obj);
        jQuery.ajax({
            async: true,
            data: obj,
            url: "apply_fix",
            type: "post",
            success: function (res) {
                if (res.result == 1){
                    window.location.href = "/org_applying"
                }else {
                    alert("申请失败");
                }
            }
        });

    })

});