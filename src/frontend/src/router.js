import Vue from 'vue'
import VueRouter from 'vue-router'
import AuthService from './AuthService'

import Home from './pages/Home.vue'
import CreateGame from './pages/CreateGame.vue'
import PlayerGameView from './pages/PlayerGameView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    component: Home,
    name: 'Home'
  },
  {
    path: '/createGame',
    component: CreateGame,
    name: 'Neues Spiel erstellen'
  },
  {
    path: '/games',
    component: PlayerGameView,
    name: 'Spieleübersicht'
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.name !== 'Home' && !AuthService.isAuthenticated()) next({ path: '/' })
  else next()
})

export { routes }
export default router