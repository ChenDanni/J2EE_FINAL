/**
 * Created by cdn on 17/3/15.
 */
var recharge = echarts.init(document.getElementById("recharge"));
recharge.showLoading();

var quit = echarts.init(document.getElementById("quit"));
quit.showLoading();

var set_account = echarts.init(document.getElementById("set-account"));
set_account.showLoading();


$(document).ready(function(){

    var data = {};

    jQuery.ajax({
        //async: true,
        data: data,
        url: "manager_recharge",
        type: "post",
        success: function (json) {
            fill_recharge(json);
        }
    });
    jQuery.ajax({
        //async: true,
        data: data,
        url: "manager_quit",
        type: "post",
        success: function (json) {
            fill_quit(json);
        }
    });
    jQuery.ajax({
        //async: true,
        data: data,
        url: "manager_set_account",
        type: "post",
        success: function (json) {
            fill_set_account(json);
        }
    });


});
function fill_recharge(json){
    recharge.hideLoading();

    var option = {
        title: {
            text: '',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c}'
        },
        legend: {
            left: 'left',
            data: ['收入']
        },
        xAxis: {
            type: 'category',
            name: '时间',
            splitLine: {show: false},
            data: json.time
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            type: 'value',
            name: '金额'
        },
        series: [
            {
                name: '3的指数',
                type: 'line',
                data: json.num
            }
        ]
    };

    recharge.setOption(option);

}

function fill_quit(json){
    quit.hideLoading();

    var option = {
        title: {
            text: '',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c}'
        },
        legend: {
            left: 'left',
            data: ['收入']
        },
        xAxis: {
            type: 'category',
            name: '时间',
            splitLine: {show: false},
            data: json.time
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            type: 'value',
            name: '金额'
        },
        series: [
            {
                name: '3的指数',
                type: 'line',
                data: json.num
            }
        ]
    };

    quit.setOption(option);

}

function fill_set_account(json){
    set_account.hideLoading();

    var option = {
        title: {
            text: '',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c}'
        },
        legend: {
            left: 'left',
            data: ['收入']
        },
        xAxis: {
            type: 'category',
            name: '时间',
            splitLine: {show: false},
            data: json.time
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            type: 'value',
            name: '金额'
        },
        series: [
            {
                name: '3的指数',
                type: 'line',
                data: json.num
            }
        ]
    };

    set_account.setOption(option);

}