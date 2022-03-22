<template>
    <div>
        <v-form>
            <v-container>
                <h1>Registrieren</h1>
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
                        @click="register"
                        class="float-right"
                    >
                        Register
                    </v-btn>
            </v-container>
        </v-form>
    </div>
</template>

<script>
    import AuthService from '@/AuthService.js'
    //const axios = require("axios")
    export default {
        name: 'Register',
        data() {
            return {
                sending: false,
                username: "",
                email: "",
                password: "",
                passwordConfirmation: "",
                msg: ""
            }
        },
        methods: {
            async register() {
                try{
                    const credentials = {
                        loginName: this.username,
                        email: this.email,
                        password: this.password
                    }
                    const response = await AuthService.signUp(credentials)
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