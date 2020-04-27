package com.algaworks.osworks.api.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.algaworks.osworks.domain.model.OrdemServico;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	@EqualsAndHashCode.Include
	private Long Id;
	@Getter @Setter
	@ManyToOne
	private OrdemServico ordemServico;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	private OffsetDateTime dataEnvio;

}
