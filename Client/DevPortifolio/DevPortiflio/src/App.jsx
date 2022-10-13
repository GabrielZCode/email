import { Header, Home, SideBar, Skills, Education, Contact} from './components'
function App() {
 // Incluir animações de transição de página, set de cores de acordo com os background-image e resposividade
 // Para telas menores a Header deve ser uma SideBar escondida e a SideBar convencional deve ser mantida
  return (
    <div className="App">
      //Header
      <Header></Header>
      // Home Page -- background image + Nome+ Apresentação Rápida
      <Home></Home>
      // Side Bar com Linkedin / E-mail e telefone      
      <SideBar></SideBar>
      // Segunda pagina --Skills + popups descritivo + background image
      <Skills></Skills>
      // Educação e Experiencia
      <Education></Education>
      // Contact-Me Form de contato chamando a rest API para registro, e envio de e-mail para eu e para a pessoa
     <Contact></Contact>
    </div>
  )
}

export default App
