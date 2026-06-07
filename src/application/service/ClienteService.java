package application.service;

import domain.model.Cliente;
import domain.ports.BuscarClienteUseCase;
import domain.ports.CadastrarClienteUseCase;
import domain.ports.ClienteRepository;
import domain.ports.ListarClientesUseCase;
import domain.ports.RemoverClienteUseCase;

import java.util.List;
import java.util.Optional;

// Implementa todos os casos de uso e delega a persistencia ao repositorio via Port.
public class ClienteService
        implements CadastrarClienteUseCase,
                   ListarClientesUseCase,
                   BuscarClienteUseCase,
                   RemoverClienteUseCase {

    private final ClienteRepository clienteRepository;
    private Long proximoId = 1L;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadastrar(String nome, String email) {
        Cliente novoCliente = new Cliente(proximoId++, nome, email);
        return clienteRepository.salvar(novoCliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.buscarPorId(id);
    }

    @Override
    public void remover(Long id) {
        clienteRepository.remover(id);
    }
}
