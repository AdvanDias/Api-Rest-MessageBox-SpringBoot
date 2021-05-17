# MessageBox em API REST com Spring Boot



### Objetivo

Com a API MessageBox o usuário pode criar uma publicação e um visitante deixar um comentário e uma pontuação.



### Nesse projeto foi utilizado as seguintes abordagens:

* Modelo de dados para o mapeamento de entidades em bancos de dados **H2** e **Postgre**.

* Desenvolvimento de operações de CRUD para a aplicação **(Cadastro, leitura, atualização e remoção)**.

* Relação de cada uma das operações acima com o padrão arquitetural **REST**.

* Implantação do sistema na nuvem através do **Heroku**.

  

### São necessários os seguintes pré-requisitos para a execução do projeto:

* Java 11 ou versões superiores.

* Maven 3.6.3 ou versões superiores.

* Intellj IDEA Community Edition ou sua IDE favorita.

* Postman para consumir a API.

  

### Para executar o projeto temos duas formas:

#### Primeiro: Utilizando o link do Heroku, e para consumir a API usar Postman.



##### Para realizar o CRUD da publicação será necessário:


​	

**POST** - Para adicionar uma publicação.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/person
	

Coloque no corpo da requisição no padrão **Json**.

		{
		"firstName":"Primeiro Nome",
		"lastName":"Sobrenome",
		"data":"16-05-2021",
		"text":"Aqui entra uma postagem de no minino 10 caracteres"
		}

**GET** - Para buscar todas as publicações.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/person



**GET** - Para buscar apenas uma publicação especifica por id na Url.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/person/1



**PUT** - Para atualizar uma publicação é obrigatório colocar o id na Url e no corpo da requisição.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/person/1



Coloque no corpo da requisição no padrão **Json**.

		{
		"id":1,
		"firstName":"Novo Primeiro Nome",
		"lastName":"Novo Sobrenome",
		"data":"17-06-2020",
		"text":"Aqui entra uma NOVA postagem de no minino 10 caracteres"
		}



**DELETE** - Para deletar a publicação é obrigatório colocar o id na Url.

**Obs:** A publicação só pode ser deletada se não houver comentários atrelados a ele.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/person/1



##### Para realizar o CRUD de comentário na publicação será necessário:


​	

**POST** - Para adicionar um comentário.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/visitor
	

**obs:**  No campo **"point"** -> a pontuação é de no **máximo 10** pontos.
			 **"person"** - >  **"id":1** -> o id do person tem que ser o mesmo da publicação escolhida.



Coloque no corpo da requisição no padrão **Json**.

		{
		"name":"Nickname",
		"comment":"Aqui entra o comentario de no minino 10 caracteres",
		"point":5,
		"person":{
				"id":1
				}
		}



**GET** - Para buscar todos os comentários.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/visitor



**GET** - Para buscar apenas um comentário especifica por id na Url.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/visitor/1



**PUT** - Para atualizar um comentário é obrigatório colocar o id na Url e no corpo da requisição.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/visitor/1



Coloque no corpo da requisição no padrão **Json**.

**obs:**  No campo **"point"** -> a pontuação é de no **máximo 10** pontos.
			 **"person"** - >  **"id":1** -> o id do person tem que ser o mesmo da publicação escolhida.



		{
		"id":1,
		"name":"Novo Nickname",
		"comment":"Aqui entra o NOVO comentario de no minino 10 caracteres",
		"point":10,
		"person":{
				"id":1
				}
		}



**DELETE** - Para deletar o comentário é obrigatório colocar o id na Url.

https://api-rest-messagebox-springboot.herokuapp.com/api/v1/visitor/1



**Após executar os comandos acima, basta apenas abrir os seguintes endereços e visualizar a execução do projeto:**

Publicação - https://api-rest-messagebox-springboot.herokuapp.com/api/v1/preson

Comentário - https://api-rest-messagebox-springboot.herokuapp.com/api/v1/visitor



#### Segundo: Baixando ou clonado do repositório Git.

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run
```



Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

**Obs:** Para executar os comandos de CRUD basta seguir a primeira etapa substituindo apenas a Url.



Publicação:

```
http://localhost:8080/api/v1/person
```

Comentário:

```
http://localhost:8080/api/v1/visitor
```
