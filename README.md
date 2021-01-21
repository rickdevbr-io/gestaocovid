# Sobre :blue_book:
Foi desenvolvida uma POC dentro do contexto: "Criar uma solução de auxílio ao combate do covid-19. Nesta solução há comumicação entre APIs onde uma cadastra as pessoas, seus sintomas e região e a segunda mostra a região mas carente na doação de sangue". A estruturação do código é em MVC cujos packages são separados por contexto de negócio, onde a codificação foi feita seguindo as exigências: codificação de visualização do desenvolvedor em inglês, texto de exibição para o cliente em português e seguir os principios S(Single Responsibility Principle) e O (Open Closed Principle) do paradigma O.O. Por familiaridade a linguagem adotada foi o java 8 com maven conectando-se ao Postgresql, um banco relacional open source. Para facilitar no gerenciamento dos scripts em banco foi escolhido o Flyway e para documentação da API o Swagger. Para praticar a ideia de low code foi usado o Lombok junto ao SpringBoot.

# Tech Stack :clipboard:
- Java 8
- Maven
- Postgresql
- Flyway
- Swagger
- SpringBoot
- Lombok

# Executando o projeto :computer:
- Passo1: Escolha a pasta para download do projeto e execute o clone;
```
git clone https://github.com/rickdevbr-io/gestaocovid.git
```
- Passo2: Escolha a pasta para download do projeto e execute o clone;

- Passo3: No PostgreSQL local crie o database fiap;

- Passo4: Execute o boot dos projetos;
```
mvn run
```
- Passo5: Abra a documentação API http://localhost:8080/fiap-covid/swagger-ui/ e http://localhost:8090/fiap-gestao/swagger-ui/

- Passo6: Nos controllers do fiap-covid use os endpoints para cadastro, exibição e exclusão das pessoas, sintomas e regioes. Já no controller do fiap-gestao use o endpoint para visualizar a gestão do covid-19;

- Obs.: Caso for optado utilizar o PostgreSql Client, e não a opção com a imagem do PostgreSql via Docker, será necessário associar ao projeto o postgresql-42.2.18.jar, presente na pasta "src", assim como ter o plugin DB Browser instalado no IntelliJ.
Caso não for utilizar o postgresql.jar, certificar que as linhas a seguir não estão presentes no pom e fazer as alterações necessárias para utilizar a opção imagem no Docker:
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
