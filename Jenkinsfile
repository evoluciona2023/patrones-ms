pipeline {
    agent any

    environment {
        REGISTRY = "ghcr.io/evoluciona2023"
        IMAGE_NAME = "patrones-ms"
        IMAGE_TAG = "${env.BUILD_NUMBER}"
        DOCKER_CREDENTIALS_ID = "ghcr-credentials"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/evoluciona2023/patrones-ms.git'
            }
        }

        stage('Build JAR') {
            steps { sh 'mvn -q -DskipTests clean package' }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                    docker build -t ${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG} \
                                 -t ${REGISTRY}/${IMAGE_NAME}:latest .
                '''
            }
        }

        stage('Push to GHCR') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDENTIALS_ID}", usernameVariable: 'GH_USER', passwordVariable: 'GH_TOKEN')]) {
                    sh '''
                        echo $GH_TOKEN | docker login ghcr.io -u $GH_USER --password-stdin
                        docker push ${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}
                        docker push ${REGISTRY}/${IMAGE_NAME}:latest
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "✅ Imagen publicada: ${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}"
            echo "🚀 Disparando pipeline de despliegue con IMAGE_TAG=${IMAGE_TAG}"
            build job: 'Patrones-MS-Deploy', parameters: [string(name: 'IMAGE_TAG', value: "${IMAGE_TAG}")], wait: false
        }
        failure { echo "❌ Error en el pipeline de build. No se ejecutará el despliegue." }
    }
}
