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


# Api / Contrato JSON 
## EndPoints 
## EndPoint User
### Post/ Authentication 
Esse endpoint é responsável por autenticação do usuário. 
#### Parâmetros: 
email: Email do usuário existente. 
password: senha do usuário existente e referente ao e-mail  
#### Respostas: 
Ok! 200 

Exemplo de resposta: 
```
{ 
  token: “dsnaujifdbsdjfnidosfusdjfmdsjifhisdkfjsdnifksdjfbsdujfiodsnfisdkfisdhfisjtttttttthhshshshsshshh”  
} 
```
### Get / Users 
Esse endpoint é responsável por retornar todos os usuários que têm no sistema 
#### Parâmetros: 
name: name do usuário para procurar ele no banco de dados. 
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
### Get / User  
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
  Is_company: ” true” 
} 
```
### Post / User 
Esse endpoint é responsável por criar um usuário no sistema. 
####Parâmetros:
name: nome do usuário ou da empresa. 
email: E-mail do usuário ou da empresa. 
password: Senha do usuário ou da empresa. 
description: uma breve descrição do usuário ou da empresa. 
Is_company: indicar se o usuário é uma empresa (true) ou não (false). 
#### Resposta: 
Created! 201 

Exemplo de resposta:  
```
{ 
  response: “user successfully saved” 
