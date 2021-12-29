<template>
<div>
  <head>
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:400,500,700,400italic|Material+Icons">
</head>
KillingGame
<Login />
</div>
</template>

<script>
import Vue from 'vue'
import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'

Vue.use(VueMaterial)

import Login from './components/Login.vue'

export default {
  name: 'App',
  components: {
    Login
  }
}
</script>

<style>
  html, body {
    font-family: 'Roboto', sans-serif;
  }
</style>