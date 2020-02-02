<template>
  <div>
    <h1>Filters & Mixins</h1>
    <hr />
    <input v-model="filterText" />
    <ul>
      <li v-for="fruit in filteredFruits" v-bind:key="fruit">{{ fruit }}</li>
    </ul>
  </div>
</template>

<script>
import { fruitMixin } from "./fruitMixin";

// mixins methid called frist and than call created method
export default {
  mixins: [fruitMixin],

  created() {
    console.log("Inside List Created Hook");
  }
};
</script>

<style></style>
