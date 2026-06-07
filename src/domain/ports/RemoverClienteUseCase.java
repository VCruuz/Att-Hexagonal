package domain.ports;

// Port de entrada: define o contrato do caso de uso de remocao.
public interface RemoverClienteUseCase {

    void remover(Long id);
}
