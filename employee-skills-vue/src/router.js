import Vue from 'vue'
import Router from 'vue-router'
import Home from './components/Home.vue'
import Display from './components/Display.vue'
import Add from './components/Add.vue'
import Detail from './components/Detail.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/display',
        name: 'display',
        component: Display
    },
    {
      path: '/display/:employeeID',
      name: 'display-detail',
      component: Detail
    },
    {
        path: '/add',
        name: 'add',
        component: Add
    }
  ]
})