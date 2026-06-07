import adapters.in.ClienteConsoleAdapter;
import adapters.out.ClienteRepositoryMemory;
import application.service.ClienteService;
import domain.ports.ClienteRepository;

// Composition Root: unico lugar onde os componentes sao instanciados e conectados.
public class App {

    public static void main(String[] args) {

        // Adapter de saida -> Servico -> Adapter de entrada
        ClienteRepository repositorio = new ClienteRepositoryMemory();
        ClienteService servico = new ClienteService(repositorio);

        ClienteConsoleAdapter consoleAdapter = new ClienteConsoleAdapter(
            servico, servico, servico, servico
        );

        consoleAdapter.iniciar();
    }
}
