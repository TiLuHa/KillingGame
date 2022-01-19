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
                    v-model="email"
                    label="Email"
                    required
                ></v-text-field>
                <v-text-field
                    v-model="password"
                    label="Password"
                    required
                    type="password"
                ></v-text-field>
                <v-text-field
                    v-model="passwordConfirmation"
                    label="Confirm Password"
                    required
                    type="password"
                ></v-text-field>
                    <v-btn
                        color="primary"
                        @click="login"
                        class="float-right"
                    >
                        Register
                    </v-btn>
            </v-container>
        </v-form>
    </div>
</template>

<script>
    const axios = require("axios")
    export default {
        name: 'Register',
        data() {
            return {
                sending: false,
                username: "",
                email: "",
                password: "",
                passwordConfirmation: ""
            }
        },
        methods: {
            login: function()
            {
                axios.post('/api/auth/login',
                {
                    "loginName":"Admin",
                    "password":"admin"
                })
                .then(function (response) {
                    localStorage.accessToken = response.data.token
                })
            }
        }
    }
</script>

<style>
</style>