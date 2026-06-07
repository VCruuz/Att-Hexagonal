package domain.ports;

import domain.model.Cliente;
import java.util.Optional;

/**
 * Port de entrada: BuscarClienteUseCase
 *
 * Define o contrato para o caso de uso de busca de cliente por ID.
 * Utiliza Optional para indicar que o cliente pode ou nao existir,
 * evitando NullPointerException.
 */
public interface BuscarClienteUseCase {

    // Busca um cliente pelo ID. Retorna Optional.empty() se nao encontrado
    Optional<Cliente> buscarPorId(Long id);
}
