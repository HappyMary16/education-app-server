pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               bat 'mvn clean install'
            }
        }

        stage('Deploy') {
            steps {
                bat 'java -Dfile.encoding=utf-8 -jar target/server-0.0.1-SNAPSHOT.jar &'
            }
        }

        stage('End') {
            steps {
                echo 'END'
            }
        }
    }
}