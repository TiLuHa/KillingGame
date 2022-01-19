import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import vuetify from './plugins/vuetify'

import Login from './components/Login.vue'
import Register from './components/Register.vue'

Vue.config.productionTip = false
Vue.use(VueRouter)



const routes = [
  {path: '/login', component: Login},
  {path: '/register', component: Register}
]

const router = new VueRouter({
  routes
})

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
