[![Linguagens Presentes na documentação](https://skillicons.dev/icons?i=mysql,java,spring,docker,git,jenkins)](https://skillicons.dev)
# Init:

Esta documentação tem como objetivo fornecer uma visão geral do projeto ***Springboot*** que foi desenvolvido e automatizado no GitHub com ***Jenkins***. Este projeto foi desenvolvido utilizando o framework do ***Java***, ***Springboot*** e utiliza um banco de dados ***MySQL*** para persistência de dados. Além disso, foi criado um container da aplicação **Springboot** via **Docker**, que permitiu a fácil execução e implantação da aplicação em diferentes ambientes.

## Glossário

- Java: Java é uma linguagem de programação de alto nível e orientada a objetos que é usada para desenvolver aplicativos em uma variedade de plataformas e dispositivos.

- SpringBoot: Springboot é um framework de desenvolvimento de aplicativos Java que ajuda os desenvolvedores a criar aplicativos de maneira rápida e fácil.

- MySQL: MySQL é um sistema de gerenciamento de banco de dados relacional de código aberto.

- Jenkins: Jenkins é uma ferramenta de integração contínua que ajuda a automatizar a compilação, teste e implantação de aplicativos.

- Docker: Docker é uma tecnologia de contêiner de software que permite a criação, distribuição e execução de aplicativos em um ambiente isolado e portátil.

# Introdução
Para a realização do projeto, foi proposto um cenário em que um Gestor precisava organizar suas tarefas de forma mais eficiente. Dessa forma, a aplicação desenvolvida tem como objetivo atender às necessidades do usuário, permitindo as seguintes funcionalidades:

-   Listagem de todas as tarefas cadastradas no sistema;
-   Listagem de tarefas específicas por meio de seu título;
-   Listagem de tarefas filtradas por estado, podendo ser "Finalizado" ou "Aberto";
-   Cadastro de novas tarefas no sistema;
-   Atualização de informações relacionadas às tarefas já existentes no sistema.

# Sumário

1. [MySQL](#)
    * 1.1 Criação do banco de dados

2. [SpringBoot](#)
    * 1.1 Configuração do applicattion.properties
	* 1.2 Criação da camada Domain
	* 1.3 Criação da camada Repository
	* 1.4 Criação da camada Controller

3. [Docker](#)
	* 1.1 Criação do arquivo Dockerfile
	* 1.2 Geração da imagem da aplicação
	* 1.3 Geração do Container

4. [Jenkins](#)
	* 1.1 Script de automação




Por Henrique Santos. Contato  [rickdev.contato@gmail.com](mailto:rickdev.contato@gmail.com)
