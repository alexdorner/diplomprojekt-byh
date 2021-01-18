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
    }
}