import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    redirect: '/admin'
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import( '../views/Login.vue')
  },
  {
    path: '/admin',
    name: 'Admin',
    component: () => import('../views/Admin.vue'),
    children: [
      {
        path: '/user',
        name: 'User',
        component: () => import('../views/User.vue')
      },
      {
        path: '/pets',
        name: 'Pets',
        component: () => import('../views/Pets.vue')
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
