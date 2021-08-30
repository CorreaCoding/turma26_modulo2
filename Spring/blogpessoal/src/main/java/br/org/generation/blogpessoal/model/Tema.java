package br.org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//CREATE TABLE TB_TEMA
@Entity // Estou dizendo que está classe definirá uma Tabela no meu Banco de Dados, ou seja, uma Entidade
@Table(name="tb_tema")//Aqui eu estou dizendo qual será o nome da minha tabela, no caso é "tb_tema", se não colocar a anotação o nome da tabela é o nome da classe (Exemplo: Tema)
public class Tema {
	
	
		@Id //Chave Primária 
		@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento
		private long id;
		
		@NotNull(message = "O atributo de Descrição do Tema é  obrigatório!") // O atributo é obrigatório e a mensagem irá aparecer caso o campo seja nulo.
		@Size(min = 2, max = 100, message = "A Descrição deve ter entre 10 e 100 caracteres.")//Indica o tamanho do título e a mensagem que deve aparecer caso ocorra um erro.
		private String descricao;

		
		@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	    @JsonIgnoreProperties("tema")
		private  List<Postagem> postagem;
		
		
		//gets e sets 
		public List<Postagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}

		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
		
	
	
}