pipeline {
  agent { label 'master' }

  stages {
    stage ('Build') {
      steps {
        sh """
          docker build \
            --pull \
            --no-cache \
            --target builder .
        """
      }
    }

    stage ('Runner Build') {
      steps {
        sh """
          docker build \
            --target runner \
            --t grocery-backend-runner:latest .
        """
      }
    }

    stage ('Deploy') {
      when {
        branch 'master'
      }
      steps {
        sh 'docker container rm --force grocery-backend-runner || true'
        sh 'docker container run --name grocery-backend -p 8080:8080 -d grocery-backend-runner:latest'
      }
    }
  }
}
