package domain.ports;

// port de entrada para remover um cliente pelo id
// não precisa retornar nada, por isso o retorno é void
public interface RemoverClienteUseCase {

    void remover(Long id);
}
