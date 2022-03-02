import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state () {
    return {
        token: ''
    }
  },
  getters: {
    getToken: (state) => {
       return state.token;
    }
  },
  mutations: {
     setToken(state, newToken) {
        state.token = newToken;
     }
  },
  actions: {
  },
  modules: {
  }
})
