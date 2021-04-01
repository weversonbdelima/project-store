<template>
    <div class="register">
      
       <form v-on:submit="handleOnSubmit">
           <h1> Register </h1>
           <label for="nome">Nome</label>
           <input id="nome"  placeholder="Nome" v-model="produto.nome">
           <label for="preco"  >Preco</label>
           <input id="preco" type="number" placeholder="0,00" v-model="produto.preco">
           <label for="descrisao" >Descrição</label>
           <textarea id="descrisao" placeholder="Descrição" v-model="produto.descrisao"/>
           <label  for="file">Selecione o arquivo</label>
           <input type="file" id="file" accept="image/*" v-on:change="handleOnChangeFile">
           <img v-bind:src="srcFile"/>
           <button type="submit">Registrar</button>
       </form>
    </div>
</template>

<script>
import api from '../services/api'
export default {
    name: 'Register',
    data (){
        return{
            produto: {
                nome: '',
                preco: '',
                descrisao: '',
                imagem: ''
            },
            file: new FormData(),
            srcFile: ''
        }
    },
    methods:{
        handleOnSubmit: function(event){
            //validação de formulário
            this.validatedForm();
            //Envia o objeto produto
            api.post('/produto', this.produto);
            //Envia o arquivo
            api.post('produto/files', this.file);
            event.preventDefault();
        },
        validatedForm(){
            var element = {
                nome: document.getElementById('nome'),
                preco: document.getElementById('preco'),
                descrisao: document.getElementById('descrisao'),
            }
            if(this.produto.nome == ''){
                element.nome.style.borderBottom = "solid 1px red"
            }
            if(this.produto.preco == ''){
                element.preco.style.borderBottom = "solid 1px red"
            }
            if(this.produto.descrisao == ''){
                element.descrisao.style.borderBottom = "solid 1px red"
            }
        },
        handleOnChangeFile: function(event){
            //Atribui o  nome da imagem ao objeto produto
            this.produto.imagem = event.target.files[0].name;
            //Carrega imagem no formulário
            this.onChangeFile(event.target.files[0]);
            //Adiciona ao objeto form data
            this.file.append('file', event.target.files[0]);
        },
        onChangeFile(fileObject){
             const reader = new FileReader();
                reader.onload = (e) =>{
                    this.srcFile = e.target.result;
            };
            reader.readAsDataURL(fileObject);
        }
    }
}
</script>

<style>
    .register{
        display: grid;
        grid-template-columns: repeat(3,1fr);
        padding: 10px;
    }
    h1{
        color: var(--ternary-color);
    }
    form{
        grid-column: 2/3;
        display: flex;
        flex-direction: column;
        
    }
    input{
        border: none;
        border-bottom: 1px solid var(--ternary-color);
        padding: 10px;
        margin: 20px 0;
    }
    textarea{
        border: none;
        border-bottom: 1px solid var(--ternary-color);
        padding: 10px;
        height: 100px;
        margin: 20px 0;
    } 

    img{
        width: 400px;
    }
    button{
        margin: 20px 0;
    } 
</style>