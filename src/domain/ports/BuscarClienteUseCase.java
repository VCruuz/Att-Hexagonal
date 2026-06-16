package domain.ports;

import domain.model.Cliente;
import java.util.Optional;

// port de entrada para buscar um cliente pelo id
// usei Optional aqui para evitar retornar null
// se o cliente não existir, retorna Optional.empty() em vez de dar NullPointerException
public interface BuscarClienteUseCase {

    Optional<Cliente> buscarPorId(Long id);
}
