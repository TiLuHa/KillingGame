import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from './pages/Home.vue'
import CreateGame from './pages/CreateGame.vue'
import PlayerGameView from './pages/PlayerGameView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    component: Home
  },
  {
    path: '/createGame',
    component: CreateGame
  },
  {
    path: '/Games',
    component: PlayerGameView
  }
]

export default new VueRouter({
  routes
})