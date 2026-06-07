package domain.ports;

import domain.model.Cliente;
import java.util.List;

/**
 * Port de entrada: ListarClientesUseCase
 *
 * Define o contrato para o caso de uso de listagem de clientes.
 * O adaptador de entrada chama este port sem conhecer
 * os detalhes de implementacao do servico ou da persistencia.
 */
public interface ListarClientesUseCase {

    // Retorna todos os clientes cadastrados no sistema
    List<Cliente> listarTodos();
}
