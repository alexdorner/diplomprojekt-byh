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
			}
		}
		stage('Actions') {
			steps {
				emailext body: '''${SCRIPT, template="build-report.groovy"}''',
					subject: "[Jenkins] REPORT ${currentBuild.fullDisplayName}",
					to: "gru18163@spengergasse.at"
			}
		}
    }
}