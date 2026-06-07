package adapters.out;

import domain.model.Cliente;
import domain.ports.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Adapter de saida: ClienteRepositoryMemory
 *
 * Um Adapter e uma implementacao concreta de um Port.
 * Ele faz a traducao entre o contrato definido pelo dominio
 * e uma tecnologia especifica. Neste caso, usa um ArrayList em memoria.
 *
 * Poderia ser substituido por:
 *   - ClienteRepositoryMySQL    -> persiste em banco MySQL
 *   - ClienteRepositoryPostgres -> persiste em banco PostgreSQL
 *   - ClienteRepositoryArquivo  -> persiste em arquivo .txt
 *
 * O nucleo da aplicacao nao precisaria ser alterado para trocar este adapter.
 * Esse e o grande beneficio da Arquitetura Hexagonal.
 */
public class ClienteRepositoryMemory implements ClienteRepository {

    // Banco de dados em memoria usando ArrayList
    private final List<Cliente> clientes = new ArrayList<>();

    // Salva o cliente na lista em memoria
    @Override
    public Cliente salvar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    // Retorna uma copia da lista para evitar modificacoes externas
    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    // Percorre a lista buscando o cliente com o ID informado
    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    // Remove o cliente com o ID informado da lista
    @Override
    public void remover(Long id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }
}
