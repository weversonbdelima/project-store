import api from '../../services/api'

export default {
  name: 'cadastro',
  components: {},
  props: [],
  data () {
    return {
      nome: '',
      preco: 0,
      descrisao: '',
      file: {
        name: '',
        selected: ''
      }
    }
  },
  computed: {

  },
  mounted () {

  },
  methods: {
    handleOnFileSelected(e){
      this.file.name = e.target.files[0].name;     
      this.file.selected = e.target.files[0];
    },
    onFileUpload(){
      var formData = new FormData();
      formData.append('file', this.file.selected);

      api.post("/produto/files", formData, {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      }).then(function(){
        console.log('sucesso');
      }).catch(function(){
        console.log('failure');
      })

      // const reader = new FileReader();

      // reader.onload = (e) =>{
      //   this.imagem = e.target.result;
      // };
      // reader.read
    },
    onDataUpload(){
      api.post('/produto',{
        nome: this.nome,
        preco: this.preco,
        descrisao: this.descrisao,
        imagem: this.file.name
      }).then(function(response){
        console.log(response);
      }).catch(function(error){
        console.log(error);
      });
    },
    handleOnSubmit: function(e){
   
      //Envia dados
      this.onDataUpload();
      //Envia o arquivo
      this.onFileUpload(this.file.selected);

      //Envia dados informado ao root que os dados foram atualizados
      this.$emit('updateData');
      e.preventDefault();
    },
  }
}


