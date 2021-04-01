<template>
    <div class="preview">
        <div class="preview-container">
            <div class="grid-item title">
                <h1> {{$route.params.id}}</h1>
            </div>
            <div class="grid-item image">
                <img src="../assets/logo.png"/>
            </div>
            <div class="grid-item price">
                R$
                <span>170,00</span>
            </div>
            <div class="grid-item action">
                <button>Atualizar</button>
                <button>Deletar</button>
            </div>
            <div class="grid-item description">
                <h3>Descrição</h3>
                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                </p>
                
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Preview',
    data (){
        return{
            produto: ''
        }
    },
    methods:{
        searchProduto: function(){
            //parei aqui
        }
    }

}
</script>

<style>
    .preview{
        
    }
    .preview-container{
        max-width: 800px;
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-auto-rows: minmax(75px, auto);
        grid-gap: 15px;
    }
    .grid-item{
        padding: 20px;
    }

    .title{
        grid-column: 1/3;
        color: var(--ternary-color);
    }
    .image{
        grid-row: 2/4;
        display: flex;
        align-items: center;
    }
    .image img{
        margin: auto;
    }
    .price{
        grid-column: 2/3;
        color: #c8c8c8;
        font-weight: 700;
        font-size: 18px;
    }
    .price span{
        font-size: 28px;
        color: var(--quartenary-color);
    }

    .action{
        grid-column: 2/3;
        
    }
    .action button{
        margin: 0 10px;
    }

    .action button:hover{
        opacity: 0.7;
    }

    .description{
        grid-column: 1/3;
        color: #c8c8c8;
    }


   


    @media only screen and (max-width: 600px) {
        .preview-container{
            display: flex;
            flex-direction: column;
        }
    }
</style>