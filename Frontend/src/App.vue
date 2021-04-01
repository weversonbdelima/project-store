<template>
  <div id="app">
    <Navbar/>
    <div class="container">
       <router-view/>
    </div>

    <Footer/>
  </div>
</template>


<script>
import Navbar from './components/Navbar'
import Footer from './components/Footer'

export default {
  name: 'App',
  components:{
    Navbar,
    Footer
  }
}
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,900;1,700&display=swap');
body{
  margin: 0;
  padding: 0;

  --primary-color: #ffffff;
  --second-color: #000000;
  --ternary-color: #8338EC;
  --quartenary-color: #FF006E;

  box-sizing: border-box;

}

a{
  text-decoration: none;
  color: var(--primary-color);
}
#app {
  font-family: 'Roboto', Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  background: var(--primary-color);
  display: flex;
  flex-direction: column;  
  justify-content: space-between;
  height: 100vh;
  
}


</style>
