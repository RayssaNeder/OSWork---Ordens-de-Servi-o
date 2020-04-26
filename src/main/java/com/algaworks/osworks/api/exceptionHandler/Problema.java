package com.algaworks.osworks.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Problema {
	@Getter @Setter
	private Integer status;
	@Getter @Setter
	private LocalDateTime dataHora;
	@Getter @Setter
	private String titulo;
	@Getter @Setter
	private List<Campo> campos;
	
	
	@AllArgsConstructor
	public static class Campo{
		@Getter @Setter
		private String nome;
		@Getter @Setter
		private String mensagem;
	}
}

