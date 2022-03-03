import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state () {
    return {
        token: '',
        isLogin: true,
        isSP: true
    }
  },
  getters: {
    getToken: (state) => {
       return state.token;
    },
    getLoginStatus: (state) => {
      return state.isLogin;
    }
  },
  mutations: {
     setToken(state, newToken) {
        state.token = newToken;
     },
     changeLoginStatus(state)
     {
        state.isLogin = !state.isLogin;
     }
  },
  actions: {
  },
  modules: {
  }
})
