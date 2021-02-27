pipeline { 
    agent any 
	stages { 
		stage('Initialize') {
            steps {
                echo "PATH = ${PATH}" 
            }
        }
        stage('Build API') { 
            steps { 
               sh """
					cd api
					cd
					mvn compile
				""" 
            }
        }
		stage('Test API') { 
            steps {
				sh """
					cd api
					cd
					mvn test
				"""
            }
        }
		stage('Report API') {
			steps {
				junit 'api/target/surefire-reports/*.xml'
			}
		}
		stage('Install Webapplikation') { 
            steps { 
               sh """
					cd bookyourhospital
					cd
					npm install
				""" 
            }
        }
		stage('Build Webapplikation') { 
            steps { 
               sh """
					cd bookyourhospital
					cd
					npm run build
				""" 
            }
        }
		stage('Test Webapplikation') { 
            steps {
				sh """
					cd bookyourhospital
					cd
					npm test -- --watchAll=false
				"""
            }
        }
    }
	post {
		always {
			emailext attachLog: true, body: """Job: ${env.JOB_NAME}:${env.BUILD_NUMBER}\nStatus: ${currentBuild.result}""",
				subject: "[Jenkins] REPORT ${currentBuild.fullDisplayName} - ${currentBuild.result}",
				to: "gru18163@spengergasse.at"
		}
	}
}