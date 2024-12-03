package br.uff.devweb.energia_empresa.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cliente")
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
        @NamedQuery(name = "Cliente.findByCPF", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
})
@XmlRootElement
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @ManyToMany
    @JoinTable(
            name = "cliente_os",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "os_id")
    )
    private List<OrdemServico> ordensServico;

    public Cliente(String cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Cliente(Long id, String cpf, String nome, String endereco, List<OrdemServico> ordensServico) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.ordensServico = ordensServico;
    }

    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
