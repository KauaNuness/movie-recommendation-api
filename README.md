# 🎬 Movie Recommendation API

API REST para recomendação de filmes desenvolvida com **Spring Boot**,
integrando dados da **API do TMDB (The Movie Database)**, com
persistência em banco de dados **PostgreSQL** e arquitetura organizada
em camadas.

------------------------------------------------------------------------

## 🧠 Sobre o projeto

Este projeto tem como objetivo praticar e demonstrar:

-   Consumo de **API externa (TMDB)**
-   Arquitetura em camadas (Controller, Service, Repository)
-   Persistência de dados com **Spring Data JPA**
-   Uso de **WebClient** para requisições HTTP
-   Configuração de ambiente com **Docker**
-   Boas práticas de backend com Spring Boot

------------------------------------------------------------------------

## 🛠️ Tecnologias utilizadas

-   Java 17
-   Spring Boot
-   Spring WebFlux (WebClient)
-   Spring Data JPA
-   PostgreSQL
-   Docker & Docker Compose
-   Maven
-   TMDB API

------------------------------------------------------------------------

## ⚙️ Configuração

### Banco de dados (Docker)

``` yaml
services:
  postgres:
    image: postgres:15
    container_name: movierec-db
    environment:
      POSTGRES_DB: movierec
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
```

------------------------------------------------------------------------

## ▶️ Executando

``` bash
docker-compose up -d
mvn spring-boot:run
```

------------------------------------------------------------------------

## 📡 Endpoints

-   `GET /movies/popular`
-   `POST /movies/sync`

------------------------------------------------------------------------

## 👨‍💻 Autor

**Kauã Nunes**\
📧 Email: devkaua22@gmail.com\
🔗 GitHub: https://github.com/KauaNuness
