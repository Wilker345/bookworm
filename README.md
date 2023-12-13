# bookworm
Plataforma para criar anotações sobre livros em posse do usuário.

Para utilizar:
1. Criar um arquivo chamado application.properties e inserir na pasta src/main/resources
2. Preencher o arquivo com as seguintes informaçôes:
  
`spring.jpa.database=POSTGRESQL 
   spring.datasource.username={db_user}
   spring.datasource.password={db_password}
   spring.datasource.url=jdbc:postgresql://localhost:5432/{db_name}
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
   spring.database.driverClassName=org.postgresql.Driver
   server.port=8080`