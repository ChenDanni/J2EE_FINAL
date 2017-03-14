/**
 * Created by cdn on 17/3/11.
 */
$(document).ready(function(){

    var i = 1;
    $(document).on('click','#add-lesson',function () {
        i++;
        $('#lessons').append('<p>课时'+ i +': <input type="text" name="lesson-title-'+ i +'" class="form-control" placeholder="本节标题" required autofocus>'
             + '<input type="text" name="lesson-des-'+ i +'" class="form-control" placeholder="本节内容" required autofocus></p>');
    });

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
            url: "apply_class",
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