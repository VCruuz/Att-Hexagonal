import adapters.in.ClienteConsoleAdapter;
import adapters.out.ClienteRepositoryMemory;
import application.service.ClienteService;
import domain.ports.ClienteRepository;

/**
 * Ponto de entrada da aplicacao: App.java
 *
 * Esta classe e responsavel pela composicao dos componentes (Composition Root).
 * E o unico lugar onde instancias concretas sao criadas e conectadas.
 *
 * Injecao de dependencia manual (sem framework):
 *   1. Cria o Adapter de Saida  (implementacao concreta do repositorio)
 *   2. Cria o Servico           (injeta o repositorio via Port)
 *   3. Cria o Adapter de Entrada (injeta o servico via Ports de Entrada)
 *
 * Visao da Arquitetura Hexagonal:
 *
 *   Adapter IN (Console)
 *        |
 *        | chama Ports de Entrada
 *        v
 *   NUCLEO (dominio + servico)
 *        |
 *        | chama Port de Saida
 *        v
 *   Adapter OUT (Memoria)
 *
 * Fluxo de execucao:
 *   1. Usuario digita no console
 *   2. ClienteConsoleAdapter captura a entrada
 *   3. Chama o Port de Entrada (Use Case)
 *   4. ClienteService executa a logica de negocio
 *   5. Chama o Port de Saida (ClienteRepository)
 *   6. ClienteRepositoryMemory persiste ou busca os dados
 *   7. Resultado retorna ate o console
 */
public class App {

    public static void main(String[] args) {

        // 1. Cria o Adapter de saida (implementacao da persistencia em memoria)
        ClienteRepository repositorio = new ClienteRepositoryMemory();

        // 2. Cria o servico, injetando o repositorio via Port (interface)
        ClienteService servico = new ClienteService(repositorio);

        // 3. Cria o Adapter de entrada, injetando o servico via Ports de Entrada
        ClienteConsoleAdapter consoleAdapter = new ClienteConsoleAdapter(
            servico,   // implementa CadastrarClienteUseCase
            servico,   // implementa ListarClientesUseCase
            servico,   // implementa BuscarClienteUseCase
            servico    // implementa RemoverClienteUseCase
        );

        // 4. Inicia a aplicacao pelo adapter de entrada
        consoleAdapter.iniciar();
    }
}
