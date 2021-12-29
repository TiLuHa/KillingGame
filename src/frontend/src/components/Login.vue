<template>
    <div id="formDiv">
        <form class="md-layout">
            <div class="md-layout-item"/>
            <md-card class="md-layout-item md-size-50 md-small-size-100">
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
            </md-card>
            <div class="md-layout-item"/>
        </form>
    </div>
</template>

<script>
    export default {
        name: 'Login'
    }
</script>

<style>

</style>