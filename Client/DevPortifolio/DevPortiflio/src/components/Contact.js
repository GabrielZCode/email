

export const Contact = () => {
  return ( 
    // Fazer requisição ao server em spring em POST enviando  E-mail para eu  , para a pessoa e cadastrando no Banco de Dados
     <Contact>
       <form onSubmit={POST} method="POST">
          <div>
          <input type={text} className="InputName"/> 
          <input type={text} className="InputEmail"/> 
          </div>
          <input type={text} className="Message"/>
          <input type={checkbox} className="CheckBox"/>
         <label for={CheckBox}>Você concorda com os <a><span>termos e condições</span></a></label>
        <ul>
          <li><a>32156154@mackenzista.com.br</a></li>
          <li><a> (11) 9 1030 0755</a></li>
          <li><a> Incluir Link  Linkedin</a></li>
        </ul>
      </form>
    </Contact>
   )
}
