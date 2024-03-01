Este código Java implementa um sistema simples de gerenciamento de produtos com operações básicas, como listar produtos, buscar por ID, adicionar, atualizar e excluir produtos. Vou explicar o que acontece em cada classe e no código em geral:

Main Class
- O ponto de entrada (método main) do programa.
- Utiliza um loop para exibir um menu interativo e realizar operações com base na escolha do usuário.
- Cria uma instância de ProductHandler para lidar com as operações dos produtos.
- Usa a classe HTTP para representar respostas HTTP em diferentes situações.
- Possui métodos para listar, buscar, adicionar, atualizar e excluir produtos.

Product Class
- Representa um produto com atributos como ID, nome, descrição e valor.
- Possui métodos getters e setters para acessar e modificar os atributos.
- Implementa o método toString para retornar uma representação em formato JSON do objeto, conforme é solicitado na Regra de Negócio.

HTTP Class
- Representa uma resposta HTTP com código de status, status e mensagem.
- Utilizada para fornecer feedback sobre o sucesso ou falha de operações.

ProductHandler Class
- Manipula operações relacionadas aos produtos.
- Possui métodos para listar todos os produtos, buscar por ID, adicionar, atualizar e excluir produtos.
- Lança uma exceção personalizada DuplicateName se houver tentativa de adicionar um produto com o mesmo nome.
- Contém um bloco try-catch para tratar exceções relacionadas à conversão de valores durante a entrada do usuário.

Funcionamento Geral
1. Listar Produtos (case 1): Chama o método listAll da classe ProductHandler para exibir os produtos cadastrados.
2. Buscar por ID (case 2): Solicita ao usuário um ID e chama findById da classe ProductHandler para procurar e exibir o produto correspondente.
3. Adicionar Produto (case 3): Solicita informações ao usuário, cria um objeto Product, e chama create da classe ProductHandler para adicioná-lo à lista de produtos.
4. Atualizar Produto (case 4): Solicita informações ao usuário, incluindo o ID do produto a ser atualizado, e chama update da classe ProductHandler.
5. Excluir Produto (case 5): Solicita o ID do produto a ser excluído e chama delete da classe ProductHandler.
6. Sair do Programa (case 0): Fecha o scanner e encerra o programa.

Observações:
- O código está estruturado em classes e métodos para facilitar a manutenção e compreensão.
- Utiliza a exceção DuplicateName para lidar com produtos de mesmo nome durante a adição.
- Mensagens de feedback são apresentadas ao usuário usando a classe HTTP.
- A lógica de entrada de dados é cuidadosamente tratada para evitar exceções.

Este sistema proporciona uma interface de linha de comando para gerenciar uma lista de produtos, interagindo com o usuário por meio de um menu simples.

Nota Extra
Quanto ao programa de bolsas, considero crucial compartilhar minhas percepções sobre o aprendizado adquirido. Destaco a importância do trabalho em grupo e a necessidade de buscar auxílio dos meus supervisores para resolver conflitos.
Sobre os conceitos aprendidos:
Try-catch: O bloco try-catch é fundamental para manipulação de exceções. Se ocorrer uma exceção dentro do bloco try, o controle é transferido para o bloco catch, onde o código específico para lidar com a exceção é executado.

Throw: O throw é utilizado para lançar explicitamente uma exceção. Em situações de erro ou circunstâncias excepcionais, podemos usar throw para lançar uma instância de uma classe de exceção.

isEmpty: O método isEmpty é relevante para verificar se uma determinada estrutura de dados, como uma string ou uma coleção, está vazia. É uma prática útil para a manipulação eficiente de dados.

Instanciar método dentro do print: É possível instanciar um método diretamente dentro do método println, como exemplificado em System.out.println(new HTTP(200, "OK", "Request successful."));. Isso facilita a impressão de resultados de métodos no console.

parseInt / parseDouble: As funções parseInt e parseDouble são utilizadas para converter strings em tipos numéricos inteiros e de ponto flutuante, respectivamente. Essas conversões são essenciais para operações matemáticas e manipulação de dados quando se trabalha com entradas fornecidas como texto."
size: O método size é crucial ao lidar com estruturas de dados, fornecendo a quantidade de elementos presentes. Essencial para arrays, listas ou coleções, o size permite uma gestão eficaz do conteúdo, sendo especialmente útil ao iterar sobre essas estruturas ou ao realizar validações de tamanho.
Padrão JSON e Protocolo HTTP.
Espero que essas informações sejam úteis para o aprimoramento contínuo do Programa de Bolsas. Estou muito satisfeita com o resultado do desafio, com o aprendizado e com todo o conhecimento que o Programa de Bolsas da Compass me proporcionou.


