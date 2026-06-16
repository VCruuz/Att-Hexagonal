import adapters.in.ClienteConsoleAdapter;
import adapters.out.ClienteRepositoryMemory;
import application.service.ClienteService;
import domain.ports.ClienteRepository;

// essa é a classe principal, onde tudo é montado
// aqui é o único lugar que conhece as implementações concretas
// o serviço recebe o repositório, e o adapter recebe o serviço
//
// ordem de criação:
// 1. repositório (adapter de saída)
// 2. serviço (injeta o repositório)
// 3. adapter de entrada (injeta o serviço)
public class App {

    public static void main(String[] args) {

        // cria o repositório em memória (adapter de saída)
        // declarado como a interface ClienteRepository para manter o desacoplamento
        ClienteRepository repositorio = new ClienteRepositoryMemory();

        // cria o serviço injetando o repositório
        // o serviço não sabe que por baixo é uma lista em memória
        ClienteService servico = new ClienteService(repositorio);

        // cria o adapter de console injetando o serviço
        // o mesmo objeto (servico) é passado 4 vezes porque ele implementa os 4 casos de uso
        ClienteConsoleAdapter consoleAdapter = new ClienteConsoleAdapter(
            servico,   // CadastrarClienteUseCase
            servico,   // ListarClientesUseCase
            servico,   // BuscarClienteUseCase
            servico    // RemoverClienteUseCase
        );

        // inicia o sistema pelo adapter de entrada
        consoleAdapter.iniciar();
    }
}
