package br.org.generation.lojagames.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios") //Caso não seja nomeada, o nome da tabela no BD será o nome da classe.
public class Usuario {

	@Id //Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento
	private long id;
	
	@NotBlank(message = "Esse campo não deve ficar em branco!") 
	private String nome;
	
	@NotNull(message = "Um nome de usuário deve ser inserido")
	private String usuario;
	
	@NotNull(message = "Uma senha deve ser inserido")
	@Size (min = 6) //Colocar o máximo estoura o dado no banco
	private String senha;
	
	@Column(name = "datanascimento")//Para formatar o nome da variável na tabela
	@JsonFormat(pattern = "yyyy-MM-dd")//Formatação da data de nascimento
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE) //Só vai se propagar em cascata quando tiver uma remoção
	@JsonIgnoreProperties("usuario")//Recursividade
	private List<Produto> produto; //Um usuário pode ter uma lista de produtos

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
	
	
}
