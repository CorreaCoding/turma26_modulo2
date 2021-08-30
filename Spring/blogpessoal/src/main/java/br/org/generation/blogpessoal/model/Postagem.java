package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//CREATE TABLE TB_POSTAGENS 
@Entity // Estou dizendo que está classe definirá uma Tabela no meu Banco de Dados, ou seja, uma Entidade
@Table(name = "tb_postagens") //Aqui eu estou dizendo qual será o nome da minha tabela, no caso é "tb_postagens", se não colocar a anotação o nome da tabela é o nome da classe (Exemplo: Postagem)
public class Postagem{

	@Id //Chave Primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento
	private long id;
	
	@NotNull(message = "É obrigatório inserir um título!") // O atributo é obrigatório, e a mensagem irá aparecer caso o campo seja nulo.
	@Size(min = 5, max = 100, message = "O título da sua Postagem deve ter no mínimo 05 e no máximo 100 caracteres." ) //Indica o tamanho do título e a mensagem que deve aparecer caso ocorra um erro.
	private String titulo; //Indica que é uma String
	
	@NotNull(message = "É obrigatório inserir um texto na sua Postagem!")// O atributo é obrigatório, e a mensagem irá aparecer caso o campo seja nulo. 
	@Size(min = 2, max = 500, message = "O texto da sua Postagem deve conter no mínimo 10 e no máximo 500 caracteres.")//Indica o tamanho do título e a mensagem que deve aparecer caso ocorra um erro.
	private String texto; //Indica que é uma String
	
	@Temporal(TemporalType.TIMESTAMP)//TIMESTAMP utiliza a data e a hora do servidor e grava.
	private Date data = new java.sql.Date(System.currentTimeMillis()); //Traz a hora com milissegundos, essa precisão é para que não ocorram conflitos entre arquivos, já que é díficil mandar o mesmo arquivo no mesmo milissegundo. 
	
	@ManyToOne //Significa que uma postagem terá apenas um tema, e consequentemente, um tema terá várias postagens.
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
    @JsonIgnoreProperties("postagem")
	private Usuario usuario;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
}
	
	
	
	
