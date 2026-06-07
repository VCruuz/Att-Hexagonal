package domain.ports;

import domain.model.Cliente;

/**
 * Port de entrada: CadastrarClienteUseCase
 *
 * Os Ports de entrada definem as acoes que o sistema disponibiliza
 * para o mundo externo acionar. Sao as portas de entrada do hexagono.
 *
 * Um Use Case representa uma intencao do usuario no sistema.
 * Cada interface define um unico caso de uso (principio SRP).
 */
public interface CadastrarClienteUseCase {

    // Cadastra um novo cliente no sistema e retorna o cliente com ID gerado
    Cliente cadastrar(String nome, String email);
}
