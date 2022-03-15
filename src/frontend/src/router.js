import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from './pages/Login.vue'
import Register from './pages/Register.vue'
import Home from './pages/Home.vue'
import CreateGame from './pages/CreateGame.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    component: Home
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/register',
    component: Register
  },
  {
    path: '/createGame',
    component: CreateGame
  }
]

export default new VueRouter({
  routes
})