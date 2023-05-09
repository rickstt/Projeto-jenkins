package br.com.projetospringjenkins.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetospringjenkins.domain.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Integer>{

	public List<Tarefas> findByTitulo(String titulo);
	public List<Tarefas> findByEstado(Estado estado);
}
