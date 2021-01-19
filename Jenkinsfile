pipeline { 
    agent any 
	stages { 
		stage('Initialize') {
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
		stage('Report') {
			steps {
				junit 'api/target/surefire-reports/*.xml'
				allure includeProperties: false, jdk: '', results: [[path: 'api/target/allure-results']]
			}
		}
		stage('Actions') {
			steps {
				emailext body: '''${SCRIPT, template="build-report.groovy"}''',
					subject: "[Jenkins] REPORT",
					to: "user@example.com"
			}
		}
    }
}