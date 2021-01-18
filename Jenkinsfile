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
               echo 'This is a minimal pipeline.' 
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