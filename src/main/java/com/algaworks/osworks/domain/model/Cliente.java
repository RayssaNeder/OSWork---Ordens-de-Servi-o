package com.algaworks.osworks.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Getter @Setter
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	@Getter @Setter
	private String nome;
	
	@NotBlank
	@Email
	@Getter @Setter
	private String email;
	
	@NotBlank
	@Size(max = 20)
	@Getter @Setter
	private String telefone;
	
	

}
