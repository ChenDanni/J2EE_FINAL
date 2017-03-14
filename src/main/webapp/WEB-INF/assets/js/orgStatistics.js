/**
 * Created by cdn on 17/3/14.
 */

var courses = echarts.init(document.getElementById("courses-analysis"));
courses.showLoading();

var courses_start = echarts.init(document.getElementById("courses-start-analysis"));
courses_start.showLoading();

var learning_status = echarts.init(document.getElementById("learning-status"));
learning_status.showLoading();

var orgBalance = echarts.init(document.getElementById("org-balance-analysis"));
orgBalance.showLoading();

$(document).ready(function(){

    var data = {};

    jQuery.ajax({
        //async: true,
        data: data,
        url: "org_learning_status",
        type: "post",
        success: function (json) {
            fill_learning_status(json);
        }
    });
    jQuery.ajax({
        //async: true,
        data: data,
        url: "org_balance_analysis",
        type: "post",
        success: function (json) {
            fill_balance_analysis(json);
        }
    });
    jQuery.ajax({
        //async: true,
        data: data,
        url: "org_courses_analysis",
        type: "post",
        success: function (json) {
            fill_courses(json);
        }
    });


});
function fill_courses(json){
    courses.hideLoading();
    courses_start.hideLoading();
    var option = {
        title: {
            text: ''
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['预定','退订']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : json.courses
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'预定',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:json.book
            },
            {
                name:'退订',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:json.unbook
            }
        ]
    };
    var option2 = {
        title: {
            text: ''
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['上课','退课']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : json.courses_start
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'上课',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:json.learn
            },
            {
                name:'退课',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:json.quit
            }
        ]
    };

    courses.setOption(option);
    courses_start.setOption(option2);

}

function fill_learning_status(json){
    learning_status.hideLoading();

    var option = {
        title: {
            text: ''
        },
        tooltip: {},
        legend: {
            data:['成绩']
        },
        xAxis: {
            data: json.classNames
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: json.scores
        }]
    };

    learning_status.setOption(option);

}

function fill_balance_analysis(json){
    orgBalance.hideLoading();

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
                data: json.balance
            }
        ]
    };

    orgBalance.setOption(option);

}