import Vue from 'vue'
import Vuex from "vuex";
import App from './App.vue'


Vue.use(Vuex);

const store = new Vuex.Store({
    state:{
        todos : [
          {id : 1, text: '...', done: true},
          {id : 2, text: '...', done: false}
        ]
    },
    mutations: {  // store.commit('increment')
        increment(state){
            state.count++;
        }
    },
    getters : {
      doneTodos: state => {
        return state.todos.filter(todo => todo.done)
      },
      doneTodosCount: (state, getters) =>{
        return getters.doneTodos.length;
      }
    }


})






new Vue({
  el: '#app',
  store,
  render: h => h(App)
})
