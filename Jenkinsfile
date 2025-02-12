pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven 3' // Ensure Maven is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    echo "Checking out branch ${env.BRANCH_NAME}"
                    checkout scm
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Run Unit Tests') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    sh 'mvn package -DskipTests'  // Skips tests since they were run earlier
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
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
