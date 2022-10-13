
export const Header = () => {
  return (
    // fazer o Header ser um component fixed na tela
    // Fazer css editando as cores e disposição dos li e ajustar resposividade
    // Para celular fazer SideBar
     <Header>
       <div className="LeftSide">
        // incluir icon ou svg de Home para voltar a HomePage 
      </div>
       <div className="Rigthside">
         <ul>
          <li><a>Skills</a></li>
          <li><a>Experiência</a></li>
          <li><a>Contate-Me</a></li>
        </ul>
      </div>
    </Header>
   )
}
