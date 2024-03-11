# Projeto Backend CRUD de Produtos

## Descrição

Este é o backend de uma aplicação CRUD (Create, Read, Update, Delete) de produtos. Foi desenvolvido usando Java 17 e Spring Boot 3 e está hospedado na URL: `https://projeto-backend-62pg.onrender.com`.

O backend fornece uma API RESTful que é consumida pela aplicação frontend. Ele lida com todas as operações de banco de dados necessárias para o gerenciamento de produtos e segue os princípios do design RESTful, facilitando a comunicação entre o frontend e o backend.

Além disso, o backend utiliza Docker para garantir que o ambiente de execução seja consistente em todas as plataformas. Ele também usa um banco de dados PostgreSQL para armazenar os dados dos produtos.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Docker
- PostgreSQL

## Executando o Projeto

Para executar este projeto localmente, você precisará ter Docker e Docker Compose instalados em sua máquina. Siga as instruções abaixo:

1. Clone este repositório para sua máquina local.
2. Navegue até o diretório do projeto.
3. Execute o comando `docker-compose up`.

Isso iniciará o servidor e o banco de dados em contêineres Docker separados. Você pode acessar a API em `localhost:8080`.

## Links

- [API](https://projeto-backend-62pg.onrender.com)
