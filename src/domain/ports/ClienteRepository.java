package domain.ports;

import domain.model.Cliente;
import java.util.List;
import java.util.Optional;

// Port de saida: contrato de persistencia. O dominio nao sabe quem implementa.
public interface ClienteRepository {

    Cliente salvar(Cliente cliente);
    List<Cliente> listarTodos();
    Optional<Cliente> buscarPorId(Long id);
    void remover(Long id);
}
