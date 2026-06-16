package domain.ports;

import domain.model.Cliente;
import java.util.List;
import java.util.Optional;

// port de saída: define o que o sistema precisa de armazenamento
// é uma interface porque o serviço não precisa saber se os dados
// estão em memória, banco de dados, arquivo, etc.
// quem implementa isso é o adapter de saída
public interface ClienteRepository {

    // salva o cliente e retorna ele com os dados confirmados
    Cliente salvar(Cliente cliente);

    // retorna todos os clientes salvos
    List<Cliente> listarTodos();

    // busca pelo id, retorna Optional para não precisar lidar com null
    Optional<Cliente> buscarPorId(Long id);

    // remove o cliente com esse id
    void remover(Long id);
}
