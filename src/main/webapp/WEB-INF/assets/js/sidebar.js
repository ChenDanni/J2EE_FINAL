/**
 * Created by cdn on 17/3/7.
 */
$(document).ready(function () {
    var current = $('#sidebar-current').val();
    current = '#' + current;
    $(current).addClass('active');
});