# DevShowcase API

Projeto acadêmico da disciplina Programação Backend - UAPI/UESPI.

## Endpoints

### Listar projetos
GET `/api/projects`
GET `/api/projects?technology=Java&page=0&size=10`

### Cadastrar feedback
POST `/api/projects/{id}/feedbacks`

JSON:
```json
{
  "rating": 5,
  "comment": "Excelente projeto!"
}
```

### Registrar upvote
PUT `/api/projects/{id}/upvote`

## Swagger
`/swagger-ui.html`

## Exemplos de erros

404:
`GET /api/projects/999/feedbacks` com projeto inexistente.

400:
`POST /api/projects/1/feedbacks` com:
```json
{
  "rating": 8,
  "comment": ""
}
```

## Deploy
Configurar PostgreSQL e as variáveis `DATABASE_URL`, `DB_USERNAME` e `DB_PASSWORD`.
