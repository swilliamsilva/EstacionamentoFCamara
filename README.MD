# EstacionamentoCamara

**EstacionamentoCamara** é uma aplicação de gerenciamento de estacionamento. Ela permite o cadastro de estabelecimentos, gestão de vagas para motos e carros, além da autenticação de usuários por meio de tokens JWT.

## Características

- **Cadastro de Estabelecimentos:** Inclui informações como nome, CNPJ, endereço, telefone, vagas de motos e carros.
- **Autenticação JWT:** Utiliza JSON Web Tokens para autenticação de usuários.
- **API RESTful:** Implementada com Spring Boot para fornecer endpoints de API.
- **Banco de Dados:** Utiliza H2 em memória para testes, podendo ser configurado para outros bancos de dados.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Security**
- **JWT (Json Web Token)**
- **Spring Data JPA**
- **Banco de Dados H2** (Em memória)
- **Mockito** (Para testes unitários)
- **JUnit 5** (Para testes)

## Requisitos

- **JDK 17** ou superior
- **Maven 3.8+**
  
## Como Executar a Aplicação

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/SEU_USUARIO/EstacionamentoCamara.git