<template>
    <div id="formDiv">
        <form class="md-layout">
            <div class="md-layout-item"/>
            <md-card class="md-layout-item md-size-25 md-small-size-100">
                <md-card-header>
                    <div class="md-title">Login</div>
                </md-card-header>
                <md-card-content>
                    <md-field>
                        <label>Username</label>
                        <md-input v-model="username"></md-input>
                    </md-field>
                    <md-field>
                        <label>Email</label>
                        <md-input v-model="email"></md-input>
                    </md-field>
                    <md-field>
                        <label>Password</label>
                        <md-input type="password" v-model="password"></md-input>
                    </md-field>
                    <md-field>
                        <label>Confirm Password</label>
                        <md-input type="password" v-model="passwordConfirmation"></md-input>
                    </md-field>
                </md-card-content>
                <md-card-actions>
                    <md-button type="submit" class="md-primary" :disabled="sending" v-on:click="register()">Register</md-button>
                </md-card-actions>
            </md-card>
            <div class="md-layout-item"/>
        </form>
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