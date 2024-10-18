# EstacionamentoCamara

**EstacionamentoCamara** 
EstacionamentoCamara é uma aplicação de gerenciamento de estacionamento que permite o cadastro de estabelecimentos, gestão de vagas para motos e carros, controle de entrada e saída de veículos, além da autenticação de usuários por meio de tokens JWT. A aplicação agora suporta operações via GraphQL, proporcionando maior flexibilidade e eficiência nas consultas.

## Características

- **Cadastro de Estabelecimentos**: Nome, CNPJ, Endereço, Telefone, Vagas de motos e carros.
- **Cadastro de Veículos**: Marca, Modelo, Cor, Placa, Tipo (Moto ou Carro).
- **Autenticação JWT**: Utiliza JSON Web Tokens para autenticação de usuários.
- **API GraphQL**: Realize operações de CRUD e controle de entrada/saída de veículos com GraphQL.
- **Banco de Dados**: Utiliza H2 em memória para testes.
  
## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **GraphQL**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **Banco de Dados H2 (em memória)**
- **Mockito e JUnit 5 (para testes)**

## Requisitos

- **JDK 17 ou superior**
- **Maven 3.8+**

## Como Executar a Aplicação

Clone o repositório para sua máquina local:

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

## Operações via GraphQL
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


## Perguntas e Respostas sobre GraphQL##

 1) Pergunta: **O que é GraphQL e como ele se diferencia de uma API REST tradicional?**
            - GraphQL é uma linguagem de consulta para APIs que permite ao cliente especificar exatamente quais dados precisa, ao invés de receber respostas fixas de um endpoint,
             como acontece em APIs REST. Isso reduz a quantidade de dados transferidos e melhora 
             a eficiência.

2) Pergunta: **Como usar GraphQL como BFF neste projeto de estacionamento?**
            - GraphQL pode atuar como um Backend for Frontend (BFF), intermediando as requisições
              entre o front-end e o back-end de forma mais eficiente. Um exemplo prático é que o front-end pode solicitar veículos e estabelecimentos com uma única query, 
              simplificando a lógica no cliente.

3) Pergunta: **Benefícios e Desafios do GraphQL**
            
             - Benefícios: Flexibilidade nas consultas, menor número de requisições, redução de dados  desnecessários.

            - Desafios: Maior complexidade no servidor, necessidade de controle sobre consultas potencialmente custosas.
            
## Banco de Dados (Nível Básico)
1) Pergunta: **Explique os principais conceitos de um banco de dados relacional, como tabelas, chaves primárias e estrangeiras.**

               Um banco de dados relacional organiza os dados em tabelas, que são compostas 
               por linhas (registros) e colunas (atributos).
              Cada tabela armazena informações de uma entidade, como "Veículos" ou "Estabelecimentos".

              - Chaves Primárias: São identificadores únicos para cada registro em uma tabela. Elas garantem que cada entrada seja única. Exemplo: O campo id em uma tabela de "Veículos".
              - Chaves Estrangeiras: São campos que criam uma relação entre tabelas diferentes, referenciando a chave primária de outra tabela. Exemplo: Um campo estabelecimento_id em uma tabela de "Veículos" poderia ser uma chave estrangeira que relaciona um veículo a um estabelecimento específico.
2) Pergunta: **No contexto de uma aplicação de gerenciamento de estacionamento, como você**
               **organizaria a modelagem de dados para suportar as funcionalidades de controle**
               **de entrada e saída de veículos?**

A modelagem de dados para um sistema de estacionamento incluiria tabelas como Veículos, Estabelecimentos, Vagas, e uma tabela de EntradasSaidas para armazenar os registros de entrada e saída de veículos. A tabela EntradasSaidas conteria campos como:

id: Chave primária.
veiculo_id: Chave estrangeira para a tabela Veículos.
data_hora_entrada: Timestamp para a entrada do veículo.
data_hora_saida:   Timestamp para a saída do veículo.
estabelecimento_id: Chave estrangeira para relacionar o registro de entrada/saída com um estabelecimento.
Essas tabelas estariam relacionadas usando chaves estrangeiras para garantir a integridade referencial e suportar operações de consulta e controle de veículos dentro do estacionamento.

## Agilidade
1) Pergunta: **Explique o conceito de metodologias ágeis e como elas impactam o desenvolvimento de software.**

             Metodologias ágeis são um conjunto de práticas e valores que focam em entregas contínuas,
             iteração e colaboração no desenvolvimento de software. Elas permitem que equipes de 
             desenvolvimento respondam rapidamente a mudanças e feedbacks, garantindo que o produto 
             final atenda melhor às necessidades dos usuários.

2) Pergunta: **No desenvolvimento deste projeto, como você aplicaria princípios ágeis para garantir entregas contínuas e com qualidade?**

              Para este projeto, eu aplicaria os princípios ágeis dividindo as funcionalidades em
              pequenas tarefas (stories) que possam ser entregues em sprints curtos. 
              A cada sprint, uma funcionalidade do sistema seria revisada e testada antes de 
              ser lançada. Isso garante a entrega contínua e permite ajustes rápidos com 
              base no feedback de stakeholders. Além disso, a realização de revisões de código e 
              testes automatizados em cada etapa ajuda a manter a qualidade do código.

3) Pergunta: **Qual a importância da comunicação entre as equipes em um ambiente ágil? Dê exemplos de boas práticas.**

              A comunicação entre equipes é essencial em um ambiente ágil para garantir que todos 
              estejam alinhados em relação aos objetivos do projeto e às tarefas em andamento. 
              Boas práticas incluem reuniões diárias de "stand-up" para discutir progresso e 
              esafios, revisões de sprint regulares para avaliar o que foi entregue, e 
              retrospectivas para identificar melhorias no processo. 
              Ferramentas como Slack ou Microsoft Teams facilitam a comunicação contínua,
             enquanto o uso de boards como o Trello ou Jira ajudam a monitorar o andamento das tarefas.

## DevOps 
1) Pergunta: **O que é DevOps e qual a sua importância para o ciclo de vida de uma aplicação?**

              DevOps é uma cultura que integra as equipes de desenvolvimento (Dev) e operações 
              (Ops) para melhorar a colaboração e automação em todas as fases do ciclo de vida 
              de uma aplicação, desde o desenvolvimento até o deploy e manutenção. 
              A importância do DevOps está na agilidade e eficiência que traz ao processo, 
              permitindo que as equipes desenvolvam, testem e implementem rapidamente, 
              com menos erros e menos tempo de inatividade.

2) Pergunta: **Descreva como você integraria práticas de DevOps no desenvolvimento desta aplicação de estacionamento. Inclua exemplos de CI/CD.**

               Eu integraria práticas de DevOps neste projeto usando uma pipeline de CI/CD 
               (Integração Contínua/Entrega Contínua). Sempre que um desenvolvedor fizer um
                commit no repositório, ferramentas como o Jenkins ou o GitHub Actions poderiam 
                rodar automaticamente testes de unidade e de integração, garantindo que o novo 
                código não quebre funcionalidades existentes. Após passar pelos testes, o código 
                seria automaticamente implantado em um ambiente de homologação ou produção. 
                Ferramentas como Docker e Kubernetes poderiam ser usadas para empacotar e 
                gerenciar a aplicação em contêineres, facilitando o deploy.

3) Pergunta: **Cite as ferramentas que você usaria para automatizar o processo de deploy e monitoramento da aplicação.**

               Ferramentas como Jenkins ou GitHub Actions podem ser usadas para a automação de CI/CD. 
               Para deploy, eu usaria Docker para criar contêineres da aplicação e Kubernetes para 
               orquestrar esses contêineres em diferentes ambientes. Para monitoramento, ferramentas
              como Prometheus (para métricas) e Grafana (para dashboards) seriam utilizadas, 
              além de ferramentas de logging como o ELK Stack (Elasticsearch, Logstash, Kibana) 
              para monitorar logs e eventos da aplicação.

