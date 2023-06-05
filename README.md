# Descrição do sistema:
   
    
O aplicativo que estamos desenvolvendo é uma rede social única que conecta empresários e iniciantes empreendedores,investidores, microempreendedores e especialistas. A ideia por trás do aplicativo é permitir que os usuários compartilhem ideias sobre empresas, produtos e serviços em um feed, e obtenham aprovação, críticas e elogios dos investidores.

Com este aplicativo, os usuários poderão compartilhar suas ideias sobre negócios e empreendedorismo com uma comunidade engajada e especializada, a fim de obter feedback construtivo. Os investidores terão a oportunidade de avaliar as ideias em tempo real e fornecer feedback valioso para os usuários, ajudando-os a ajustar seus conceitos e aprimorar suas ideias de negócios.

# Definição de funcionalidades 

**Caso de Uso 1: Cadastro de Usuário**

Descrição: Um usuário pode se cadastrar ao sistema. O usuário deve fornecer informações básicas, como nome, e-mail e senha, para criar uma nova conta. Além disso, o usuário deve ser capaz de inserir informações adicionais do perfil tais como foto de perfil e descrição.

Fluxo Principal:

* O usuário acessa a página de cadastro do sistema.
* O sistema exibe a tela de cadastro com campos para nome, e-mail, seleção de tipo de conta (pessoa física ou jurídica) e senha
* O usuário preenche os campos obrigatórios e clica em "Cadastrar".
* O sistema valida os dados inseridos pelo usuário.

Fluxo Alternativo:

Se o usuário cometer algum erro durante o preenchimento do formulário, o sistema deve exibir uma mensagem de erro e permitir que o usuário corrija as informações incorretas.

------------------------------------- 
**Caso de Uso 2: Login**

Descrição: o usuário deve colocar seu Email e senha para acessar o sistema.

Fluxo Principal:

* O usuário acessa a página de login do sistema.
* O sistema exibe a tela de login com campos para Email e senha.
* O usuário insere seu nome de usuário e senha e clica em "Login".
* O sistema valida as informações de login.
* Se as informações estiverem corretas, o sistema redireciona o usuário para a página inicial do sistema.

------------------------------------- 
**Caso de Uso 3: Tela de Perfil do usuário**

Descrição: Um usuário ver seu perfil no sistema para que possa ver suas informações, e publicações feitas por ele, além de poder editar seu perfil.

Fluxo Principal:

*	O usuário acessa a página de perfil do sistema.
*	O sistema exibe a tela de perfil do usuário com informações como foto de perfil, nome e lista de publicações realizadas.
*	O usuário pode visualizar e interagir com suas publicações, como editar ou excluí-las.
*	O usuário clica no botão "Editar Perfil".
*	O sistema exibe um formulário para editar informações do perfil, como nome, foto de perfil e outros campos opcionais.
*	O usuário pode preencher os campos desejados e clicar em "Atualizar" para atualizar suas informações de perfil.
*	O sistema valida as informações inseridas pelo usuário e exibe uma mensagem de confirmação de atualização de perfil

Fluxo Alternativo:

Se o usuário ainda não tenha publicações realizadas ainda.

*	O sistema exibe uma mensagem indicando que não há publicações para exibir.
*	O usuário pode optar por criar uma nova publicação a partir desta tela de perfil.
*	O sistema redireciona o usuário para a tela de criação de publicação

Fluxo Alternativo: 

Se o usuário não queria atualizar informações do seu Perfil.

*	O sistema exibe a tela de perfil do usuário com as informações existentes.
------------------------------------- 
**Caso de Uso 4: Tela de Publicação**

Descrição: Um usuário pode fazer uma nova publicação no formato de texto e podendo incluir imagem caso ele deseje. 

Fluxo Principal:

*	O usuário acessa a tela de publicação do sistema.
*	O sistema exibe um formulário para criação de nova publicação, com campos para título, texto.
*	O usuário preenche os campos desejados e clica em "Publicar".
*	O sistema valida os campos e exibe uma mensagem de confirmação da publicação realizada.
*	A nova publicação é adicionada à lista de publicações do usuário na tela de perfil.

Fluxo Alternativo:

O sistema detecta um erro na validação dos campos preenchidos pelo usuário.

*	O sistema exibe uma mensagem de erro indicando quais campos precisam ser corrigidos.
*	O usuário corrige os campos apontados e tenta publicar novamente.

Fluxo Alternativo:

O usuário decide não publicar nova publicação.

*	O sistema redireciona o usuário de volta à tela anterior sem salvar a nova publicação.
------------------------------------- 
**Caso de Uso 5: Tela Principal**

Descrição: O usuário decide ver as publicações de outros usuários e interagir com elas.

Fluxo Principal:

*	O usuário acessa a tela principal do sistema.
*	O sistema exibe uma lista com as publicações de outros usuários, incluindo título, texto e foto (se houver).
*	O usuário pode rolar a lista para baixo para visualizar mais publicações.
*	O usuário pode clicar no botão "Curtir" para dar um like na publicação.
*	O usuário pode clicar no botão "Responder" para adicionar um comentário à publicação.
*	O sistema exibe a opção para o usuário escrever o comentário.
*	O usuário escreve o comentário e clica em "Enviar".
*	O sistema valida o comentário e exibe a mensagem de confirmação.

Fluxo Alternativo:

O sistema não encontra nenhuma publicação para exibir.

*	O sistema exibe uma mensagem indicando que não há publicações disponíveis.

Fluxo Alternativo:

O usuário já curtiu a publicação anteriormente.

*	O sistema remove o like anterior.

Fluxo Alternativo:

O sistema detecta um erro na validação do comentário enviado pelo usuário.

* O sistema exibe uma mensagem de erro indicando que o comentário não pôde ser enviado e pede que o usuário corrija o erro.

Fluxo Alternativo: 

O usuário decide não enviar o comentário.

*	O sistema cancela a ação e volta a tela 	do fluxo principal.

------------------------------------- 
**Caso de Uso 6: Tela de pesquisa de publicação**

Descrição: O usuário decide pesquisar uma publicação.

Fluxo Principal:

*	O usuário acessa a tela de pesquisa de publicações do sistema.
*	O sistema exibe uma barra de pesquisa para o usuário digitar o termo de busca.
*	O usuário digita o termo de busca e clica em "Pesquisar".
*	O sistema valida o termo de busca e exibe uma lista de resultados da pesquisa com as publicações que correspondem ao termo buscado.
*	O usuário pode rolar a lista para baixo para visualizar mais resultados.
*	O usuário pode clicar em uma publicação da lista para visualizar os detalhes da publicação.

Fluxo Alternativo:

O sistema não encontra nenhuma publicação correspondente ao termo de busca.

*	O sistema exibe uma mensagem indicando que não há resultados para a pesquisa.

Fluxo Alternativo:

O usuário decide não visualizar os detalhes da publicação.

*	O sistema cancela a ação e volta a tela do fluxo principal.

Fluxo Alternativo: 

O sistema detecta um erro ao tentar exibir os detalhes da publicação selecionada pelo usuário.

*	O sistema exibe uma mensagem de erro indicando que não foi possível exibir os detalhes da publicação e pede que o usuário tente novamente mais tarde.
------------------------------------- 

Caso de uso: Menu Fixo na Tela

Ator principal: Usuário

Fluxo principal:

* O usuário visualiza o menu fixo na tela com 5 ícones: Início (casinha), Pesquisar (lupa), Adicionar (+), Perfil (bonequinho) e Sair (seta para a direita).
* O usuário clica no ícone "Início" (casinha).
* O sistema redireciona o usuário para o feed principal do aplicativo.
* O usuário clica no ícone "Pesquisar" (lupa).
* O sistema redireciona o usuário para a tela de pesquisa.
* O usuário clica no ícone "Adicionar" (+).
* O sistema permite ao usuário adicionar um novo post.
* O usuário clica no ícone "Perfil" (bonequinho).
* O sistema redireciona o usuário para a tela de perfil do usuário.
* O usuário clica no ícone "Sair" (seta para a direita).
* O sistema encerra a sessão do usuário e fecha o aplicativo.

Fluxo alternativo:

* No passo 3 do fluxo principal, o sistema detecta um erro ao redirecionar o usuário para o feed principal.
* O sistema exibe uma mensagem de erro e retorna ao passo 1 do fluxo principal.

Fluxo alternativo:

* No passo 5 do fluxo principal, o sistema detecta um erro ao redirecionar o usuário para a tela de pesquisa.
* O sistema exibe uma mensagem de erro e retorna ao passo 1 do fluxo principal.

Fluxo alternativo:

* No passo 7 do fluxo principal, o sistema detecta um erro ao permitir ao usuário adicionar um novo post.
* O sistema exibe uma mensagem de erro e retorna ao passo 1 do fluxo principal.

Fluxo alternativo:

* No passo 8 do fluxo principal, o sistema detecta um erro ao redirecionar o usuário para a tela de perfil.
* O sistema exibe uma mensagem de erro e retorna ao passo 1 do fluxo principal.

Fluxo alternativo:

* No passo 10 do fluxo principal, o sistema detecta um erro ao encerrar a sessão do usuário.
* O sistema exibe uma mensagem de erro e retorna ao passo 1 do fluxo principal.
----------------------------------------------------------------------------------

# Link do Figma: https://www.figma.com/file/nSiyio9tNPpJLvToDvIdPu/Untitled?node-id=0-1&t=L3aTWE0vK33XSWnS-0
## Tela de Login:
![IdeiaPitch](https://github.com/Luiz9910/project-mobile-/assets/81191099/ab093daa-165c-4b44-970c-7c9f948504ec)
## Tela de Cadastro:
![Register](https://github.com/Luiz9910/project-mobile-/assets/81191099/c14facba-da59-404d-a5d1-0bb99a5c0305)
## Perfil do Usuário:
![PROFILE](https://github.com/Luiz9910/project-mobile-/assets/81191099/c6aa84a7-7df3-4fe5-b7a9-61f19b81a9bf)
## Editar Perfil:
![EditPerfil](https://github.com/Luiz9910/project-mobile-/assets/81191099/2047df73-2ab8-4105-8564-7ec40cb665a0)
## Tela Principal:
![home](https://github.com/Luiz9910/project-mobile-/assets/81191099/24038fdd-310b-4f03-a09d-a6de8b940fd7)
## Tela Resposta Post:
![RespostaPost](https://github.com/Luiz9910/project-mobile-/assets/81191099/a96835fa-455f-41d4-adbb-5c79fc56d31a)
## Nova Publicação:
![new](https://github.com/Luiz9910/project-mobile-/assets/81191099/e08bf59c-002f-47c1-81cc-a3361db12808)
## Editar Publicação:
![04 06 2023_20 50 04_REC](https://github.com/Luiz9910/project-mobile-/assets/81191099/e27ff0cf-8d00-4202-af3c-5480f74f88f7)
## Tela de Pesquisa:
![pesquisar](https://github.com/Luiz9910/project-mobile-/assets/81191099/6def7685-b8d2-4c74-bded-f80f03ff9fb0)

# Diagrama UML Mobile 
![david4](https://user-images.githubusercontent.com/95968468/232264421-d6d84804-251f-4706-8fe5-a244530d76c7.png)
# Diagrama UML (Back-End)
![david3](https://user-images.githubusercontent.com/95968468/232264426-a0905ca6-0463-4523-b809-f783e18c660d.png)

# Api / Contrato JSON 
## EndPoints 
## EndPoint User
### Post/ authentication 
Esse endpoint é responsável por autenticação do usuário. 
#### Parâmetros: 
email: Email do usuário existente. 
password: senha do usuário existente e referente ao e-mail  
```
{
  "email": "luiz@gmail.com",
  "password": "Luiz1992@"
}
```
#### Respostas: 
Ok! 200 

Exemplo de resposta: 
```
{ 
  token: “dsnaujifdbsdjfnidosfusdjfmdsjifhisdkfjsdnifksdjfbsdujfiodsnfisdkfisdhfisjtttttttthhshshshsshshhghdg”  
} 
```
### Get / user/users
Esse endpoint é responsável por retornar todos os usuários que têm no sistema 
#### Parâmetros: 
search: name do usuário para procurar ele no banco de dados. 
```
{
  "search": "project"
}
```
#### Resposta:  
200! Ok 

Exemplo de resposta: 
```
[ 
  { 
    Id: 1, 
    name: “luiz”, 
    email: ”luiz@gmail.com”, 
    description: “empresa focada na área de tecnologia, com o objetivo programação aos iniciantes”, 
    Is_company: “true” 
  }, 
  { 
    Id: 2, 
    name: “lucas”, 
    email: ”lucas@gmail.com”, 
    description: “empresa focada na área de tecnologia, com o objetivo programação aos iniciantes”, 
    Is_company: “true” 
  } 
] 
```
### Get / user/{id}
Esse endpoint é responsável por retornar os dados do usuário a partir do id. 
#### Parâmetros:  
id: id do usuário para procurar ele no banco de dados. 
#### Resposta:  
200! Ok

Exemplo de resposta: 
```
{ 
  Id: 1, 
  name: “luiz”, 
  email: ”luiz@gmail.com”, 
  description: “empresa focada na área de tecnologia, com o objetivo programação aos iniciantes”, 
  Is_company: ”true” 
} 
```
### Post / user 
Esse endpoint é responsável por criar um usuário no sistema. 
####Parâmetros:
name: nome do usuário ou da empresa. 
email: E-mail do usuário ou da empresa. 
password: Senha do usuário ou da empresa. 
description: uma breve descrição do usuário ou da empresa. 
is_company: indicar se o usuário é uma empresa (true) ou não (false). 
```
{
  "name": "luiz",
  "email": "example@gmail.com",
  "password": "lucasdasd",
  "description": "Empresa de desenvolvimento de jogos",
  "is_company": "true"
}
```
#### Resposta: 
Created! 201 

Exemplo de resposta:  
```
{ 
  response: “user successfully saved” 
} 
```
### Put/ user/{id}
Esse endpoint é responsável por atualizar os dados do usuário no sistema de banco de dados. 
#### Parâmetros: 
Id: identificado do usuário a ser atualizado. 
name: nome do usuário ou empresa (opcional). 
description:  breve descrição da empresa (opcional). 
```
{
  "name": "luiz",
  "description": "Empresa de desenvolvimento de jogos",
  "is_company": "true"
}
```
#### Resposta: 
No content! 204 

### Delete / user/{id}
Esse endpoint é responsável por deletar um user do sistema de banco de dados. 
#### Parâmetros:
Id: para identificar o usuário que será removido. 
#### Resposta: 
Ok! 200  

Exemplo de resposta: 
```
{ 
  response: “Sucessfully deleted user” 
}  
```
### Get / project/projects/search="example"
Esse endpoint por retornar toda a lista de publicações cadastradas no sistema. 
#### Parâmetros:  
search: O usuário pode pesquisar por publicações relacionadas ao que deseja. 
```
{
  "search": "project dog"
}
```
#### Resposta:  
Ok! 200 

Exemplo de resposta:  
```
[ 
  { 
    id: 1, 
    title: “Exemple”, 
    body”: “Empresas interessadas para pasceria com um processo que envolve mobilidade urbana chame por esse e-mail para discutir sobre o assunto.”, 
    user_id: 1 
  }, 
  { 
    id: 2, 
    title: “exemple”, 
    body: “exemple”, 
    user_id: 2 
  } 
] 
```
### Get / project/{id}
Esse endpoint por retornar uma publicação cadastrada no sistema. 
#### Parâmetros:  
id: id referente ao projeto
#### Resposta:  
Ok! 200 

Exemplo de resposta:  
```
{ 
  id: 1, 
  title: “Exemple”, 
  body”: “Empresas interessadas para pasceria com um processo que envolve mobilidade urbana chame por esse e-mail para discutir sobre o assunto.”, 
  user_id: 1 
}
```
### Post / project 
Esse endpoint é responsável por criar uma publicação no sistema. 
####Parâmetros: 
title: título da publicação. 
body: descrição sobre o projeto que o usuário deseja trabalhar e o que ele quer que os patrocinadores façam. 
user_id: refere-se ao usuário que deseja usar essas informações de localização para si mesmo. 
```
{
  "title": "project dog",
  "body": "example",
  "user_id": 2
}
```
#### Resposta: 
Nenhum conteúdo! 204 

### Put / project/{id} 
Esse endpoint é responsável por atualizar os dados da publicação. 
#### Parâmetros: 
Id: identificador da publicação a ser atualizada. 
title: novo título da publicação (opcional). 
body: nova descrição da publicação (opcional). 
```
{
  "title": "project dogs",
  "body": "Olá patrocinadores em potencial! Gostaria de apresentar a vocês um projeto incrível que está em busca de apoio para se tornar realidade. Trata-se de um programa de educação ambiental para crianças carentes, que tem como objetivo conscientizá-las sobre a importância da preservação da natureza. Com o seu patrocínio, poderemos garantir a compra de materiais didáticos e a contratação de profissionais capacitados para ministrar as aulas. Acreditamos que investir em educação ambiental é um passo importante para construirmos um futuro sustentável. Junte-se a nós nessa missão!"
  
}
```
#### Resposta: 
Ok! 200 

Exemplo de resposta: 
```
{ 
  response: “successfully update” 
} 
```
### Delete / project/{id} 
Esse endpoint é reponsável por deletar uma publicação do sistema. 
#### Parâmetros: 
Id: identificador da publicação a ser excluída. 
#### Resposta: 
Ok! 200 

Exemplo de resposta: 
```
{ 
  response: “Sucessfully deleted publication” 
} 
```
### Get / comment/comments
Esse endpoint é responsável por retornar uma lista de todas as respostas para uma determinada publicação. 
#### Parâmetros: 
Nenhum. 
Response: Para usuário entrar em contato com o dono da publicação ou interagir. 
#### Resposta: 
Ok! 200 

Exemplo de resposta:  
```
[ 
  { 
    name: “luiz”, 
    response: “Gostaria de ajudar, para isso entre em contato com meu E-mail:	xample@gmail.com”, 
    user_id: 1, 
    id_publication: 1 
  } ,
   { 
    name: “lucas
    response: “Gostaria de ajudar, para isso entre em contato com meu E-mail:	xample@gmail.com”, 
    user_id: 2,
    id_publication: 2
  }
] 
```
### Post / comment 
Esse endpoint é responsável por criar uma resposta para uma determinada publicação. 
#### Parâmetros: 
publication_id: vai se referir ao id da publicação que o usuário colocou. 
response: Digite sua resposta referente ao artigo que você leu. 
user_id: refere-se ao usuário que deseja usar essas informações de localização para si mesmo. 
```
{
  "publication_id": 3,
  "response": "fasfdsofodmfodsmfomsdofmdofms",
  "user_id": 2
}
```
#### Resposta: 
Ok! 200 

Exemplo de resposta:  
```
{ 
  response: “answer successfully saved“ 
} 
```
### Put / comment/{id} 
Esse endpoint é responsável por atualizar uma resposta existente. 
#### Parâmetros:  
Id: o Id referente a resposta. 
Response: Para trocar o texto de sua resposta. 
```
{
  "response": "fasfdsofodmfodsmfomsdofmdofms",
}
```
#### Resposta: 
Ok! 200 

Exemplo de resposta: 
```
{ 
  response: “answer successfully updated” 
} 
```
### Delete / comment/{id}
Esse endpoint é responsável por deletar uma resposta existente. 
#### Parâmetros:  
Id: id da resposta a ser removida. 
#### Responta: 

Ok! 200

Exemplo de resposta: 
```
{ 
  response: “Sucessfully deleted publication” 
} 
```
