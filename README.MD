# EstacionamentoCamara

**EstacionamentoCamara** 
EstacionamentoCamara é uma aplicação de gerenciamento de estacionamento que permite o cadastro de estabelecimentos, gestão de vagas para motos e carros, controle de entrada e saída de veículos, além da autenticação de usuários por meio de tokens JWT. A aplicação agora suporta operações via GraphQL, proporcionando maior flexibilidade e eficiência nas consultas.


## 1. Características

- **Cadastro de Estabelecimentos**: Nome, CNPJ, Endereço, Telefone, Vagas de motos e carros.
- **Cadastro de Veículos**: Marca, Modelo, Cor, Placa, Tipo (Moto ou Carro).
- **Autenticação JWT**: Utiliza JSON Web Tokens para autenticação de usuários.
- **API GraphQL**: Realize operações de CRUD e controle de entrada/saída de veículos com GraphQL.
- **Banco de Dados**: Utiliza H2 em memória para testes.
  
## 2. Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.4
- GraphQL
- JWT (JSON Web Token)
- Spring Data JPA
- Banco de Dados H2 (em memória)
- Mockito e JUnit 5 (para testes)

## 3. Requisitos

- JDK 17 ou superior
- Maven 3.8+

## 4. Como Executar a Aplicação

1. Clone o repositório para sua máquina local:

   - bash
   git clone https://github.com/SEU_USUARIO/EstacionamentoCamara.git

**Navegue até a pasta do projeto:**
- bash
- Copiar código:

cd EstacionamentoCamara

**Compile e execute a aplicação:**
- bash
- Copiar código:

mvn spring-boot:run

**Acesse o GraphQL Playground para testar consultas e mutações:**
- bash
- Copiar código:

http://localhost:8080/graphql

## 5. Operações via GraphQL
**Você pode usar as seguintes queries e mutations no Playground:**

Exemplo de Query para Veículos:
    - graphql
    - Copiar código:

query {
  veiculos {
    marca
    modelo
    cor
  }
}

Exemplo de Mutation para Criar um Veículo:
  - graphql
  - Copiar código:

mutation {
  criarVeiculo(marca: "Honda", modelo: "Civic", cor: "Preto", placa: "XYZ1234", tipo: "Carro") {
    id
    marca
    modelo
  }
}


## 6. Perguntas e Respostas sobre GraphQL##

Pergunta 1: **O que é GraphQL e como ele se diferencia de uma API REST tradicional?**
            - GraphQL é uma linguagem de consulta para APIs que permite ao cliente especificar exatamente quais dados precisa, ao invés de receber respostas fixas de um endpoint,
             como acontece em APIs REST. Isso reduz a quantidade de dados transferidos e melhora 
             a eficiência.

Pergunta 2: **Como usar GraphQL como BFF neste projeto de estacionamento?**
            - GraphQL pode atuar como um Backend for Frontend (BFF), intermediando as requisições
              entre o front-end e o back-end de forma mais eficiente. Um exemplo prático é que o front-end pode solicitar veículos e estabelecimentos com uma única query, 
              simplificando a lógica no cliente.

Pergunta 3: **Benefícios e Desafios do GraphQL**
            
             - Benefícios: Flexibilidade nas consultas, menor número de requisições, redução de dados  desnecessários.

            - Desafios: Maior complexidade no servidor, necessidade de controle sobre consultas potencialmente custosas.
            
