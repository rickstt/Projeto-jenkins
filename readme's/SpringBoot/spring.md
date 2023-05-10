# SpringBoot

### Primeiramente foi criado um novo projeto SpringBoot chamado `projetospringjenkins`. Nas configurações o gestor de pacote utilizado é o **Maven** junto ao Java17.

------
### 1.1 Configuração do applicattion.properties
Dentro deste arquivo será configurado o banco de dados e a porta utilizada

    spring.datasource.url = jdbc:mysql://172.17.0.2:3306/tarefasdb?usessl=false
    spring.datasource.username = root
    spring.datasource.password = 123
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.ddl-auto=update

    #Porta do servidor
    server.port = 8095

O ip 172.17.0.2 junto a porta 3306 são o respectivamente do meu container de servidor MySQL. Para coloca o caminho correto você deve verificar o ip do container e sua porta configurada. 
	
------
### 1.2 Criação da camada Domain
A seguir o script da camada Domain que tem o nome de **Tarefas**:

    package br.com.projetospringjenkins.domain;
    import br.com.projetospringjenkins.repository.Estado;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.EnumType;
	import jakarta.persistence.Enumerated;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

	@Entity
	public class Tarefas {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(nullable=false)
		private Integer idtarefa;
		@Column(nullable=false)
		private String titulo;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private String datainicio;
	
	@Column(nullable=false)
	private String datatermino;
	
	@Column(nullable=false)
	@Enumerated(value = EnumType.STRING)
	private Estado estado;

	public Tarefas() {
		super();
	}

	public Tarefas(Integer idtarefa, String titulo, String descricao, String datainicio, String datatermino,
			Estado estado) {
		super();
		this.idtarefa = idtarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.datainicio = datainicio;
		this.datatermino = datatermino;
		this.estado = estado;
	}

	public Integer getIdtarefa() {
		return idtarefa;
	}

	public void setIdtarefa(Integer idtarefa) {
		this.idtarefa = idtarefa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}

	public String getDatatermino() {
		return datatermino;
	}

	public void setDatatermino(String datatermino) {
		this.datatermino = datatermino;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	}
	
---------------

### 1.3 Criação da camada Repository

Primeiro vamos criar um arquivo chamado **TarefasRepository**:

    package br.com.projetospringjenkins.repository;
	import java.util.List;
	import org.springframework.data.jpa.repository.JpaRepository;
	import br.com.projetospringjenkins.domain.Tarefas;
	
	public  interface  TarefasRepository  extends  JpaRepository<Tarefas,  Integer>{
	
		public  List<Tarefas>  findByTitulo(String  titulo);
		public  List<Tarefas>  findByEstado(Estado  estado);
	}

Após isso vamos criar o arquivo **enum** chamado **Estado**:

    package br.com.projetospringjenkins.repository;
    
	public  enum  Estado  {
	Aberto,Finalizado
	}


---------------

### 1.4 Criação da camada Controller

Por fim, vamos criar a camada Controller que será chamada de **TarefasController**: 

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

## **Por fim suba o projeto inteiro para o github.**