<template>
  <div class="DateItem1">
    <div class="header">产品库存</div>
    <div class="echars" ref="myChart"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import request from "@/utils/request";
export default {
  data() {
    return {
      data: [],
      xdata: [],
      ydata: [],
      myChart: null, // 用于存储ECharts实例
    };
  },

  created() {
    request({
      url: "/visualize/Product/list",
      method: "get",
    }).then((res) => {
      this.setdata(res.data);
    });
  },
  methods: {
    setdata(data) {
      this.data = data;
      this.updateChart();
    },
    updateChart() {
      if (this.myChart) {
        let option = {
          tooltip: {
            trigger: "item",
          },
          legend: {
            show: false,
          },
          series: [
            {
              name: "Access From",
              type: "pie",
              radius: ["40%", "70%"],
              avoidLabelOverlap: false,
              label: {
                show: false,
                position: "center",
              },
              emphasis: {
                label: {
                  show: true,
                  fontSize: 20,
                  fontWeight: "bold",
                },
              },
              labelLine: {
                show: false,
              },
              data: this.data,
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
