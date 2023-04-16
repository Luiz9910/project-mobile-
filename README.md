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

Fluxo Alternativo:

Se as informações estiverem incorretas, o sistema exibe uma mensagem de erro e solicita que o usuário tente novamente.

*	O usuário esquece sua senha.
*	O usuário clica no botão "Esqueci minha senha".
*	O sistema exibe um formulário para redefinir a senha do usuário.
*	O usuário insere seu e-mail cadastrado e clica em "Enviar".
*	O sistema envia um e-mail com instruções para redefinir a senha do usuário.
*	O usuário segue as instruções no e-mail para redefinir sua senha.
*	O usuário retorna à tela de login e insere sua nova senha para fazer login no sistema.

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
*	O sistema exibe um formulário para criação de nova publicação, com campos para título, texto e opção para adicionar uma foto.
*	O usuário preenche os campos desejados e clica em "Publicar".
*	O sistema valida os campos e exibe uma mensagem de confirmação da publicação realizada.
*	A nova publicação é adicionada à lista de publicações do usuário na tela de perfil.

Fluxo Alternativo:

O usuário decide não adicionar uma foto à publicação. 

*	O sistema permite que a publicação seja realizada sem uma foto.

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
**Caso de Uso 7: Tela de Configuração**

Descrição: O usuário deseja mudar sua senha ou como deseja receber as notificações.

Fluxo Principal:

*	O usuário acessa a tela de configurações do sistema.
*	O sistema exibe as opções disponíveis: "Trocar senha" e "Receber notificações".
*	O usuário seleciona a opção "Trocar senha".
*	O sistema exibe um formulário para o usuário preencher com sua senha atual, nova senha e confirmação da nova senha.
*	O usuário preenche o formulário e clica em "Salvar".
*	O sistema valida as informações fornecidas pelo usuário e atualiza a senha do usuário no sistema.
*	O sistema exibe uma mensagem confirmando a atualização da senha do usuário.

Fluxo Alternativo:

*	O usuário seleciona a opção "Receber notificações".
*	O sistema exibe um switch para o usuário habilitar ou desabilitar as notificações do aplicativo.
*	O usuário seleciona sua preferência e clica em "Salvar".
*	O sistema atualiza as configurações do usuário e exibe uma mensagem confirmando a atualização das configurações.

Fluxo Alternativo: 

O sistema detecta um erro ao tentar atualizar a senha do usuário.

*	O sistema exibe uma mensagem de erro indicando que não foi possível exibir os detalhes da publicação e pede que o usuário tente novamente mais tarde.
------------------------------------- 


# Link do Figma: https://www.figma.com/file/nSiyio9tNPpJLvToDvIdPu/Untitled?node-id=0-1&t=L3aTWE0vK33XSWnS-0
## Tela de Login:
![07 04 2023_23 04 28_REC](https://user-images.githubusercontent.com/81191099/230699463-1fe30233-43e1-4b29-9b5b-1fe36ea0e808.png)
## Tela de Cadastro:
![07 04 2023_23 08 29_REC](https://user-images.githubusercontent.com/81191099/230699628-79755492-3855-4e65-bd8a-b1d3367ad565.png)
![07 04 2023_23 10 07_REC](https://user-images.githubusercontent.com/81191099/230749458-50bc0186-e32a-4805-92d3-89d2d5b7de1a.png)
## Perfil do Usuário:
![07 04 2023_23 10 44_REC](https://user-images.githubusercontent.com/81191099/230699672-13bf15f6-4727-4e86-a304-d4775f830b16.png)
## Editar Perfil:
![07 04 2023_23 11 09_REC](https://user-images.githubusercontent.com/81191099/230699686-f115a687-0858-4d3d-962b-2a883bbb9c24.png)
## Tela Principal:
![TelaPrincipal](https://user-images.githubusercontent.com/81191099/230791522-97758ade-86c0-461a-aa6f-93988778b04b.png)
## Tela Resposta Post:
![RespostasPosts](https://user-images.githubusercontent.com/81191099/230791544-83d50e73-c5d6-4197-9521-c82fd25fd3b5.png)
## Nova Publicação:
![NewPost](https://user-images.githubusercontent.com/81191099/230791565-7e8c3963-b358-476e-b107-b8ddd6e89b3f.png)
## Editar Publicação:
![Edit](https://user-images.githubusercontent.com/81191099/230792841-529373f5-80d0-4bfc-b6af-1ad59dc2e801.png)
## Configurações:
![Config](https://user-images.githubusercontent.com/81191099/230792882-ed1ff611-6d2a-4aed-b58b-bbee88e84de8.png)
## Redefinir Senha:
![RedefinirSenha](https://user-images.githubusercontent.com/81191099/230792902-b189e614-7d0c-433b-b17b-735572070246.png)
## Notificações:
![Not](https://user-images.githubusercontent.com/81191099/230793212-f95e9eac-5618-4c0e-996a-a6563a83e37a.png)

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

### Put / publication/{id} 
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
