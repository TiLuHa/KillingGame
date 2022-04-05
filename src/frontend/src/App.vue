<template>
  <v-app>
    <v-app-bar app color="secondary" dark clipped-left>
      <v-app-bar-nav-icon
        @click.stop="drawer = !drawer"
        v-if="isAuthed()"
      ></v-app-bar-nav-icon>

      <v-toolbar-title>
        <!-- <router-link to="/"> -->
        KillingGame
        <!-- </router-link> -->
      </v-toolbar-title>

      <v-spacer />

      <v-menu v-if="this.$store.getters.isLoggedIn" offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-avatar color="accent" v-bind="attrs" v-on="on">
            <span class="white--text text-h5">{{ username }}</span>
          </v-avatar>
        </template>
        <v-list>
          <v-list-item-group>
            <template v-for="(item, index) in items">
              <v-list-item :key="index" @click="logout">
                <v-list-item-title>{{ item.title }}</v-list-item-title>
              </v-list-item>
            </template>
          </v-list-item-group>
        </v-list>
      </v-menu>
      <div v-else>
        <!-- Login Dialog -->
        <v-dialog>
          <template v-slot:activator="{ on, attrs }">
            <v-btn outlined color="accent" v-bind="attrs" v-on="on">
              Anmelden
            </v-btn>
          </template>
          <v-card class="pa-10">
            <v-container>
              <v-row>
                <v-col>
                  <login></login>
                </v-col>
                <v-divider vertical></v-divider>
                <v-col>
                  <register></register>
                </v-col>
              </v-row>
            </v-container>
          </v-card>
        </v-dialog>

        <!-- Register Dialog -->
        <!-- <v-dialog>
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="accent" v-bind="attrs" v-on="on">
              Registrieren
            </v-btn>
          </template>
          <v-card>
            <register></register>
          </v-card>
        </v-dialog> -->
      </div>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" app clipped v-if="isAuthed()">
      <v-list nav dense>
        <template v-for="(route, index) in routes">
          <v-list-item :key="index" :to="route.path">
            <v-list-item-content>
              <v-list-item-title>
                {{ route.name }}
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </template>
      </v-list>
      <template v-slot:append>
        <div class="d-flex justify-center">
          <v-switch label="Darkmode" v-model="darkmode"></v-switch>
        </div>
      </template>
    </v-navigation-drawer>

    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
import Login from './components/Login.vue'
import Register from './components/Register.vue'
import { routes } from './router'
import AuthService from './AuthService'

export default {
  name: 'App',
  components: {
    Login,
    Register
  },
  data: () => ({
    drawer: false,
    items: [
      { title: 'Ausloggen', action: 'logout' }
    ],
    routes: routes,
    username: 'TG',
    darkmode: true
  }),
  methods: {
    logout() {
      this.$store.dispatch('logout')
    },
    isAuthed() {
      return AuthService.isAuthenticated()
    }
  }
};
</script>
