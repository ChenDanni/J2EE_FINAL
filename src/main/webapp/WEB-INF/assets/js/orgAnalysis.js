/**
 * Created by cdn on 17/3/14.
 */
var recruit = echarts.init(document.getElementById("recruit-analysis"));
recruit.showLoading();
$(document).ready(function(){

    var data = {};

    jQuery.ajax({
        //async: true,
        data: data,
        url: "org_recruit_analysis",
        type: "post",
        success: function (json) {
            console.log(json);
            fill_recruit(json);
        }
    });
});

function fill_recruit(json){
    recruit.hideLoading();

    // app.title = '坐标轴刻度与标签对齐';

    var option = {
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
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
                data : json.orgName,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'招生人数',
                type:'bar',
                barWidth: '60%',
                data:json.recruitNum
            }
        ]
    };


    recruit.setOption(option);

}