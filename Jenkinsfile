pipeline {
    agent any

    stages {
        stage('Checkout SCM') {  
            steps {
                checkout scm
            }
        }
        stage('Docker Build') {
           steps {
            docker.withRegistry('https://registry.hub.docker.com/', 'DockerHub-Credentials-Arnd') {
                def customImage = docker.build("arndvorrath/dockerwebapp")  }
           }
        }
        stage('Push Container to DockerHub') {
        /* Push the container to the custom Registry */
            steps {
             customImage.push()
            }    
        }
    }
