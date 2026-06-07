package domain.ports;

import domain.model.Cliente;

// Port de entrada: define o contrato do caso de uso de cadastro.
public interface CadastrarClienteUseCase {

    Cliente cadastrar(String nome, String email);
}
