<template>
  <div>
    <svg-icon icon-class="question" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'AwayDoc',
  data() {
    return {
      url: 'http://doc.away.vip/away-vue'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
