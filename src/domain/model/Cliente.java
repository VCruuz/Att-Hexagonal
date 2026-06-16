package domain.model;

// Essa classe representa o cliente no sistema
// ela fica no dominio, que é o centro da arquitetura hexagonal
// aqui só tem os dados do cliente, sem nenhuma lógica de banco ou console
public class Cliente {

    private Long id;
    private String nome;
    private String email;

    // construtor que recebe os três dados do cliente
    public Cliente(Long id, String nome, String email) {
        this.id    = id;
        this.nome  = nome;
        this.email = email;
    }

    // getters e setters para acessar e modificar os atributos
    public Long getId()           { return id; }
    public void setId(Long id)    { this.id = id; }

    public String getNome()              { return nome; }
    public void   setNome(String nome)   { this.nome = nome; }

    public String getEmail()               { return email; }
    public void   setEmail(String email)   { this.email = email; }

    // toString para facilitar a exibição do cliente no console
    @Override
    public String toString() {
        return "Cliente{ id=" + id + ", nome='" + nome + "', email='" + email + "' }";
    }
}
