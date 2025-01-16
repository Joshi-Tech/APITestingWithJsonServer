pipeline {
    agent any
    environment {
        REPO_URL = 'https://github.com/Joshi-Tech/APITestingWithJsonServer'
    }
    stages {
        stage("Checkout QA") {
            steps {
                echo "Checking out QA branch"
                git branch: 'main', url: "${REPO_URL}"
            }
        }
        stage("Test QA") {
            steps {
                echo "Running tests on QA branch"
                bat "mvn test" // Use 'sh' instead of 'bat' if it's a Linux agent
            }
        }
    }
}
