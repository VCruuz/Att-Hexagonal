package application.service;

import domain.model.Cliente;
import domain.ports.BuscarClienteUseCase;
import domain.ports.CadastrarClienteUseCase;
import domain.ports.ClienteRepository;
import domain.ports.ListarClientesUseCase;
import domain.ports.RemoverClienteUseCase;

import java.util.List;
import java.util.Optional;

// essa classe é o serviço principal da aplicação
// ela implementa todos os casos de uso (ports de entrada)
// e usa o repositório (port de saída) para salvar e buscar dados
//
// o serviço não sabe de onde vem a chamada (console, api, etc)
// e também não sabe como os dados são salvos (memória, banco, etc)
// ele só executa a lógica de negócio
public class ClienteService
        implements CadastrarClienteUseCase,
                   ListarClientesUseCase,
                   BuscarClienteUseCase,
                   RemoverClienteUseCase {

    // repositório injetado como interface, não como classe concreta
    // isso permite trocar a implementação sem mexer aqui
    private final ClienteRepository clienteRepository;

    // contador para gerar os ids dos clientes automaticamente
    private Long proximoId = 1L;

    // construtor: recebe o repositório por injeção de dependência
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // cria um novo cliente com o próximo id disponível e manda salvar
    @Override
    public Cliente cadastrar(String nome, String email) {
        Cliente novoCliente = new Cliente(proximoId++, nome, email);
        return clienteRepository.salvar(novoCliente);
    }

    // só repassa a chamada para o repositório
    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    // busca pelo id, o Optional já vem do repositório
    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.buscarPorId(id);
    }

    // manda o repositório remover o cliente com esse id
    @Override
    public void remover(Long id) {
        clienteRepository.remover(id);
    }
}
