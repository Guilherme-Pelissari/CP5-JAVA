## Flyway Demo (Spring Boot + JPA + H2)

Projeto exemplo com estrutura organizada em camadas, migrações Flyway e API CRUD de `Produto`.

### Estrutura
```text
src/
  main/
    java/
      com/example/flywaydemo/
        FlywayDemoApplication.java
        model/Produto.java
        repository/ProdutoRepository.java
        controller/ProdutoController.java
        config/DatabaseConfig.java
    resources/
      application.properties
      db/migration/
        V1__Create_products_table.sql
        V2__Add_category_to_products.sql
        V3__Insert_initial_products.sql
```

### Requisitos
- Java 17+
- Maven Wrapper (já incluso: `mvnw`/`mvnw.cmd`)

### Configuração de banco (H2 em memória)
- JDBC URL: `jdbc:h2:mem:demo`
- Usuário: `sa`
- Senha: (vazia)
- Console H2: `http://localhost:8080/h2-console`

### Build e Execução (Windows PowerShell)
```powershell
cd "C:\Users\fezes\OneDrive\Área de Trabalho\demo\demo"
mvn clean package
mvn spring-boot:run
# ou
java -jar .\target\demo-0.0.1-SNAPSHOT.jar
```

Se precisar pular testes:
```powershell
mvn clean package -DskipTests
```

### Endpoints
- Listar produtos
```bash
curl http://localhost:8080/produtos
```

- Buscar por id
```bash
curl http://localhost:8080/produtos/1
```

- Criar produto (POST /produtos)
Body JSON:
```json
{
  "nome": "Teclado de membrana",
  "preco": 150.00,
  "categoria": "Periféricos"
}
```
Exemplo:
```bash
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Teclado de membrana","preco":150.00,"categoria":"Periféricos"}'
```

- Atualizar produto (PUT /produtos/{id})
```bash
curl -X PUT http://localhost:8080/produtos/1 \
  -H "Content-Type: application/json" \
  -d '{"nome":"Teclado","preco":299.90,"categoria":"Periféricos"}'
```

- Remover produto (DELETE /produtos/{id})
```bash
curl -X DELETE http://localhost:8080/produtos/1
```

### Migrações Flyway
Executadas automaticamente no startup a partir de `resources/db/migration`:
- `V1__Create_products_table.sql`
- `V2__Add_category_to_products.sql`
- `V3__Insert_initial_products.sql`


