package domain.ports;

import domain.model.Cliente;
import java.util.List;

// port de entrada para listar todos os clientes cadastrados
// o adapter chama essa interface sem saber de onde os dados vêm
public interface ListarClientesUseCase {

    // retorna uma lista com todos os clientes, ou vazia se não tiver nenhum
    List<Cliente> listarTodos();
}
