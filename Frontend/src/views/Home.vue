<template>
  <div class="home">

  </div>
</template>

<script>
// @ is an alias to /src

import api from '../services/api'
export default {
  name: 'Home',
  components: {

  },
   data () {
    return {
      produtos: [],
      file: ''
    }
  },
  methods: {
    onReceiverData(){
      api.get('/produto')
      .then(response => (this.produtos = response.data));

    }
  },
  mounted(){
    //Recebe dados
    //this.onReceiverData();

    this.produtos = [{nome: "tse",
      preco: 10,
      descrisao: "2322",
      imagem: "dasd"
    },
    {nome: "tse",
      preco: 10,
      descrisao: "2322",
      imagem: "dasd"
    },
    {nome: "tse",
      preco: 10,
      descrisao: "2322",
      imagem: "dasd"
    }]
    console.log('teste')
  }
}
</script>
<style>
  .grid-container{
    display: grid;
    grid-column-gap: 25px;
    grid-row-gap: 100px;
     grid-template-columns: auto auto auto;
  }
</style>