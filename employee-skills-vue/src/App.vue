<template>

    <div id="app">
        <router-link :to="{ name: 'home' }" tag="a" exact>[   Home   ]</router-link>
        <router-link :to="{ name: 'display' }" tag="a">[   List All Employees   ]</router-link>
        <router-link :to="{ name: 'add' }" tag="a">[   Add Employee   ]</router-link>
         <router-view/>
    </div>
</template>

<script>
import Home from './components/Home.vue'

export default {
name: 'app',
components: Home
}

  

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
