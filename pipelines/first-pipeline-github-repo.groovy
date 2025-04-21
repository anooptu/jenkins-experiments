pipeline {
    agent any

    environment {
        GREETING = 'Hey there'
        BUILD_ENV = 'dev'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/anooptu/jenkins-experiments.git'
            }
        }

        stage('Say Hello') {
            steps {
                echo "${GREETING}, this is the ${BUILD_ENV} environment!"
            }
        }

        stage('Manual Approval') {
            steps {
                input message: 'Do you want to proceed?', ok: 'Yes, go!'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Pretend we are deploying something awesome 🚀'
            }
        }
    }

    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
