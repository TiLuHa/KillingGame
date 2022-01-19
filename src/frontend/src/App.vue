<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
      clipped-left
    >
    
    <v-app-bar-nav-icon 
      @click.stop="drawer = !drawer"
    ></v-app-bar-nav-icon>

    <v-toolbar-title>KillingGame</v-toolbar-title>

    <v-spacer />

    <v-menu offset-y>
      <template v-slot:activator="{on, attrs}">
        <v-avatar
          color="accent"
          v-bind="attrs"
          v-on="on"
        >
          <span class="white--text text-h5">CJ</span>
        </v-avatar>
      </template>
      <v-list>
        <v-list-item
          v-for="(item, index) in items"
          :key="index"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
    

    </v-app-bar>

    <v-navigation-drawer
      v-model="drawer"
      app
      clipped
    >
      <v-list
        nav
        dense
      >
        <v-list-item-group>
          
          <router-link to="/login">
            <v-list-item>
              <v-list-item-title>Login</v-list-item-title>
            </v-list-item>
          </router-link>
          
          <router-link to="/register">
            <v-list-item>
              <v-list-item-title>Register</v-list-item-title>
            </v-list-item>
          </router-link>

          <v-list-item>
            <v-list-item-title>Fizz</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Buzz</v-list-item-title>
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

export default {
  name: 'App',

  components: {
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
};
</script>
