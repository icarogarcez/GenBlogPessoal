package org.generation_blogpessoal.model;

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
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "tb_postagens")
@Data
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull (message = "Sua postagem precisa ter um título.")
	@Size(min = 5, max = 100)
	private String titulo;

	@NotNull (message = "Opa, cadê o corpo de texto? Ele não pode ficar vazio.")
	@Size(min = 10, max = 500)
	private String texto;
	
	@PositiveOrZero
	private int curtidas;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	

	// Relacionamento Tema

	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema temas;
	
	@ManyToOne
	@JsonIgnoreProperties ("postagens")
	private Usuario usuarios;

}
