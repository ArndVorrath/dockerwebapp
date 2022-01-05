node {
    stage('Checkout SCM') {  
        checkout scm
    }
    stage('Docker Build') {
    docker.withRegistry('https://registry.hub.docker.com/', 'DockerHub-Credentials-Arnd') {
        def customImage = docker.build("arndvorrath/dockerwebapp")
    }
    }
    stage('Push Container to DockerHub') {
        /* Push the container to the custom Registry */
        customImage.push()
    }
}
