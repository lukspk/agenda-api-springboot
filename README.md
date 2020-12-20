# Agenda de Contatos API Rest

###Pré-requisitos
```
Java 11
Mysql
Maven
```
## Configuração do Projeto

Importe e execute o Projeto em uma IDE Java (Class AgendaAPIApplication)

### Arquivo de Configuração Mysql
```
/agenda-api-springboot/src/main/resources/application.properties
```
##### Banco de Dados usado nome: Agenda

### Instalar Dependẽncias
```
npm install
```

### Rotas
```
Listar Todos - GET: http://localhost:9000/api/v1/contacts/
Listar um - GET: http://localhost:9000/api/v1/contacts/{id}
Cadastrar - POST: http://localhost:9000/api/v1/contacts/
Atualizar - PUT:  http://localhost:9000/api/v1/contacts/{id}
Remover - DELETE: http://localhost:9000/api/v1/contacts/{id}
```