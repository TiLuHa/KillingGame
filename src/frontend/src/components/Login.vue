<template>
    <div>
        <v-form>
            <v-container>
                <v-text-field
                    v-model="username"
                    label="Username"
                    required
                ></v-text-field>
                <v-text-field
                    v-model="password"
                    label="Password"
                    required
                    type="password"
                ></v-text-field>

                <v-row>
                    <v-col>
                        <p>Noch keinen Benutzer? Erstell dir <router-link to="/register">hier</router-link> einen!</p>
                    </v-col>
                    <v-col>
                        <v-btn
                            color="primary"
                            @click="login"
                            class="float-right"
                        >
                            Login
                        </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-form>
    </div>
</template>

<script>
    const axios = require("axios")
    export default {
        name: 'Login',
        data() {
            return {
                sending: false,
                username: "",
                password: ""
            }
        },
        methods: {
            login: function()
            {
                this.sending = true
                axios.post('/api/auth/login',
                {
                    "loginName":"Admin",
                    "password":"admin"
                })
                .then(function (response) {
                    localStorage.accessToken = response.data.token
                    localStorage.userData = response.data
                })
            }
        }
    }
</script>

<style>
</style>