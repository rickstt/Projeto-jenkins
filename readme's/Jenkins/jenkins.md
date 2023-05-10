# Jenkins

### 1.1 Script de automação
No Jenkins vamos criar uma nova pipeline. Habilitar o **GitHub project** e o **GitHub hook trigger for GITScm polling**

E então vamos fazer o nosso script:

    pipeline{
    agent any
    tools{
        maven'maven_3_8_5'
    }
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/perfil/repositorio']])
                sh 'mvn clean install'
            }
        }
        stage('Gerar nova Imagem do docker'){
            steps{
                script{
                    sh 'docker build -t tarefas .'
                }
            }
        }
        stage('Gerar novo Container'){
            steps{
                script{
                    sh 'docker run --name=nomecontainer -p 8095:8095 -d nomeimagem'
                }
            }
        }
    }
	}