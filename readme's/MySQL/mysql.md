# MySQL

### 1.1 Criação do banco de dados

Para a criação do banco de dados, foi definido um esquema de tabela com os seguintes campos:

-   **idtarefa**: campo definido como chave primária e auto increment, para garantir unicidade e controle na identificação de cada tarefa;
-   **titulo**: campo definido como varchar de até 60 caracteres, para armazenar o título da tarefa de forma clara e objetiva;
-   **descricao**: campo definido como texto, para armazenar informações adicionais sobre a tarefa, se necessário;
-   **datainicio**: campo definido como varchar de 15 caracteres, para armazenar a data de início da tarefa no formato DD/MM/YYYY;
-   **datatermino**: campo definido como varchar de 15 caracteres, para armazenar a data de término da tarefa no formato DD/MM/YYYY;
-   **estado**: campo definido como enum de duas opções ("Aberto" ou "Finalizado"), para armazenar o estado atual da tarefa.

O script de criação do banco de dados ficou da seguinte maneira:

    CREATE DATABASE tarefasdb CHARSET="utf8mb4" COLLATE="utf8mb4_general_ci";
    
    USE tarefasdb;
    
    CREATE TABLE tarefas(
	idtarefa int auto_increment primary key,
    titulo varchar(60) not null,
    descricao text not null,
    datainicio varchar(15) not null,
    datatermino varchar(15) not null,
    estado enum("Aberto", "Finalizado")
    );