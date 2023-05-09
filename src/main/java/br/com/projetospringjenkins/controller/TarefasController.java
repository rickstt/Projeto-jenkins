package br.com.projetospringjenkins.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetospringjenkins.domain.Tarefas;
import br.com.projetospringjenkins.repository.Estado;
import br.com.projetospringjenkins.repository.TarefasRepository;

@RestController
public class TarefasController {
	
	@Autowired
	private TarefasRepository tr;
	
	@GetMapping("/tarefas/listar")
	public List<Tarefas> lista(){
		return tr.findAll();
	}
	
	@GetMapping("/tarefas/listar/{titulo}")
	public List<Tarefas> listarTitulo(@RequestParam String titulo){
		return tr.findByTitulo(titulo);
	}
	
	@GetMapping("/tarefas/listar/aberto")
	public List<Tarefas> listarAberto(Estado estado){
		return tr.findByEstado(Estado.Aberto);
	}
	
	@GetMapping("/tarefas/listar/finalizado")
	public List<Tarefas> listarFinalizado(Estado estado){
		return tr.findByEstado(Estado.Finalizado);
	}
	
	@PostMapping("/tarefas/cadastrar")
	public String cadastrar(@RequestBody Tarefas trc) {
		tr.save(trc);
		return "Tarefa cadastrada com sucesso";
	}
	
	@PutMapping("/tarefas/atuaizar/{id}")
	public String aualizar(@PathVariable Integer id, @RequestBody Tarefas tarefas){
		String msg = "";
		Optional<Tarefas> t = tr.findById(id);
		
		if(t.isPresent()) {
			tarefas.setIdtarefa(id);
			tr.save(tarefas);
			msg = "Curso atualizado";
		}
		else {
			msg = "Curso não encontrado";
		}
		
		return msg;
	}
}
