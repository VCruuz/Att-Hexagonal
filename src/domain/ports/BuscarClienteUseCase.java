package domain.ports;

import domain.model.Cliente;
import java.util.Optional;

// Port de entrada: define o contrato do caso de uso de busca por ID.
public interface BuscarClienteUseCase {

    Optional<Cliente> buscarPorId(Long id);
}
