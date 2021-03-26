<template>
  <div id="app">
      <header>
        <nav id="navbar" class="navbar navbar navbar-light" >
          <div class="container-fluid">
            <router-link class="navbar-brand" to="/">
              <img src="./assets/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
              Home
            </router-link>
     
          
          <ul class="navbar-nav">
            <li class="nav-item">
              <router-link class="nav-link" to="/cadastro">Cadastro</router-link>
            </li>    
          </ul>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
            <button class="btn btn-primary" type="submit">Buscar</button>
          </form>
         </div>
        </nav>
      </header>
      <div class="container">
            <router-view/>
      </div>

  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  background: var(--bs-blue);
}

#navbar {
  background-color: #e3f2fd;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
