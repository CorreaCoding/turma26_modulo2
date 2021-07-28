package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


         //Create Table tb_postagens
@Entity //Essa classe define uma tabela no meu Banco de Dados --> É uma entidade
@Table(name = "tb_postagens") // Confere o nome da tabela --> tb_postagens
public class Postagem {

	@Id //Descrevendo a chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Descrevendo o auto incremento
	private long id;
	
	@NotNull(message = "O campo titulo é  obrigatório!") //Indica que não pode ser vazio
	@Size(min = 5, max = 100, message = "O campo título, tem que ter no mínimo 5 e no máximo 100 caracteres." ) //Indica o tamanho do título
	private String titulo; //Indica que é uma String
	
	@NotNull(message = "O campo texto é obrigatório!") //Indica que não pode ser vazio
	@Size(min = 10, max = 500, message = "O campo Texto deve conter no mínimo 10 e no máximo 500 caracteres.")//Indica o tamanho do título
	private String texto; //Indica que é uma String
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	/*Métodos - Gets e Sets*/

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
	
	
	
	
}