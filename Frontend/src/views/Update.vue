<template>
    <div class="update">
      
       <form v-on:submit="handleOnSubmitForm">
           <h1> Atualizar </h1>
           <label for="nome">Nome</label>
           <input id="nome"  placeholder="Nome" v-model="produto.nome">
           <label for="preco"  >Preco</label>
           <input id="preco" type="number" placeholder="0,00" v-model="produto.preco"  >
           <label for="descrisao" >Descrição</label>
           <textarea id="descrisao" placeholder="Descrição" v-model="produto.descrisao"/>
           <label  for="file">Selecione o arquivo</label>
           <input type="file" id="file" accept="image/*" v-on:change="handleOnChangeFile">
           <img v-bind:src="file"/>
           <button type="submit">Registrar</button>
       </form>
    </div>
</template>

<script>
import api from '../services/api'
export default {
    name: 'Update',
    props: {
        produto: {},
        file: String
    },
    methods:{
         handleOnSubmitForm: function(event){
            //validação de formulário
            this.validatedForm();
            //Envia o objeto produto
            api.put('/produto/'+this.produto.id, this.produto);
            //Envia o arquivo
            api.post('produto/files', this.file);

            this.route.push({path: '/'})
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