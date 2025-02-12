pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    echo "building the app..."
                }
            }
        }

        stage('Run Unit Tests') {
            steps {
                script {
                    echo "testing the app..."
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    echo "Packaging the app.."
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                echo "archiving the app.."
            }
        }
    }

    post {
        success {
            echo 'Build and Tests passed successfully!'
        }
        failure {
            echo 'Build or Tests failed!'
        }
    }
}
