package com.algaworks.osworks.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class OrdemServicoModelRepresentationInput {
	
	
	@NotBlank
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	@NotNull
	private BigDecimal preco;
	@Getter @Setter
	@Valid
	@NotNull
	private ClienteIdInput cliente;

}
