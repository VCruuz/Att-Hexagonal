package domain.model;

/**
 * Entidade de dominio: Cliente
 *
 * O dominio e o nucleo da Arquitetura Hexagonal.
 * Contem apenas as regras de negocio puras, sem depender
 * de nenhuma tecnologia externa (banco de dados, console, etc.).
 */
public class Cliente {

    private Long id;
    private String nome;
    private String email;

    public Cliente(Long id, String nome, String email) {
        this.id    = id;
        this.nome  = nome;
        this.email = email;
    }

    public Long getId()           { return id; }
    public void setId(Long id)    { this.id = id; }

    public String getNome()              { return nome; }
    public void   setNome(String nome)   { this.nome = nome; }

    public String getEmail()               { return email; }
    public void   setEmail(String email)   { this.email = email; }

    @Override
    public String toString() {
        return "Cliente{ id=" + id + ", nome='" + nome + "', email='" + email + "' }";
    }
}
