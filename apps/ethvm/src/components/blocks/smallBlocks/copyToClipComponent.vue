<template>
  <v-icon class="fa fa-copy accent--text" v-on:click="copyToClip(valueToCopy)"></v-icon>
</template>

<script lang="ts">
import copyClip from 'clipboard-copy'
import Vue from 'vue'

export default Vue.extend({
  props: {
    valueToCopy: String
  },
  data() {
    return {}
  },
  methods: {
    copyToClip(newVar) {
      const status = copyClip(newVar)
    }
  }
})
</script>

<style scoped lang="less">
@import '~lessPath/sunil/blocks/smallBlocks/component.less';
</style>
