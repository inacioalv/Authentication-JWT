<h1 align="center">
  Api Authentication-JWT

</h1>


<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-url">Url</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>


<br>


## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Spring](https://spring.io/)
- [Jpa](https://spring.io/projects/spring-data-redis)
- [netflix-eureka](https://spring.io/projects/spring-cloud-sleuth)
- [mysql](https://www.mysql.com/)
- [lombok](https://projectlombok.org/)
- [swagger](https://swagger.io/)


## 💻 Projeto
Nesse projeto iremos implementar uma aplicação API RESTful para autenticação e geração de um token JWT 
para completar as requisições de forma segura. para esse projeto adicionamos as dependências do Spring Security.
Apos a configuração de autenticar com email e senha e devolver um token para ser usado nas próximas requisições,
usamos o token que contém informações para permitir o acesso do usuário aos recursos da aplicação, para isso precissamos de
fazer é verificação se uma requisição que está tentando acessar algum recurso possui um token e se esse token é válido,


documentação (Swagger),implementando o Eureka Naming Server . 


## :hammer: Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

## 💻 Url
Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
User
http://localhost:8083/auth/user
http://localhost:8083/auth/login
http://localhost:8083/auth/user/{id}
```



## 📝 Licença

Este projeto esta sobe a licença MIT. Veja a [LICENÇA](https://opensource.org/licenses/MIT) para saber mais.


