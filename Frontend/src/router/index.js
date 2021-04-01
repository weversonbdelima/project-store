import Vue from 'vue'
import VueRouter from 'vue-router'
import Cadastro from '../views/Cadastro.vue'
import Catalog from '../views/Catalog.vue'
import Preview from '../views/Preview.vue'
import Register from '../views/Register.vue'
import Update from '../views/Update.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Catalog',
    component: Catalog
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/preview',
    name: 'Preview',
    component: Preview,
    props: true
  },
  {
    path: '/update',
    name: 'Update',
    component: Update,
    props: true
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/cadastro',
    name: 'Cadastro',
    component: Cadastro
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
