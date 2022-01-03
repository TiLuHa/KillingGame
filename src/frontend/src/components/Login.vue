<template>
    <div id="formDiv">
        <form class="md-layout">
            <div class="md-layout-item"/>
            <md-card class="md-layout-item md-size-25 md-small-size-100">
                <md-card-header>
                    <div class="md-title">Users</div>
                </md-card-header>
                <md-card-content>
                    <md-field>
                        <label>Username</label>
                        <md-input></md-input>
                    </md-field>
                    <md-field>
                        <label>Password</label>
                        <md-input type="password"></md-input>
                    </md-field>
                </md-card-content>
                <md-card-actions>
                    No Account yet? <a href=""> Create one here!</a>
                    <md-button type="submit" class="md-primary" :disabled="sending">Login</md-button>
                </md-card-actions>
            </md-card>
            <div class="md-layout-item"/>
        </form>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        register: function(){
            console.log("awdawda")
        }
    }
</script>

<style>
</style>