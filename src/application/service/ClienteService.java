package application.service;

import domain.model.Cliente;
import domain.ports.BuscarClienteUseCase;
import domain.ports.CadastrarClienteUseCase;
import domain.ports.ClienteRepository;
import domain.ports.ListarClientesUseCase;
import domain.ports.RemoverClienteUseCase;

import java.util.List;
import java.util.Optional;

/**
 * Camada de aplicacao: ClienteService
 *
 * Esta classe e o coracao da Arquitetura Hexagonal. Ela:
 *
 * 1. Implementa os Ports de Entrada (Use Cases), sendo o executor
 *    das intencoes que chegam do mundo externo.
 *
 * 2. Depende do Port de Saida (ClienteRepository) via injecao de
 *    dependencia, sem saber qual implementacao concreta esta em uso.
 *
 * Fluxo:
 *   Adapter IN -> Port de Entrada -> ClienteService -> Port de Saida -> Adapter OUT
 */
public class ClienteService
        implements CadastrarClienteUseCase,
                   ListarClientesUseCase,
                   BuscarClienteUseCase,
                   RemoverClienteUseCase {

    // Dependencia declarada como Port (interface), nao como implementacao concreta
    private final ClienteRepository clienteRepository;

    // Contador simples para gerar IDs unicos
    private Long proximoId = 1L;

    /**
     * Construtor com injecao de dependencia manual (sem framework).
     * Quem instanciar o ClienteService precisa fornecer uma implementacao
     * de ClienteRepository.
     */
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Caso de uso: Cadastrar Cliente
    @Override
    public Cliente cadastrar(String nome, String email) {
        Cliente novoCliente = new Cliente(proximoId++, nome, email);
        return clienteRepository.salvar(novoCliente);
    }

    // Caso de uso: Listar Clientes
    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    // Caso de uso: Buscar Cliente por ID
    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.buscarPorId(id);
    }

    // Caso de uso: Remover Cliente
    @Override
    public void remover(Long id) {
        clienteRepository.remover(id);
    }
}
