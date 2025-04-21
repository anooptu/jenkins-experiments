pipeline {
    agent any

    tools {
        nodejs 'Node23' // use the name you added in tool config
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/anooptu/sample-node-project.git', branch: 'main'
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
