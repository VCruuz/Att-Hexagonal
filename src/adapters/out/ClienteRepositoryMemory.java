package adapters.out;

import domain.model.Cliente;
import domain.ports.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Adapter de saida: implementa o port ClienteRepository usando ArrayList em memoria.
public class ClienteRepositoryMemory implements ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente salvar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void remover(Long id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }
}
