import Vue from 'vue'
import Vuex from "vuex";
import App from './App.vue'


Vue.use(Vuex);


const moduleA = {
  state : {
    count: 1
  }
}

const moduleB = {
  state : {
    count : 2
  }
}


const store = new Vuex.Store({
    state:{
        todos : [
          {id : 1, text: '...', done: true},
          {id : 2, text: '...', done: false}
        ],
        count : 0
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
      },
      // getTodoById: (state) => (id) =>{
      //   return state.todos.find(todo => too.id === id)
      // }

    },
    mutations: {
      increment(state){

          state.count++;
      },
      increasePayload(state, payload){
          state.count += payload.amount;
      }

    },
    actions: {
      increment(context){
        context.commit('increment')
      }
    },
    modules: {
      a : moduleA,
      b : moduleB
    }

})


new Vue({
  el: '#app',
  store,
  render: h => h(App)
})
