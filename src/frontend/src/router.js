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
    name: 'Home',
    meta: { requiresAuth: false}
  },
  {
    path: '/createGame',
    component: CreateGame,
    name: 'Neues Spiel erstellen',
    meta: { requiresAuth: true}
  },
  {
    path: '/games',
    component: PlayerGameView,
    name: 'Spieleübersicht',
    meta: { requiresAuth: true}
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to) => {
  console.log(AuthService.isAuthenticated())
  if (to.meta.requiresAuth && !AuthService.isAuthenticated()) {
    return {
      path: '/',

      // query: { redirect: to.fullPath }
    }
  }
})

export { routes }
export default router