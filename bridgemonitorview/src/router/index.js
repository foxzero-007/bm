import Vue from 'vue'
import Router from 'vue-router'
import TestLogin from '@/components/testlogin/TestLogin'
import TestResult from '@/components/testlogin/TestResult'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'TestLogin',
      component: TestLogin
    },
    {
      path: '/TestResult',
      name: 'TestResult',
      component: TestResult
    }
  ]
})
