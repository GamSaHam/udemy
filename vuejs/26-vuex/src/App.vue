<template>
    <div class="container">
        
        <p>count - {{this.$store.state.count}}</p>
        <p>todosCount - {{this.$store.getters.doneTodosCount}}</p>
        <p>doneTodosCount - {{doneTodosCount}}</p>
        <button @click = "increase()">increase</button>
        <button @click = "increasePayload(10)">increase(payload)</button>
        <button @click = "increaseDispatch()">increaseDispatch()</button>

        <hr>
        <p>module a count - {{this.$store.state.a.count}}</p>        
        <p>module b count - {{this.$store.state.b.count}}</p>        
        
    </div>
</template>

<script>
    import {mapGetters} from "vuex";

    export default {
        methods:{
            increase(){
                this.$store.commit('increment');
            },
            increasePayload(payload){
                this.$store.commit('increasePayload',{amount: payload});
            },
            increaseDispatch(){
                this.$store.dispatch('increment');

            }

        },
        computed:{
            myMessage : function(){
                
                return this.$store.state.count;
            }
        },
        computed: mapGetters({
            doneTodosCount:'doneTodosCount'
        })
        

        
    
    }
</script>

