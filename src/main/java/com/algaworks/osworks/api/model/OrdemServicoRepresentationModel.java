package com.algaworks.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.model.StatusOrdemServico;

import lombok.Getter;
import lombok.Setter;

public class OrdemServicoRepresentationModel {
	
	@Getter @Setter
	private Long id;
	@Getter @Setter
	private ClienteResumoModelRepresentation cliente;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	private BigDecimal preco;
	@Getter @Setter
	private StatusOrdemServico status;
	@Getter @Setter
	private OffsetDateTime dataAbertura;
	@Getter @Setter
	private OffsetDateTime dataFinalizacao;

}
