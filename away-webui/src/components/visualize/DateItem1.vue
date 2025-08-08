<template>
  <div class="DateItem1">
    <div class="header">该年订单</div>
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
      url: "/visualize/saleorder/list",
      method: "get",
    }).then((res) => {
      this.setdata(res.data);
    });
  },
  methods: {
    setdata(data) {
      data.forEach((item) => {
        this.xdata.push(item.month);
        this.ydata.push(item.order_count);
      });
      this.updateChart(); 
    },
    updateChart() {
      if (this.myChart) {
        let option = {
          xAxis: {
            type: "category",
            data: this.xdata,
          },
          yAxis: {
            type: "value",
          },
          series: [
            {
              data: this.ydata,
              type: "line",
              smooth: true,
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
