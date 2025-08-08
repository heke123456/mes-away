<template>
  <div>
    <svg-icon icon-class="github" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'AwayGit',
  data() {
    return {
      url: 'https://gitee.com/y_project/Away-Vue'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
