# Event City API - Desafio TDD

Este projeto é um sistema de eventos e cidades com uma relação N-1 entre eles. A API foi desenvolvida seguindo o paradigma TDD (**Test-Driven Development**) para garantir que todas as funcionalidades implementadas atendem às especificações estabelecidas.

## Funcionalidades Implementadas

### Endpoints da API

#### **1. DELETE /cities/{id}**
- **Caso: ID inexistente**
  - Deve retornar **404 Not Found**.
  - **Teste:** `deleteShouldReturnNotFoundWhenNonExistingId`

- **Caso: ID independente**
  - Deve retornar **204 No Content** e excluir a cidade.
  - **Teste:** `deleteShouldReturnNoContentWhenIndependentId`

- **Caso: ID dependente**
  - Deve retornar **400 Bad Request**.
  - **Teste:** `deleteShouldReturnBadRequestWhenDependentId`

#### **2. POST /cities**
- Deve inserir uma nova cidade e retornar **201 Created** com o recurso criado.
- **Teste:** `insertShouldInsertResource`

#### **3. GET /cities**
- Deve retornar todas as cidades ordenadas alfabeticamente por nome.
- **Teste:** `findAllShouldReturnAllResourcesSortedByName`

---

## Testes de Integração

Abaixo estão os testes implementados para validar as funcionalidades do controlador de cidades (**CityController**):

### **1. `findAllShouldReturnAllResourcesSortedByName`**
- **Descrição:** Verifica se o endpoint `/cities` retorna todas as cidades ordenadas por nome.
- **Validações:**
  - Status HTTP **200 OK**.
  - JSON retornado contém nomes em ordem alfabética.

### **2. `insertShouldInsertResource`**
- **Descrição:** Valida a inserção de uma nova cidade no endpoint `/cities`.
- **Validações:**
  - Status HTTP **201 Created**.
  - O JSON retornado possui o `id` e o nome da cidade inserida.

### **3. `deleteShouldReturnNoContentWhenIndependentId`**
- **Descrição:** Verifica se uma cidade independente pode ser excluída pelo endpoint `/cities/{id}`.
- **Validações:**
  - Status HTTP **204 No Content**.

### **4. `deleteShouldReturnNotFoundWhenNonExistingId`**
- **Descrição:** Valida o comportamento do endpoint `/cities/{id}` ao receber um ID inexistente.
- **Validações:**
  - Status HTTP **404 Not Found**.

### **5. `deleteShouldReturnBadRequestWhenDependentId`**
- **Descrição:** Garante que o endpoint `/cities/{id}` retorna erro ao tentar excluir uma cidade dependente.
- **Validações:**
  - Status HTTP **400 Bad Request**.

---

## Como Executar os Testes

1. Certifique-se de que o ambiente de desenvolvimento está configurado corretamente.
2. Execute os testes com o comando Maven:
   ```bash
   mvn test
   ```

---

## Competências Avaliadas

- Desenvolvimento TDD de API REST com Java e Spring Boot.
- Implementação de cenários de busca, inserção, deleção e atualização.
- Tratamento de exceções em API com respostas HTTP customizadas.

---

**Desenvolvido como parte do Desafio TDD Event City.**
