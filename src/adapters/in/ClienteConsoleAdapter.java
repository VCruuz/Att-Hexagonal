package adapters.in;

import domain.model.Cliente;
import domain.ports.BuscarClienteUseCase;
import domain.ports.CadastrarClienteUseCase;
import domain.ports.ListarClientesUseCase;
import domain.ports.RemoverClienteUseCase;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Adapter de entrada: ClienteConsoleAdapter
 *
 * Um Adapter de entrada recebe estimulos do mundo externo e os
 * traduz em chamadas aos Ports de Entrada (Use Cases) do nucleo.
 *
 * Neste projeto, o mundo externo e o console (teclado do usuario).
 * Em outro contexto, poderia ser:
 *   - ClienteRestAdapter    -> recebe requisicoes HTTP
 *   - ClienteGrpcAdapter    -> recebe chamadas gRPC
 *
 * Este adapter depende apenas das interfaces (Ports), nunca
 * das implementacoes concretas. Isso garante o desacoplamento total.
 */
public class ClienteConsoleAdapter {

    // Dependencias declaradas como interfaces (Ports de Entrada)
    private final CadastrarClienteUseCase cadastrarUseCase;
    private final ListarClientesUseCase   listarUseCase;
    private final BuscarClienteUseCase    buscarUseCase;
    private final RemoverClienteUseCase   removerUseCase;

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Recebe as dependencias por injecao, todas como interfaces.
     * Na pratica, o mesmo objeto (ClienteService) implementa todas elas.
     */
    public ClienteConsoleAdapter(CadastrarClienteUseCase cadastrarUseCase,
                                  ListarClientesUseCase   listarUseCase,
                                  BuscarClienteUseCase    buscarUseCase,
                                  RemoverClienteUseCase   removerUseCase) {
        this.cadastrarUseCase = cadastrarUseCase;
        this.listarUseCase    = listarUseCase;
        this.buscarUseCase    = buscarUseCase;
        this.removerUseCase   = removerUseCase;
    }

    // Inicia o loop principal do menu no console
    public void iniciar() {
        int opcao = -1;

        System.out.println("=====================================");
        System.out.println("  Sistema de Cadastro de Clientes   ");
        System.out.println("  Arquitetura Hexagonal - Java       ");
        System.out.println("=====================================");

        while (opcao != 0) {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> removerCliente();
                case 0 -> System.out.println("\nEncerrando o sistema. Ate logo!");
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n------------------------------");
        System.out.println("  MENU PRINCIPAL");
        System.out.println("------------------------------");
        System.out.println("  1 - Cadastrar Cliente");
        System.out.println("  2 - Listar Clientes");
        System.out.println("  3 - Buscar Cliente por ID");
        System.out.println("  4 - Remover Cliente");
        System.out.println("  0 - Sair");
        System.out.println("------------------------------");
        System.out.print("Escolha uma opcao: ");
    }

    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void cadastrarCliente() {
        System.out.println("\n[ CADASTRAR CLIENTE ]");
        System.out.print("Nome  : ");
        String nome = scanner.nextLine().trim();

        System.out.print("E-mail: ");
        String email = scanner.nextLine().trim();

        // Chamada ao Port de Entrada
        Cliente cliente = cadastrarUseCase.cadastrar(nome, email);
        System.out.println("Cliente cadastrado com sucesso: " + cliente);
    }

    private void listarClientes() {
        System.out.println("\n[ LISTA DE CLIENTES ]");
        List<Cliente> clientes = listarUseCase.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(c -> System.out.println("  " + c));
        }
    }

    private void buscarCliente() {
        System.out.println("\n[ BUSCAR CLIENTE ]");
        System.out.print("Informe o ID: ");
        try {
            Long id = Long.parseLong(scanner.nextLine().trim());
            Optional<Cliente> resultado = buscarUseCase.buscarPorId(id);

            if (resultado.isPresent()) {
                System.out.println("Cliente encontrado: " + resultado.get());
            } else {
                System.out.println("Cliente com ID " + id + " nao encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID invalido. Digite um numero inteiro.");
        }
    }

    private void removerCliente() {
        System.out.println("\n[ REMOVER CLIENTE ]");
        System.out.print("Informe o ID do cliente a remover: ");
        try {
            Long id = Long.parseLong(scanner.nextLine().trim());
            removerUseCase.remover(id);
            System.out.println("Cliente com ID " + id + " removido.");
        } catch (NumberFormatException e) {
            System.out.println("ID invalido. Digite um numero inteiro.");
        }
    }
}
