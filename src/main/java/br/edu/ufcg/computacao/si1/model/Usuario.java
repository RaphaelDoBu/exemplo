package br.edu.ufcg.computacao.si1.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario extends org.springframework.security.core.userdetails.User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @Column(unique = true)
    private String email;
    @Column
    private String senha;
    @Column
    private String role;
    @Column
	private double saldoDevedor;
	@Column
	private double saldoCredor;
    
    
    public Usuario() {
        super("teste", "default", AuthorityUtils.createAuthorityList("USER"));
    }

    public Usuario(String nome, String email, String senha, String role) {

        super(email, senha, AuthorityUtils.createAuthorityList(role));

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.saldoCredor = 100;
        this.saldoDevedor = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String r) {
        this.role = r;
    }
    
    
    public double getSaldoDevedor() {
		return saldoDevedor;
	}

	public void setSaldoDevedor(double saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}

	public double getSaldoCredor() {
		return saldoCredor;
	}

	public void setSaldoCredor(double saldoCredor) {
		this.saldoCredor = saldoCredor;
	}
	
	public void compraAnuncio(double valor){
		saldoCredor -= valor;
		saldoDevedor += valor;
	}
	
	public void vendeAnuncio(double valor){
		saldoCredor += valor;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", role=" + role
				+ "]";
	}
    
    

}
