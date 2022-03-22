<template>
    <div>
        <v-form>
            <v-container>
                <h1>Login</h1>
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
    import AuthService from '@/AuthService.js'
    //const axios = require("axios")
    export default {
        name: 'Login',
        data() {
            return {
                sending: false,
                username: "",
                password: "",
                msg: ""
            }
        },
        methods: {
            // login: function()
            // {
            //     this.sending = true
            //     axios.post('/api/auth/login',
            //     {
            //         "loginName":"Admin",
            //         "password":"admin"
            //     })
            //     .then(function (response) {
            //         localStorage.accessToken = response.data.token
            //         localStorage.userData = response.data
            //     })
            // }
            async login() {
                try {
                    const credentials = {
                        loginName: this.username,
                        password: this.password
                    }
                    const response = await AuthService.login(credentials)
                    this.msg = response.msg

                    const token = response.token
                    const user = response.user

                    this.$store.dispatch('login', {token, user})

                    this.$router.push('/')
                } catch (error) {
                    this.msg = error.response.data.msg
                }
            }
        }
    }
</script>

<style>
</style>