# Descrição do Banco de Dados `dbCarteiraVacina`

O banco de dados `dbCarteiraVacina` foi projetado para gerenciar informações relacionadas a carteiras de vacinação de usuários, incluindo detalhes pessoais, informações de conta e registro de vacinas tomadas. Este banco de dados é composto por várias tabelas que estão interligadas para manter a integridade e consistência dos dados.

## Tabelas

1. **Conta**: Esta tabela armazena informações básicas de conta do usuário, incluindo um ID único, senha, email e telefone.

2. **Cadastro**: Contém detalhes pessoais dos usuários, como CPF, número do documento SUS, nome completo e data de nascimento. A tabela `Cadastro` está relacionada à tabela `Conta` por meio da chave estrangeira `Conta_id_Conta`, permitindo a associação de informações pessoais com uma conta específica.

3. **CarteiraVacina**: Responsável pelo armazenamento das carteiras de vacinação dos usuários. Esta tabela inclui um campo para armazenar uma foto da carteira (em formato BLOB) e uma chave estrangeira `fk_Cadastro_CPF`, que referencia a tabela `Cadastro`, vinculando as carteiras de vacinação aos usuários.

4. **ListaVacinas**: Mantém um registro das vacinas disponíveis, contendo informações como descrição da vacina, nome da vacina, quantidade de doses e data para vacinação. Cada entrada nesta tabela representa uma vacina específica que os usuários podem tomar.

5. **VacinasTomadas**: Esta tabela registra as vacinas tomadas pelos usuários. Ela está associada às tabelas `ListaVacinas` e `CarteiraVacina` por meio de chaves estrangeiras. Cada registro nesta tabela indica qual vacina foi tomada, em qual carteira de vacinação foi registrada e quantas doses foram administradas.

## Restrições e Relacionamentos

O banco de dados utiliza diversas restrições para garantir a integridade e consistência dos dados, incluindo:

- Chaves primárias: Garantem a unicidade e identificação de cada registro em suas respectivas tabelas.
- Índices únicos: Asseguram que certas colunas, como CPF e número do documento SUS, sejam únicas em todo o banco de dados.
- Chaves estrangeiras: Estabelecem relacionamentos entre as tabelas, permitindo a integridade referencial e a associação de dados entre diferentes entidades.

## Configurações do MySQL

O script realiza algumas configurações temporárias no MySQL, desativando verificações de chaves únicas e estrangeiras, além de ajustar o modo SQL para garantir compatibilidade e consistência durante o processo de criação do banco de dados e das tabelas.

Este banco de dados é projetado para fornecer uma estrutura robusta e eficiente para gerenciar informações relacionadas a carteiras de vacinação, permitindo o acompanhamento preciso das vacinas administradas aos usuários e facilitando a manutenção de registros atualizados.
Codigo SQL
