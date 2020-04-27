package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.ValidationGroups;
import com.algaworks.osworks.domain.exception.NegocioException;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;


import java.util.List;
import java.util.ArrayList;
import com.algaworks.osworks.api.model.Comentario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
public class OrdemServico {
	@Getter @Setter
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@Getter @Setter
	@NotNull
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@ManyToOne
	private Cliente cliente;
	@Getter @Setter
	@NotBlank
	private String descricao;
	@Getter @Setter
	@NotNull
	private BigDecimal preco;
	@Getter @Setter
	@OneToMany(mappedBy = "ordemServico")
	private List<Comentario> comentarios = new ArrayList<>();			
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	@JsonProperty(access = Access.READ_ONLY)
	private StatusOrdemServico status;
	@Getter @Setter
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataAbertura;
	@Getter @Setter
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;
	
	
	public void finalizar() {
		
		if(!StatusOrdemServico.ABERTA.equals(getStatus())) {
			throw new NegocioException("Ordem de Serviço não pode ser finalizada");
			
		}
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
	}
}
