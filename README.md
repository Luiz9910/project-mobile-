# Definição de funcionalidades 
## Tela de Login 
O sistema deve reconhecer o e-mail e senha do usuário essa é a funcionalidade básica que seria permitir que o usuário digite seu e-mail e senha para acessar o sistema. 

O sistema deve verificar as credenciais do usuário e autenticar o usuário com sucesso se o e-mail e senha inseridos forem corretos. 

O sistema deve exibir mensagens de erro relevantes caso o e-mail ou senha inseridos pelo usuário estejam incorretos ou caso ocorra um erro durante a autenticação. 

O Sistema deve Redirecionamento para a página principal Caso a autenticação do usuário seja bem-sucedida, o sistema deve redirecionar o usuário para a página principal do sistema. 

O sistema deve incluir uma validação de e-mail para garantir que o e-mail inserido pelo usuário seja válido antes de tentar autenticar o usuário. 
## Tela de cadastro 
O sistema deve permitir que os usuários criem uma nova conta preenchendo as informações necessárias, como nome completo, endereço de e-mail etc. 

O Sistema deve deixar os usuários poder escolher um e-mail de usuário único para a sua conta do que será utilizado para identificá-los na plataforma. 

O Sistema deve deixar os usuários definir uma senha segura para a sua conta, que será utilizada para acessar. 

O sistema deve ter um campo para o usuário ou empresa uma descrição sobre si. 

O sistema deve ter um campo para identificar se o usuário é uma empresa ou uma pessoa. 

O sistema deve ter um botão de cadastrar, onde após enviado e caso as credenciais estiver tudo correto, ele será redirecionado para a página de login.  
## Tela de perfil 

O Sistema deve mostrar todos os dados do usuário na tela de perfil, como: nome, descrição. 

O sistema deve mostrar na tela de perfil a cidade onde o usuário mora ou onde a empresa fica localizada, será mostrado dados como cidade, país, estado. 

O Sistema deve ter um botão para redirecionar o usuário para página onde os usuários poder editar suas informações pessoais, como nome completo, foto de perfil, biografia e localização. 

O Sistema deve deixar os usuários poder publicar incluindo texto, imagens, vídeos e links. 

O Sistema deve mostrar todas as publicações que o usuário fez dentro da plataforma, onde. 

O Sistema deve reconhecer o botão de deletar publicação, onde após clicado o usuário receberá uma mensagem de confirmação. 

O Sistema deve deixar os usuários poder publicar incluindo texto, imagens e links. 

O Sistema deve mostrar todas as publicações que o usuário fez dentro da plataforma, onde. 

O Sistema deve ter um botão para editar arquivo, onde após clicado ele será redirecionado para a página de editar publicação. 

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
  token: “dsnaujifdbsdjfnidosfusdjfmdsjifhisdkfjsdnifksdjfbsdujfiodsnfisdkfisdhfisjtttttttthhshshshsshshh”  
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
  "body": "example"
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
