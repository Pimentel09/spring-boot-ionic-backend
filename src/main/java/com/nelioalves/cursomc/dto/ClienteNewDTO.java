package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.cursomc.services.validation.ClienteInsert;

import lombok.Getter;
import lombok.Setter;

@ClienteInsert
@Getter
@Setter
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L; 

	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120,message="O Tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cpfOuCnpj;
	
	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;
	
	private String complemento;
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;

	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1; 
	private String telefone2; 
	private String telefone3;
	
	private Integer cidadeId;
	
	
	public ClienteNewDTO() {
	}
	
}
