pipeline {
    agent any
    environment {
        PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
    }
    tools {
        maven 'Maven3'    // Nombre EXACTO configurado en Jenkins -> Global Tool Configuration
        jdk 'JDK21'       // O el que hayas configurado (ej: Java17)
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ByronBonillaEC/eureka.git', credentialsId: 'github-credentials'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t servicio1 .'
            }
        }

        stage('Docker Run') {
            steps {
                // En Windows para detener y eliminar contenedores
                bat '''
                docker stop servicio1 || exit 0
                docker rm servicio1 || exit 0
                docker run -d -p 8081:8081 --name servicio1 servicio1
                '''
            }
        }
    }
}
