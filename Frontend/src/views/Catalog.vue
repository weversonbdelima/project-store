<template>
  <div class="catalog">
    <div class="catalog-header">
      <h3>Lorem ipsium</h3>
    </div>
    <div class="catalog-container" v-for="produto in produtos" v-bind:key="produto.id">
      <Card v-bind:produto="produto"/> 
      <Card v-bind:produto="produto"/> 
      <Card v-bind:produto="produto"/> 
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Card from '../components/Card'
import api from '../services/api'

export default {
  name: 'Home',
  components: {
    Card
  },
  data(){
    return{
      produtos: {}
    }
  },
  async mounted(){
    this.produtos = await this.getProdutos();
  },
  methods:{
    getProdutos: async function(){
      let response = await api.get('/produto');      
      return response.data;
    }
  }
}
</script>

<style>
.catalog{
  padding: 40px;
}

.catalog-header h3{
  color: var(--ternary-color);
  font-size: 32px;
  font-weight: 700;
  margin: 0 0 70px 0;
}
 .catalog-container{
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-auto-rows: minmax(75px, auto);
    grid-gap: 50px 20px;
  }

 @media only screen and (max-width: 600px){
  
  .catalog-container{
     display: flex;
     flex-direction: column;
     align-items: center;
  }
 

 }
</style>