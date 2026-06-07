package domain.ports;

import domain.model.Cliente;
import java.util.List;

// Port de entrada: define o contrato do caso de uso de listagem.
public interface ListarClientesUseCase {

    List<Cliente> listarTodos();
}
