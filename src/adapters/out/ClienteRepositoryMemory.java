package adapters.out;

import domain.model.Cliente;
import domain.ports.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// adapter de saída: implementa o ClienteRepository usando uma lista em memória
// aqui é onde os dados realmente ficam salvos durante a execução
// se fosse um projeto real, essa classe poderia ser trocada por uma que usa banco de dados
// o restante da aplicação não precisaria mudar nada
public class ClienteRepositoryMemory implements ClienteRepository {

    // lista que faz o papel de "banco de dados" em memória
    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente salvar(Cliente cliente) {
        clientes.add(cliente); // adiciona na lista
        return cliente;
    }

    @Override
    public List<Cliente> listarTodos() {
        // retorna uma cópia da lista para não deixar ninguém mexer diretamente nela
        return new ArrayList<>(clientes);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        // usa stream para percorrer a lista e filtrar pelo id
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void remover(Long id) {
        // removeIf remove todos os elementos que satisfazem a condição
        clientes.removeIf(c -> c.getId().equals(id));
    }
}
