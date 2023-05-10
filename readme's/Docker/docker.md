# Docker

### 1.1 Criação do arquivo Dockerfile
Dentro do nosso projeto, vamos criar um novo arquivo chamado Dockerfile.
O script do mesmo será o seguinte:

    FROM openjdk:17
	EXPOSE 8095
	ADD target/tarefas.jar tarefas.jar
	ENTRYPOINT [ "java","-jar","tarefas.jar" ]

------
### 1.2 Geração da imagem da aplicação
Vale lembrar que o Docker está rodando em um servidor fedora.
Vamos primeiro clonar nosso repositório do github.

    git clone https://github.com/perfil/repositorio

Agora vamos entrar dentro da pasta.

    cd repositorio
    
E então vamos instalar nosso jar com o Maven

    mvn clean install

Agora basta gerar a imagem.

    docker build -t nomedaimagem .

------
### 1.3 Geração do Container
Para gerar o container é bem simples

    docker run --name=nomedocontainer -p 123:123 nomedaimagem
    
Se tudo deu certo seu container irá subir e seu terminal irá travar. Para sair basta usar o atalho CTRL + Z ou CTRL + C