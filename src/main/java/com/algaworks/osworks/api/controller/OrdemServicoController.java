package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.api.model.OrdemServicoModelRepresentationInput;
import com.algaworks.osworks.api.model.OrdemServicoRepresentationModel;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;
import com.algaworks.osworks.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {
	
	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServico;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoRepresentationModel criar(@Valid @RequestBody OrdemServicoModelRepresentationInput ordemServicoInput) {
		OrdemServico ordemServico = toEntity(ordemServicoInput);
		return toModelRepresentation(gestaoOrdemServico.cria(ordemServico));
	}
	
	@GetMapping
	public List<OrdemServicoRepresentationModel> listar(){
		return toColectionModelRepresentation(ordemServicoRepository.findAll());
	}
	
	
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoRepresentationModel> buscar(@PathVariable Long ordemServicoId){
		Optional<OrdemServico> ordemServicoOptional = ordemServicoRepository.findById(ordemServicoId);
		
		if(ordemServicoOptional.isPresent()) {
			OrdemServicoRepresentationModel model = toModelRepresentation(ordemServicoOptional.get());
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.notFound().build();
	}

	private OrdemServicoRepresentationModel toModelRepresentation(OrdemServico ordemServico) {
		OrdemServicoRepresentationModel model = modelMapper.map(ordemServico, OrdemServicoRepresentationModel.class);
		return model;
	}
	
	private List<OrdemServicoRepresentationModel> toColectionModelRepresentation(List<OrdemServico> ordensServico){
		return ordensServico.stream()
				.map(ordemServico -> toModelRepresentation(ordemServico))
				.collect(Collectors.toList());
	}
	
	
	private OrdemServico toEntity(OrdemServicoModelRepresentationInput ordemServicoInput) {
		return modelMapper.map(ordemServicoInput, OrdemServico.class);
	}
	
	@PutMapping("/{ordemServicoId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemServicoId) {
		gestaoOrdemServico.finalizar(ordemServicoId);
	}
	
	
}
