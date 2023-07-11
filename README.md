# CRM Nexus(Em desenvolvimento)

O CRM Nexus é um projeto de Customer Relationship Management (CRM) é um microserviço desenvolvido em Java, utilizando o framework Spring e outras tecnologias relacionadas. Ele fornece uma solução completa para gerenciamento de relacionamento com o cliente, permitindo o registro e o acompanhamento de informações importantes sobre clientes, vendas, pedidos e produtos.

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias:

- Java
- Spring Framework
- Spring Security
- JPA/Hibernate
- MySQL
- Lombok
- OpenFeign
- Design Patterns
- Eureka
- Gateway

## Funcionalidades

O CRM Nexus oferece diversas funcionalidades para gerenciamento eficiente do relacionamento com o cliente:

- Gerenciamento de clientes: O sistema permite o cadastro, atualização e remoção de clientes, bem como o armazenamento de informações de contato e endereço.
- Gerenciamento de vendas: É possível registrar vendas, associando os itens vendidos a clientes específicos, informando os vendedores responsáveis e registrando informações de pagamento.
- Gerenciamento de pedidos: O sistema permite o registro e acompanhamento de pedidos, incluindo informações sobre o cliente, itens pedidos e detalhes de pagamento.
- Gerenciamento de produtos: É possível cadastrar, atualizar e remover produtos do sistema, incluindo informações como categoria, fornecedor e estoque disponível.

## Spring Security e Autenticação

O CRM Nexus utiliza o Spring Security para garantir a segurança das informações e o controle de acesso ao sistema. Para autenticação de usuários, o projeto utiliza JSON Web Tokens (JWT) e a criptografia de senhas com BCrypt.

- Autenticação de usuários: Quando um usuário cria uma conta no sistema, sua senha é criptografada usando a função de hash BCrypt antes de ser armazenada no banco de dados. Durante o processo de login, as credenciais são verificadas e um token JWT é gerado para autenticar o usuário nas solicitações subsequentes.
- Autorização e controle de acesso: O Spring Security permite a configuração de roles (funções) para os usuários. Cada usuário pode ter uma ou mais roles atribuídas, que determinam as permissões e os níveis de acesso no sistema. Dessa forma, é possível controlar o acesso a recursos específicos com base nas roles dos usuários.
