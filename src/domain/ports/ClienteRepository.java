package domain.ports;

import domain.model.Cliente;
import java.util.List;
import java.util.Optional;

/**
 * Port de saida: ClienteRepository
 *
 * Um Port e uma interface que define um contrato entre o nucleo
 * da aplicacao e o mundo externo. Nao possui implementacao,
 * apenas declara o que precisa ser feito.
 *
 * Este port de saida define as operacoes de persistencia.
 * Quem implementa este contrato e um Adapter (memoria, banco, arquivo).
 * O dominio nao sabe qual implementacao esta sendo usada.
 */
public interface ClienteRepository {

    // Salva um cliente e retorna o cliente salvo
    Cliente salvar(Cliente cliente);

    // Retorna todos os clientes cadastrados
    List<Cliente> listarTodos();

    // Busca um cliente pelo ID
    Optional<Cliente> buscarPorId(Long id);

    // Remove o cliente com o ID informado
    void remover(Long id);
}
