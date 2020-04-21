package com.algaworks.osworks.domain.model;

import lombok.Getter;
import lombok.Setter;

public class Cliente {
	
	@Getter @Setter
	private Long id;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String telefone;
	
	

}
