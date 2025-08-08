<template>
  <div class="DateItem1">
    <div class="header">公司部门分布</div>
    <div class="echars" ref="myChart"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import request from "@/utils/request";
export default {
  data() {
    return {
      xdata: [],
      ydata: [],
      myChart: null, // 用于存储ECharts实例
    };
  },

  created() {
    request({
      url: "/visualize/Dept/list",
      method: "get",
    }).then((res) => {
      this.setdata(res.data);
    });
  },
  methods: {
    setdata(data) {
      data.forEach((item) => {
        this.xdata.push(item.dept_name);
        this.ydata.push(item.count);
      });
      this.updateChart();
    },
    updateChart() {
      if (this.myChart) {
        let option = {
          tooltip: {
            trigger: "axis",
            axisPointer: {
              type: "shadow",
            },
          },
          grid: {
            left: "3%",
            right: "4%",
            bottom: "3%",
            containLabel: true,
          },
          xAxis: [
            {
              type: "category",
              data: this.xdata,
              axisTick: {
                alignWithLabel: true,
              },
            },
          ],
          yAxis: [
            {
              type: "value",
              min: 0, // 设置刻度线的最小值
              max: 50, // 设置刻度线的最大值
              axisTick: {
                interval: 5, // 设置刻度之间的间隔为50
              },
              axisLine: {
                lineStyle: {
                  width: 2, // 刻度线宽度
                  type: "dashed", // 刻度线类型
                },
              },
            },
          ],
          series: [
            {
              name: "人数",
              type: "bar",
              barWidth: "60%",
              data: this.ydata,
            },
          ],
        };
        this.myChart.setOption(option);
      }
    },
  },

  mounted() {
    this.myChart = echarts.init(this.$refs.myChart); // 初始化ECharts实例
    this.updateChart(); // 在mounted时调用更新图表，确保在数据到达之前至少初始化图表
  },
};
</script>

<style scoped>
.DateItem1 {
  background-color: rgb(238, 233, 233);
}

.header {
  text-align: center;
  height: 15%;
  width: 100%;
}

.echars {
  height: 85%;
  width: 100%;
}
</style>
