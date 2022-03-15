<template>
  <div>
    <v-form>
      <v-container>
        <v-text-field v-model="gameName" label="Name des Spiels" required>
        </v-text-field>
        <v-text-field
          v-model="creatorNickname"
          label="Eigener Nickname"
          required
        >
        </v-text-field>
        <v-btn color="primary" @click="clickCreateGame" class="float-right">
          Spiel erstellen
        </v-btn>
      </v-container>
    </v-form>
  </div>
</template>

<script>
import GameService from '@/GameService.js'
export default {
  name: 'CreateGame',
  data() {
    return {
      gameName: '',
      creatorNickname: ''
    }
  }, methods: {
    clickCreateGame() {
      const response = this.createGame()
      response.then(response => {
        console.log(response.code);
        this.joinGameAsLeader(response.code)
      })
    },
    async createGame() {
      try {
        const data = {
          name: this.gameName
        }
        const response = await GameService.createGame(data)
        return response
      } catch (error) {
        this.msg = error.response.data.msg
      }
    },
    async joinGameAsLeader(code) {
      try {
        const data = {
          claimLeaderShip: true,
          nickName: this.creatorNickname
        }
        const response = await GameService.joinGameAsLeader(data, code)
        this.msg = response.msg
      } catch (error) {
        this.msg = error.response.data.msg
      }
    }
  }
}
</script>

<style>
</style>