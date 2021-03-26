import api from "../../services/api"

export default {
  name: 'produto',
  components: {},
  props: {
    produto: {
      nome: String,
      preco: Number,
      descrisao: String,
      imagem: String
    }
  },
  data () {
    return {
      file: '',
      fileImage: ''
    }
  },
  computed: {

  },
  mounted () {
    
  
  },
  beforeMount(){
    this.onFileLoad()
  }
  ,
  methods: {
    async onFileLoad(){
      var response =  await api.get('/produto/files/' +this.produto.imagem,{
        responseType: 'arraybuffer'
      }).then(response => Buffer.from(response.data, 'binary').toString('base64'));
      
      response = 'data:image/jpeg;base64,'+ response;
      this.file = response;
    },
  }
}


