pipeline {
environment {
registry = "https://registry.hub.docker.com/arndvorrath/"
registryCredential = 'DockerHub-Credentials-Arnd'
dockerImage = ''
}
    agent any

    stages {

        stage('Cloning our Git') {
            steps {
                checkout scm
            }
        }
        stage('Building our image') {
            steps{
                script {
                    dockerImage = docker.build registry + "dockerwebapp:$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy our image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps{
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}
