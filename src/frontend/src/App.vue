<template>
  <v-app>
    <v-app-bar app color="secondary" dark clipped-left>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>
        <!-- <router-link to="/"> -->
        KillingGame
        <!-- </router-link> -->
      </v-toolbar-title>

      <v-spacer />

      <v-menu v-if="this.$store.getters.isLoggedIn" offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-avatar color="accent" v-bind="attrs" v-on="on">
            <span class="white--text text-h5">CJ</span>
          </v-avatar>
        </template>
        <v-list>
          <v-list-item v-for="(item, index) in items" :key="index">
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
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
          <v-card>
            <login></login>
          </v-card>
        </v-dialog>

        <!-- Register Dialog -->
        <v-dialog>
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="accent" v-bind="attrs" v-on="on">
              Registrieren
            </v-btn>
          </template>
          <v-card>
            <register></register>
          </v-card>
        </v-dialog>
      </div>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" app clipped>
      <v-list nav dense>
        <v-list-item-group>
          <v-list-item>
            <router-link to="/createGame">
              <v-list-item-title>Neues Spiel erstellen</v-list-item-title>
            </router-link>
          </v-list-item>

          <v-list-item>
            <router-link to="/Games">
              <v-list-item-title>Spielübersicht</v-list-item-title>
            </router-link>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
import Login from './components/Login.vue';
import Register from './components/Register.vue';

export default {
  name: 'App',
  components: {
    Login,
    Register
  },
  data: () => ({
    drawer: false,
    items: [
      { title: 'Click Me' },
      { title: 'Click Me' },
      { title: 'Click Me' },
      { title: 'Click Me 2' },
    ]
  }),
  methods: {
    isLoggedIn() {
      return this.$store.getters.isLoggedIn
    }
  }
};
</script>
