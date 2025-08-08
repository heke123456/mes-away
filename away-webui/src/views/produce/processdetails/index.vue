<template>
  <div class="zone-container">
    <processingprocess/>
    <materialListOfTechnology/>
  </div>
</template>

<script>
import MaterialListOfTechnology from "./components/MaterialListOfTechnology/index";
import Processingprocess from "./components/processingprocess/index"
export default {
  name:"ProcessDetails",
  components:{
    "processingprocess":Processingprocess,
    "materialListOfTechnology":MaterialListOfTechnology
  }
}
</script>

<style>
.zone-container{
  height: 100%;
}
</style>
