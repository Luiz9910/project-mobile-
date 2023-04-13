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
## parte1:
![parte2](https://user-images.githubusercontent.com/95968468/230752000-116c1e7d-8748-4519-a1b9-3318d37e9123.png)
## parte2:
![parte1](https://user-images.githubusercontent.com/95968468/230751998-d5850ebb-6799-431c-b62d-c944601fc5c3.png)

# Diagrama UML (Back-End)
![08 04 2023_22 32 42_REC](https://user-images.githubusercontent.com/95968468/230752522-31c4e5db-849c-4945-ac5b-11ce21b96b4e.png)

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
