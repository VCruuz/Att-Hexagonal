package domain.ports;

/**
 * Port de entrada: RemoverClienteUseCase
 *
 * Define o contrato para o caso de uso de remocao de cliente.
 */
public interface RemoverClienteUseCase {

    // Remove um cliente do sistema pelo seu ID
    void remover(Long id);
}
