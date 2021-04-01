
export default {
  name: 'navbar',
  components: {},
  props: [],
  data () {
    return {
      btFlag: false
    }
  },
  computed: {

  },
  mounted () {

  },
  created(){
    window.addEventListener("resize", this.handleEventResize);
  },
  destroyed(){
    window.removeEventListener("resize", this.handleEventResize);
  }
  ,
  methods: {
    handleEventResize: function(){
      var navbarContent = document.getElementsByClassName("content")[0];
      if(window.innerWidth > 900){
        navbarContent.style.height= "auto";
        navbarContent.style.display = "flex";
        navbarContent.style.flexDirection = "row";
      }
      if(window.innerWidth < 600){
        navbarContent.style.display = "none";
      }
    },
    handleOnClick: function(){
      console.log('teste')
      //btFlag recebe o seu oposto
      this.btFlag = !this.btFlag;
      //navbarContent recebe o elemento
      var navbarContent = document.getElementsByClassName("content")[0];
      //Chama a função para verificar se o botão foi pressionado
      this.checkNavbarContent(navbarContent);
    },
    checkNavbarContent(element){
      if(this.btFlag == true){
        this.openNavbarContent(element);
      }else{
        this.closeNavbarContent(element);
      }
    }
    ,
    openNavbarContent: function(element){
        element.style.height = "auto";
        element.style.display = "flex";
        element.style.flexDirection = "column";
    },
    closeNavbarContent: function(element){
      element.style.height = "0";
      element.style.display = "none";
    },
  }
}


