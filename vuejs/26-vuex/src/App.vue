<template>
    <div class="container">
        
        <p>{{count}}</p>
        
        <p>{{this.$store.getters.doneTodos}}</p>
        <button @click = "increase()">increase</button>
        
    </div>
</template>

<script>
    export default {
        methods:{
            increase(){
                this.$store.state.count += 1;
            }
        },
        computed:{
            count(){
                return this.$store.state.count;
            }
        }
    
    }
</script>

