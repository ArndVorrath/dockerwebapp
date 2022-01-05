node {
    checkout scm

    docker.withRegistry('https://registry.hub.docker.com/', 'DockerHub-Credentials-Arnd') {

        def customImage = docker.build("arndvorrath/dockerwebapp")

        /* Push the container to the custom Registry */
        customImage.push()
    }
}