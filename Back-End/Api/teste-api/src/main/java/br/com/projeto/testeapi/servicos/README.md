## Explicação dos métodos:

### handleValidationExceptions:

Este método trata exceções do tipo `MethodArgumentNotValidException`, que ocorrem quando argumentos de método, como um corpo de requisição, falham na validação.
Um mapa (`errors`) é criado para armazenar os nomes dos campos que falharam na validação e suas mensagens de erro associadas.
Usamos `ex.getBindingResult().getAllErrors()` para iterar por todos os erros de validação.
Para cada erro, obtemos o nome do campo e a mensagem de erro, adicionando-os ao mapa.
Finalmente, retornamos o mapa de erros com um status HTTP 400 (Bad Request).

### handleConstraintViolationException:

Este método trata exceções do tipo `ConstraintViolationException`, que ocorrem quando validações de constraint são violadas diretamente, geralmente em validações de parâmetros de método em controladores.
Um mapa (`errors`) é criado para armazenar os nomes dos campos que falharam na validação e suas mensagens de erro associadas.
Usamos `ex.getConstraintViolations()` para iterar por todas as violações de constraint.
Para cada violação, obtemos o caminho do campo e a mensagem de erro, adicionando-os ao mapa.
Finalmente, retornamos o mapa de erros com um status HTTP 400 (Bad Request).

Com esses comentários, outros desenvolvedores devem ser capazes de entender o que cada parte do código está fazendo e como ele lida com as exceções de validação.
