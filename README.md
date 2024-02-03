# CBO API

>Criar .env com as variáveis de ambiente dentro de resources/postgres_cvs_init

| key                | value           |
|--------------------|-----------------|
| POSTGRES_USER      | <your_username> |
| POSTGRES_HOST      | postgres        |
| POSTGRES_DB        | cbo             |
| POSTGRES_PASSEWORD | <your_password> |

> e alterar o arquivo application.properties para:

```properties
quarkus.datasource.username=<your_username>
quarkus.datasource.password=<your_password>
```

# Docker
>Subir container com o banco de dados

```bash
cd resources/postgres_cvs_init
docker-compose up -d
```

# Documentação
localhost:8080/q/swagger-ui