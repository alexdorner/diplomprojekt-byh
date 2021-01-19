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
    }
	post {
		always {
			emailext attachLog: true, body: """Job: ${env.JOB_NAME}:${env.BUILD_NUMBER}\nStatus: ${currentBuild.result}""",
				subject: "[Jenkins] REPORT ${currentBuild.fullDisplayName}",
				to: "gru18163@spengergasse.at"
		}
	}
}