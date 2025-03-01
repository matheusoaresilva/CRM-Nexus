# CRM Nexus(Em desenvolvimento)

O CRM Nexus é um projeto de Customer Relationship Management (CRM) composto por vários microserviços desenvolvidos em Java, utilizando o framework Spring e outras tecnologias relacionadas. Cada microserviço é responsável por uma parte específica do projeto, permitindo uma arquitetura modular e escalável

## Interface
A aplicação possui uma interface intuitiva e amigável, permitindo que os usuários acessem e interajam com as funcionalidades do sistema de forma fácil e eficiente.

[Figma](https://www.figma.com/file/Bkjd4l4WC93hdkXQaYJ7PV/CRM-Project?type=design&node-id=0%3A1&mode=design&t=66y30J9UVNNjFHcF-1)

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias:

- Java
- Spring Framework
- Spring Security
- JPA/Hibernate
- MySQL
- Lombok
- Amqp
- RabbitMQ
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
- Envio de e-mails: O CRM Nexus também inclui a funcionalidade de envio de e-mails para os usuários em várias situações, como criação de conta, alteração de senha, confirmação de pedido comprado, notificação de pedido enviado, atualização sobre o pedido a caminho e confirmação de entrega, entre outros eventos relevantes.

## Spring Security e Autenticação

O CRM Nexus utiliza o Spring Security para garantir a segurança das informações e o controle de acesso ao sistema. Para autenticação de usuários, o projeto utiliza JSON Web Tokens (JWT) e a criptografia de senhas com BCrypt.

- Autenticação de usuários: Quando um usuário cria uma conta no sistema, sua senha é criptografada usando a função de hash BCrypt antes de ser armazenada no banco de dados. Durante o processo de login, as credenciais são verificadas e um token JWT é gerado para autenticar o usuário nas solicitações subsequentes.
- Autorização e controle de acesso: O Spring Security permite a configuração de roles (funções) para os usuários. Cada usuário pode ter uma ou mais roles atribuídas, que determinam as permissões e os níveis de acesso no sistema. Dessa forma, é possível controlar o acesso a recursos específicos com base nas roles dos usuários.
