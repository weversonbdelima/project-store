import api from '../../services/api';
export default {
  name: 'card',
  components: {},
  props: {
    produto: {},
    file: ''
  },
  data () {
    return {

    }
  },
  computed: {

  },
  mounted () {
    this.onChangeFile();
  },
  methods: {
      async onChangeFile(){
        var response =  await api.get('/produto/files/' +this.produto.imagem,{
          responseType: 'arraybuffer'
        }).then(response => Buffer.from(response.data, 'binary').toString('base64'));
        
        var formated = this.getFormatedFile(this.produto.imagem);

        response = 'data:image/'+formated+';base64,'+ response;
        this.file = response;
      },
      getFormatedFile: function(file){
        var formated = file.split('.');
        return formated[1];
      },
      handleOnClick: function(){
        this.$router.push({name: 'Preview', params: {produto: this.produto, file: this.file} });
      }
  }
}


