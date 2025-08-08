<template>
  <div class="DateItem1">
    <div class="header">当前任务</div>
    <div class="echars" ref="myChart">
      <dv-scroll-board :config="config" />
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  data() {
    return {
      config: {
        header: ["订单号", "任务简称", "客户姓名"],
        data: [],
      },
    };
  },

  created() {
    this.getData();
  },

  methods: {
    getData() {
      request({
        url: "/visualize/Production/list",
        method: "get",
      })
        .then((res) => {
          // 打印原始数据，检查数据格式
          console.log("Original data:", res.data);
          let arr = this.convertToArray(res.data);
          // 打印转换后的数据，确保转换正确
          console.log("Converted data:", arr);
          this.config.data = arr;
          // 强制更新配置，确保视图更新
          this.config = { ...this.config };
        })
        .catch((error) => {
          console.error("Data fetching error:", error);
        });
    },

    convertToArray(data) {
      let resultArray = [];
      for (let key in data) {
        if (data.hasOwnProperty(key)) {
          let item = data[key];
          let id = item.id;
          let notes = item.notes || "";
          let name = item.name;
          resultArray.push([id, notes, name]);
        }
      }
      return resultArray;
    },
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
