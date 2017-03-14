/**
 * Created by cdn on 17/3/15.
 */
var learn = echarts.init(document.getElementById("learn-analysis"));
learn.showLoading();
$(document).ready(function(){

    var data = {};

    jQuery.ajax({
        //async: true,
        data: data,
        url: "learn_analysis",
        type: "post",
        success: function (json) {
            console.log(json);
            fill_learn(json);
        }
    });
});

function fill_learn(json){
    learn.hideLoading();

    var option = {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['各课程均分']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: json.classname
        },
        series: [
            {
                name: '均分',
                type: 'bar',
                data: json.avg
            }
        ]
    };


    learn.setOption(option);

}