# 📋 Task Management API (Gerenciador de Tarefas)

![Java](https://img.shields.io/badge/Java-26-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.7-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

API RESTful para gerenciamento de tarefas (To-Do List) desenvolvida como desafio prático de Backend. O sistema permite criar, listar, atualizar e deletar tarefas, utilizando boas práticas de mercado como **Paginação**, **Tratamento Global de Exceções (@ControllerAdvice)** e **Documentação via Swagger (OpenAPI)**.

## 🚀 Tecnologias e Ferramentas Utilizadas

- **Java 26**
- **Spring Boot 4.0.7** (WebMVC, Data JPA, Validation)
- **H2 Database** (Banco de dados em memória)
- **SpringDoc OpenAPI 3.0.2** (Swagger) para documentação interativa
- **Lombok** para redução de código boilerplate (Getters, Setters, Construtores)
- **Docker & Docker Compose** para containerização

## ⚙️ Como Executar o Projeto

Você pode rodar este projeto de duas formas: localmente utilizando a sua IDE/Maven, ou utilizando o Docker.

### Opção 1: Rodando Localmente
Pré-requisitos: Ter o Java instalado na máquina.

1. Clone este repositório:
   ```bash
   git clone https://github.com/EricLps/sua-lista-de-tarefas.git
   ```
2. Entre na pasta do projeto e execute a aplicação via Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

### Opção 2: Rodando com Docker
Pré-requisitos: Ter o Docker instalado.

1. Na raiz do projeto, construa a imagem:
   ```bash
   docker build -t task-api .
   ```
2. Rode o container expondo a porta 8080:
   ```bash
   docker run -p 8080:8080 task-api
   ```

## 📚 Documentação da API (Swagger)

A API possui uma interface gráfica interativa onde é possível testar todos os endpoints facilmente sem precisar de ferramentas externas como o Postman.

Com a aplicação rodando, acesse no seu navegador:
🔗 **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**

### Preview dos Endpoints:
![Swagger Preview]("https://github.com/user-attachments/assets/c0754494-0565-4247-88f3-c5ec4bafd16a")

## 🔗 Rotas da API

A API responde na URL base `/tasks`.

| Método | Rota               | Descrição                              |
|--------|--------------------|----------------------------------------|
| POST   | `/tasks`           | Cria uma nova tarefa.                  |
| GET    | `/tasks`           | Lista todas as tarefas (Paginado).     |
| GET    | `/tasks/{id}`      | Busca uma tarefa específica pelo ID.   |
| PUT    | `/tasks/{id}`      | Atualiza os dados de uma tarefa existente. |
| DELETE | `/tasks/{id}`      | Exclui uma tarefa do sistema.          |

## 🧠 Lógicas de Negócio Implementadas

- **UUID:** IDs das tarefas são gerados automaticamente no formato UUID.
- **Auto-preenchimento:** A data de criação (`creationDate`) é gerada e assinalada automaticamente pelo Backend na hora da requisição `POST`.
- **Tratamento de Exceções:** Implementação de `@ControllerAdvice` e `TaskNotFoundException` para interceptar requisições inválidas. Ao buscar ou tentar atualizar um ID que não existe, a API não retorna um erro `500 Internal Server Error`, mas sim aborta a operação com segurança e retorna um JSON amigável com Status `404 Not Found`.

---
Desenvolvido por **[Eric LPS](https://github.com/EricLps)**.
