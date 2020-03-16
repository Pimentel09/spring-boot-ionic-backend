package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.cursomc.domain.Cliente;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120,message="O Tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	public ClienteDTO() {	
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}

}
