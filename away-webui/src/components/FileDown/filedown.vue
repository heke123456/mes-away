<template>
  <div>
  <el-carousel :interval="4000" type="card" height="200px">
    <el-carousel-item v-for="item in files" :key="item.getUrl()">
      <el-image v-if="['image/jpeg','image/png','image/gif'].includes(item.getType())" :src="item.getUrl()" :preview-src-list="[item.getUrl()]">
      </el-image>
      <div v-else-if="item.getType()=='application/pdf'"  @click="loadPdf(item.getUrl())">
        <pdf :src="item.getUrl()" :page="1" style="width: 100%" > </pdf>
      </div>
      <div v-else  @click="item.fileDown()">{{ item.getFileName() }}</div>
    </el-carousel-item>
  </el-carousel>
  <el-dialog title="pdf" :visible.sync="open_pdf" :modal="false">
    <div class="pdf_list">
      <!-- src:pdf地址，page: 当前显示页 -->
      <pdf v-for="i in numPages" :key="i" :src="src" :page="i" style="width: 100%" > </pdf>
    </div>
  </el-dialog>
  </div>
</template>


<script>
import pdf from  'vue-pdf';
export default {
  name:"filedown",
  components: {
     pdf,
  },
  data () {
    return {
    src: '',
    numPages: undefined,
    open_pdf: false
    }
  },
  props: ['files'], //passvalue是父组件传递给子组件的参数
  methods: {
        loadPdf (url) {
            this.src = pdf.createLoadingTask(url)
            this.src.promise.then(pdf => {
                this.numPages = pdf.numPages // 这里拿到当前pdf总页数
            })
            this.open_pdf = true;
        },
        closePdf() {
          this.open_pdf = false;
        }

    }
}
</script>

<style>
.pdf_wrap {
  background: #fff;
  height: 100vh;
  position:absolute;
  top: 0px;
 }
 .pdf_list {
  height: 100vh;
  overflow: scroll;
 }
 .close {
     position: absolute;
     left: 0;
     bottom: 0;
     height: 40px;
     width: 100%;
     line-height: 40px;
     text-align: center;
     color:#367CFD;
     font-size:12px;
     background: #fff;
 }
</style>
