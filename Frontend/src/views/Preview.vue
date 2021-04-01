<template>
    <div class="preview">
        <div class="grid-container">
            <img class="item-image" v-bind:src="file"/>
            <div class="item-content">
                <h1>{{produto.nome}}</h1>
                <h3>R$ {{produto.preco}}</h3>
                <button v-on:click="handleOnClickUpdate">Atualizar</button>
                <button v-on:click="handleOnClickDelete">Deletar</button>
            </div>
            <div class="item-descrisao">
                <p>{{produto.descrisao}}</p>    
            </div>       

        </div>
    </div>
</template>

<script>
import api from '../services/api'
export default {
    name: 'Preview',
    props: {
        produto: {},
        file: String
    },
    data (){
        return{
        }
    },
    mounted (){
    },
    methods: {
        handleOnClickDelete: async function() {
            await api.delete('/produto/'+this.produto.id);
            this.$router.push({path: '/'});
        },
        handleOnClickUpdate: async function () {
            this.$router.push({name: 'Update', params: {produto: this.produto, file: this.file} });
        }
    }

}
</script>

<style>
   .grid-container{
       display: grid;
       grid-template-columns: repeat(2, 1fr);
       grid-template-rows: 2fr 1fr;
       padding: 40px;
   }

   .item-descrisao{
       grid-column: 1/3;
   }

   @media only screen and (max-width: 600px) {
        .grid-container{
            display: flex;
            flex-direction: column;
        } 
   }
   
</style>