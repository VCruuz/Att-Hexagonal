package domain.ports;

import domain.model.Cliente;

// port de entrada: define o que o sistema consegue fazer
// nesse caso, cadastrar um cliente
// é uma interface porque o adapter de entrada não precisa saber como funciona por dentro
public interface CadastrarClienteUseCase {

    // recebe o nome e o email e retorna o cliente já com o id gerado
    Cliente cadastrar(String nome, String email);
}
