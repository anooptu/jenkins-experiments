pipeline {
    agent any

    tools {
        nodejs 'Node18' // use the name you added in tool config
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/anooptu/jenkins-experiments.git', branch: 'main'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'npm install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'npm test'
            }
        }
    }

    post {
        success {
            echo '✅ CI pipeline completed successfully!'
        }
        failure {
            echo '❌ Something went wrong!'
        }
    }
}
