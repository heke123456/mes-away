<template>
  <div class="app-container">
    <Head class="head"> </Head>
    <div class="SmartScreen">
      <div class="mian">
        <DateItem1 class="DateItem"></DateItem1>
        <DateItem2 class="DateItem"></DateItem2>
        <DateItem3 class="DateItem"></DateItem3>
        <DateItem4 class="DateItem"></DateItem4>
        <DateItem5 class="DateItem"></DateItem5>
        <DateItem6 class="DateItem"></DateItem6>
      </div>
    </div>
  </div>
</template>

<script>
import Head from "@/components/visualize/Head.vue";
import DateItem1 from "@/components/visualize/DateItem1.vue";
import DateItem2 from "@/components/visualize/DateItem2.vue";
import DateItem3 from "@/components/visualize/DateItem3.vue";
import DateItem4 from "@/components/visualize/DateItem4.vue";
import DateItem5 from "@/components/visualize/DateItem5.vue";
import DateItem6 from "@/components/visualize/DateItem6.vue";
export default {
  components: {
    Head: Head,
    DateItem1: DateItem1,
    DateItem2: DateItem2,
    DateItem3: DateItem3,
    DateItem4: DateItem4,
    DateItem5: DateItem5,
    DateItem6: DateItem6,
  },

  created() {
    console.log(this.screenWidth);
  },
  data() {
    return {
      screenWidth: document.body.clientWidth,
    };
  },

  mounted() {
    const that = this;
    window.onresize = () => {
      window.screenWidth = document.body.clientWidth;
      that.screenWidth = window.screenWidth;
    };
    // console.log('that.screenWidth',that.screenWidth)
  },

  watch: {
    screenWidth(newVal) {
      console.log("aaaaaaaaaaaaaaa");
      console.log("newVal", newVal);
      // window.onresize = function () {
      //   setTimeout(() => {
      //     location.reload(true);
      //   }, 300);
      // };
    },
  },
};
</script>

<style scope>
.SmartScreen {
  border-radius: 1%;
  width: 100%;
  background-color: #b2b7bb;
  padding: 0px 20px 0px 20px;
}

.mian {
  display: flex;
  /* 设置主轴体 */
  flex-direction: row;
  /*设置主轴上的排列方式  */
  justify-content: space-between;
  /* 换行 */
  flex-wrap: wrap;
  /* 侧轴 */
  align-items: center;
  margin-top: 20px;
  height: 80vh;
  width: 100%;
}

.DateItem {
  height: 30vh;
  width: 30%;
}
</style>
