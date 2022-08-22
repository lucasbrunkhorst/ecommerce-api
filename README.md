# Desafio GoDev

Desenvolver uma APIREST com Item, Order e OrderItens CRUD (Create, Read, Update, Delete) utilizando Java/Spring

O exercício consiste em implementar um cadastro de produtos e serviços, possibilitando 
também a emissão de pedidos de compra destes produtos e serviços.

Deverá ser desenvolvido um cadastro completo de pedido e itens do pedido 

No fechamento do pedido, deve ser possível aplicar um percentual de desconto, 
porém este desconto só será válido para os itens que são classificados como produto, 
ou seja, não deve ser aplicado para os itens que são serviços. 


## IDE
Intellij IDEA Community Edition

## Tecnologias Utilizadas</h2>


Java 8+
<br>
Spring Boot
<br>
Spring MVC
<br>
Spring Data JPA
<br>
Rest com JSON
<br>
Lombok
<br>
Maven 4.0.0
<br>
Banco PostgreSQL
<br>
Postman


## Como Executar o Projeto

### 1. Clone a aplicação

   + https://github.com/lucasbrunkhorst/ecommerce-api.git

### 2. Crie o banco de dados no PostGreSql

   + create database ecommerce

### 3. Modifique o usuário e senha do banco de dados de acordo com a sua instalação

  + abra src/main/resources/application.properties

  + modifique spring.datasource.username e spring.datasource.password

### 4. Execute utilizando a IDE de sua preferencia.

  + Por padrão a API vai rodar nesse endereço http://localhost:8080.

  + ou Execute esse comando na linha de comandos

  + mvn spring-boot:run


 ## Como testar a Aplicacao

Collection Postman com os End-Points

<a href="https://gold-rocket-82962.postman.co/workspace/New-Team-Workspace~4b3f19ba-f363-4e84-ac72-1552de3a1871/collection/21441796-5d816880-a961-4923-9c23-79c37ec7c827?action=share&creator=21441796&ctx=documentation"> Postman </a>

Ou no swagger, porem é necessario ajustar alguns parametros antes de fazer a request

http://localhost:8080/swagger-ui/index.html#/

 ## Checar Status

localhost:8080/actuator/health


