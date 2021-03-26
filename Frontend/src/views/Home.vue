<template>
  <div class="home">
    <li v-for="produto in produtos" v-bind:key="produto.id">
      <Produto  v-bind:produto="produto"/>
    </li>
  </div>
</template>

<script>
// @ is an alias to /src
import Produto from '../components/Produto'
import api from '../services/api'
export default {
  name: 'Home',
  components: {
    Produto
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
