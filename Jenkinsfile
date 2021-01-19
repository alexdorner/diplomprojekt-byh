pipeline { 
    agent any 
	stages { 
		stage ('Initialize') {
            steps {
                echo "PATH = ${PATH}" 
            }
        }
        stage('Build') { 
            steps { 
               bat """
					cd api
					cd
					mvn compile
				""" 
            }
        }
		stage('Test') { 
            steps {
				bat """
					cd api
					cd
					mvn test
				"""
            }
        }
		stage('report') {
			junit 'target/surefire-reports/*.xml'
			allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
		}
		stage('actions') {
			emailext body: '''${SCRIPT, template="build-report.groovy"}''',
                subject: "[Jenkins] REPORT",
                to: "user@example.com"
		}
    }
}