<template>
  <div>
    <v-btn @click="getGames">Click Me</v-btn>
    <v-list>
      <v-list-item-group v-model="selectedItem">
        <v-list-item v-for="(game, g) in games" :key="g">
          <v-list-item-content>
            <h1>{{game.name}}</h1>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </div>
</template>

<script>
import GameService from '@/GameService.js'
export default {
  name: 'PlayerGameView',
  data() {
    return {
      games: '',
      selectedItem: ''
    }
  }, methods: {
    getGames() {
      const response = GameService.getGames()
      response.then(response => {
        console.log(response)
        this.games = response
      })
    }
  }
}
</script>

<style>
</style>