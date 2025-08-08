<template>
  <div class="zone-container">
    <processingprocessQr/>
    <materialListOfTechnology/>
  </div>
</template>

<script>
import MaterialListOfTechnology from "./components/MaterialListOfTechnology/index";
import ProcessingprocessQr from "./components/processingprocessQr/index"
export default {
  name:"ProcessDetailsTask",
  components:{
    "processingprocessQr":ProcessingprocessQr,
    "materialListOfTechnology":MaterialListOfTechnology
  }
}
</script>

<style>
.zone-container{
  height: 100%;
}
</style>
