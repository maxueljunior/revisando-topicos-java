# language: pt

@leilao
Funcionalidade: Cadastrando um leilao

  Contexto:
    Dado um usuario logado

  Cenario: Um usuario logado pode cadastrar um leilao
    Quando acessa a pagina de novo leilao
    E prenche o formulario com dados validos
    Entao volta para a pagina de leiloes
    E o novo leilao aparece na tabela
  
  Cenario: Um usuario logado pode editar um leilao feito por ele
    Quando acessa a pagina de um leilao existente
    E edita o formulario com dados validos
    Entao entao volta para a pagina de leiloes
    E o leilao editado aparece na tabela